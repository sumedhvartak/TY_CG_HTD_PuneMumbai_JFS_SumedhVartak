import { Component, OnInit, Input } from '@angular/core';
import { Mobile } from '../mobile';

@Component({
  selector: 'app-mobile-detail',
  templateUrl: './mobile-detail.component.html',
  styleUrls: ['./mobile-detail.component.css']
})
export class MobileDetailComponent implements OnInit {
 @Input() mobile = Mobile;
  constructor() { }

  ngOnInit() {
  }

}
