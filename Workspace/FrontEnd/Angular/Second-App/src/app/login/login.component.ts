import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  users = [];

  constructor() { }

  printForm(loginForm: NgForm){
    console.log(loginForm.value);
    //to store the data in array
    this.users.push(loginForm.value);
    // printing the array
    console.log(this.users);
    loginForm.reset();

    
  }
  ngOnInit() {
  }

}
