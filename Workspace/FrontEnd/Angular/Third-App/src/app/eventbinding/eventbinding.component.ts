import { Component, OnInit } from '@angular/core';
import { Student } from '../student';

@Component({
  selector: 'app-eventbinding',
  templateUrl: './eventbinding.component.html',
  styleUrls: ['./eventbinding.component.css']
})
export class EventbindingComponent implements OnInit {

  students: Student[] = [
    {
      name: 'Samurai',
      std: 1,
      rollno: 45,
      sex: 'Shemale'
    },
    {
      name: 'Sanju',
      std: 3,
      rollno: 27,
      sex: 'Male'
    }
  ];

  constructor() { }

  DeleteStudent(x: Student) {
    const index = this.students.indexOf(x);
    this.students.splice(index, 1);
  }

  ngOnInit() {
  }

}
