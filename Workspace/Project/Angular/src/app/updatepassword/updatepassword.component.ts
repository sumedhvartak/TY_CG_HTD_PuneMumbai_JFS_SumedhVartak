import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-updatepassword',
  templateUrl: './updatepassword.component.html',
  styleUrls: ['./updatepassword.component.css']
})
export class UpdatepasswordComponent implements OnInit {
  error = null;
  message = null;
  constructor(private medicineservice: MedicalService) { }

  update(updatePasswordForm: NgForm) {
    this.medicineservice.updatePassword(updatePasswordForm.value).subscribe(response => {
      console.log(response);
      if (response && response.statusCode === 201) {
        this.message = response.description;
      } else if (response && response.statusCode === 401) {
        this.error = response.description;
      }
    }, err => {
      console.log(err);
    });
    updatePasswordForm.reset();
  }

  ngOnInit() {
  }

}
