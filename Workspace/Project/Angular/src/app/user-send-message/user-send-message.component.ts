import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-send-message',
  templateUrl: './user-send-message.component.html',
  styleUrls: ['./user-send-message.component.css']
})
export class UserSendMessageComponent implements OnInit {

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
