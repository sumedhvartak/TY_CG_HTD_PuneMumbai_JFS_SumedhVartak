import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddServiceService {

  api = 'https://jsonplaceholder.typicode.com/posts';


  constructor(private http: HttpClient) { }

  postData(data){
    return this.http.post(`${this.api}employees.json`, data);
  }

  getData(){
    this.http.get(`${this.api}employees.json`).subscribe(data => {
      console.log(data);
      const employeeArray = [];
      for(const key in data){
        if(data.hasOwnProperty(key)){
          employeeArray.push({...data[key], pk: key});
        }
      }
    });
  }

}
