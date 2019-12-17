import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MedicalService } from '../medical.service';

@Component({
  selector: 'app-addmessage-user',
  templateUrl: './addmessage-user.component.html',
  styleUrls: ['./addmessage-user.component.css']
})
export class AddmessageUserComponent implements OnInit {

  error = null;
  send: any[];
  constructor(private medicalService: MedicalService) { }

  sendMessage(addMessageUser: NgForm) {
    console.log(addMessageUser.value);
    this.medicalService.addMessage(addMessageUser.value).subscribe(response => {
      console.log(response);
      if (response && response.statusCode === 201) {
        this.send = response.description;
      } else if (response && response.statusCode === 401) {
        this.error = response.description;
      }
    },
    err => {
      console.log(err);
    });
    addMessageUser.reset();
  }

  ngOnInit() {
  }

}
