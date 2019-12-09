import { Component, OnInit } from '@angular/core';
import { Bike } from '../bike';

@Component({
  selector: 'app-bikes',
  templateUrl: './bikes.component.html',
  styleUrls: ['./bikes.component.css']
})
export class BikesComponent implements OnInit {

  
  bikes: Bike[] =[
    {
      brand:'Royal Enfield',
      imgURL:'https://cdn.pixabay.com/photo/2015/03/26/09/54/pug-690566__340.jpg',
      model:'dh',
      price:3340,
      specs:'cjs,sjFDF<'
    },
    {
      brand:' Enfield',
      imgURL:'https://cdn.pixabay.com/photo/2016/04/07/06/53/bmw-1313343__340.jpg',
      model:'dh',
      price:333440,
      specs:'cjs,sjFDF<'
    },
    {
      brand:'Rl Enfield',
      imgURL:'https://cdn.pixabay.com/photo/2015/03/26/09/54/pug-690566__340.jpg',
      model:'dh',
      price:3340,
      specs:'cjs,sjFDF<'
    }
  ];

  selectedBike: Bike = this.bikes[0];

  constructor() { }

  selectBike(bike){
    this.selectedBike = bike;
  }
  ngOnInit() {
  }

}
