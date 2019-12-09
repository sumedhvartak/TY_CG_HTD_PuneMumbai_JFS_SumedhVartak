import { Component, OnInit, Input } from '@angular/core';
import { Laptop } from '../laptop';

@Component({
  selector: 'app-laptop-detail',
  templateUrl: './laptop-detail.component.html',
  styleUrls: ['./laptop-detail.component.css']
})
export class LaptopDetailComponent implements OnInit {
  @Input() laptop:Laptop;
  constructor() { }

  ngOnInit() {
  }

}
