import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-binding',
  templateUrl: './binding.component.html',
  styleUrls: ['./binding.component.css']
})
export class BindingComponent implements OnInit {
  inputdata;
  flag = true;
  name='Samurai';
  imgURL = "https://cdn.pixabay.com/photo/2015/03/26/09/54/pug-690566__340.jpg"

  constructor() { 
    setInterval(() => {
      this.flag=!this.flag;
    },1000
    )
  }

  eventOccured(input)
  {
console.log(input.value);
console.log('Click event');
  }
    ngOnInit() {
  }

}
