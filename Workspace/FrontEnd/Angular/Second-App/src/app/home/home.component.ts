import { Component, OnInit } from '@angular/core';
import { SampleService } from '../sampleservice.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public sampleService:SampleService){
    console.log(this.sampleService.laptop);
    

  }

   ngOnInit() {
  }

}
