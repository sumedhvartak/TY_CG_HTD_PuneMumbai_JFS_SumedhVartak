import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  error = null;
  message = null;
  constructor(private medicalService: MedicalService) { }

  register(registrationForm: NgForm) {
    console.log(registrationForm.value);
    this.medicalService.putUser(registrationForm.value).subscribe(response => {
      console.log(response);
      registrationForm.reset();
      if (response && response.statusCode === 201) {
        console.log('User Added');
        this.message = response.description;
      } else if (response && response.statusCode === 401) {
        this.error = response.description;
      }
    },
    err => {
      console.log(err);
    });
    registrationForm.reset();
  }
  ngOnInit() {
  }

}
