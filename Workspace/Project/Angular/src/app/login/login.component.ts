import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error = null;

  constructor(private medical: MedicalService, private router: Router) { }
  printForm(loginForm: NgForm) {
    this.error = null;
    console.log(loginForm.value);
    this.medical.login(loginForm.value).subscribe(data => {
      console.log(data);
      if (data && data.statusCode === 201) {
        localStorage.setItem('key', JSON.stringify(data.userBean));
        this.router.navigateByUrl('/');
      } else if (data && data.statusCode === 401) {
        this.error = data.description;
      }
    }, err => {
      console.log(err);
      this.error = err.error.errror.message;
    });
    loginForm.reset();
  }

  ngOnInit() {
  }

}
