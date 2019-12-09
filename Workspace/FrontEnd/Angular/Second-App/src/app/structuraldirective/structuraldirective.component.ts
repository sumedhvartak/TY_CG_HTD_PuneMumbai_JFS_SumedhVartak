import { Component, OnInit } from '@angular/core';
import { Student } from '../student';

@Component({
  selector: 'app-structuraldirective',
  templateUrl: './structuraldirective.component.html',
  styleUrls: ['./structuraldirective.component.css']
})
export class StructuraldirectiveComponent implements OnInit {
  flag = false;
  person = 'Dipa';
  students: Student[] = [
    {
      id: 123,
      name: 'Samurai',
      age: 70,
      degree: 'BE'
    },
    {
      id: 1234,
      name: 'Sam',
      age: 72,
      degree: 'BE'
    },
    {
      id: 1235,
      name: 'Samu',
      age: 76,
      degree: 'BTech'
    },
    {
      id: 1236,
      name: 'Sachu',
      age: 7,
      degree: 'lkg'
    }
  ]

  constructor() {
    setTimeout(() => {
      this.flag = true;
    }, 2000 )
  }

  deleteStudent(x: Student) {
    const index = this.students.indexOf(x);
    this.students.splice(index, 1)
  }

  ngOnInit() {
  }

}
