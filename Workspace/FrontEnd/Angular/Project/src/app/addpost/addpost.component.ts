import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AddServiceService } from '../add-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-addpost',
  templateUrl: './addpost.component.html',
  styleUrls: ['./addpost.component.css']
})
export class AddpostComponent implements OnInit {

  constructor(private addservice: AddServiceService) { }
  
  submitForm(form: NgForm) {
    console.log(form.value);
    this.addservice.postData(form.value).subscribe(response => {
      console.log(response);
      form.reset();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
