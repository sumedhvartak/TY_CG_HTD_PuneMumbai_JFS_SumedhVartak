import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';

@Component({
  selector: 'app-view-all-user',
  templateUrl: './view-all-user.component.html',
  styleUrls: ['./view-all-user.component.css']
})
export class ViewAllUserComponent implements OnInit {
  users: any[];
  error = null;
  message = null;
  constructor(private medicalService: MedicalService) {
    this.medicalService.getUser().subscribe(data => {
      console.log(data.userList);
      this.users = data.userList;
    }, err => {
      console.log(err);
    });
   }

   deleteUser(user) {
    this.medicalService.deleteUserS(user).subscribe(response => {
      console.log(response);
      this.users.splice(this.users.indexOf(user), 1);
      console.log('User Deleted');
      if (response && response.statusCode === 201) {
        this.message = response.description;
      } else if (response && response.statusCode === 401) {
        this.error = response.description;
      }
    }, err => {
      console.log(err);
    });
   }


  ngOnInit() {
  }

}
