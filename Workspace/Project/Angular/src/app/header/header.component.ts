import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MedicalService } from '../medical.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  userName: string;

  constructor(private router: Router, private medical: MedicalService) { }

  isLogin() {
    const user = JSON.parse(localStorage.getItem('key'));
    if (user) {
      this.userName = user.userName;
      return true;
    }
  }

  isAdminLogin() {
    const user = JSON.parse(localStorage.getItem('key'));
    if (user && user.type === 'admin') {
      console.log('Admin');
      return true;
    } else {
      return false;
    }
  }

  isUserLogin() {
    const user = JSON.parse(localStorage.getItem('key'));
    if (user && user.type === 'user') {
      console.log('User');
      return true;
    } else {
      return false;
    }
  }

  logoutUser() {
    localStorage.removeItem('key');
    this.router.navigateByUrl('/');
  }

  ngOnInit() {
  }

}
