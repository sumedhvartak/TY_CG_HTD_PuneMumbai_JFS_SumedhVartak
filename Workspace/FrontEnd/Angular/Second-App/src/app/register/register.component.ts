import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { CustomValidator } from './custom.validator';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor() { }

  get email(){
    return this.registerForm.get('email');
  }

  get password(){
    return this.registerForm.get('password');
  }

  registerForm = new FormGroup({
    email: new FormControl('',[Validators.required,Validators.email,Validators.minLength(8),CustomValidator.noSpace]),
    password: new FormControl('',[Validators.required,Validators.minLength(8)])
  })

  printForm(form:NgForm){
    console.log(form.value);
  }

  ngOnInit() {
  }

}
