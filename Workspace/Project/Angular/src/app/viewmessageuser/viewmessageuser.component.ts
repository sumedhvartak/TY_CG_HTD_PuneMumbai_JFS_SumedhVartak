import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';

@Component({
  selector: 'app-viewmessageuser',
  templateUrl: './viewmessageuser.component.html',
  styleUrls: ['./viewmessageuser.component.css']
})
export class ViewmessageuserComponent implements OnInit {

  users: any[];

  constructor(private medicineservice: MedicalService) {
    this.medicineservice.getMessage().subscribe(data => {
      console.log(data.messageList);
      this.users = data.messageList;
    }, err => {
      console.log(err);
    });
   }

  ngOnInit() {
  }

}
