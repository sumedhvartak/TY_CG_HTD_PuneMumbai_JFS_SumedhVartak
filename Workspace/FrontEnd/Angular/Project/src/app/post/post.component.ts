import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  gitUsers: [];

  constructor(http: HttpClient) {
    http.get<any>('https://jsonplaceholder.typicode.com/posts').subscribe(data => {

      console.log(data);
      this.gitUsers = data;
    }, err =>{
     console.log(err);
    });
   }


  ngOnInit() {
  }

}
