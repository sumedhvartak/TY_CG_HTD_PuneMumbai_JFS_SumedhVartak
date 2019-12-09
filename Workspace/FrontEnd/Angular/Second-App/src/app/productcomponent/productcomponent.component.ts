import { Component, OnInit } from '@angular/core';
import { Product } from '../product';

@Component({
  selector: 'app-productcomponent',
  templateUrl: './productcomponent.component.html',
  styleUrls: ['./productcomponent.component.css']
})
export class ProductcomponentComponent implements OnInit {

  product: Product[] = [
    {
      name: 'MacBook Air',
      imageURL: 'https://cdn.pixabay.com/photo/2014/05/02/21/50/home-office-336378__340.jpg',
      price: 54999,
      detail: 'Very good laptop'
    },
    {
      name: 'SmartPhone',
      imageURL: 'https://cdn.pixabay.com/photo/2016/12/09/11/33/smartphone-1894723__340.jpg',
      price: 5499,
      detail: 'Very good phone'
    },
    {
      name: 'Cat',
      imageURL: 'https://cdn.pixabay.com/photo/2018/01/25/14/12/nature-3106213__340.jpg',
      price: 51499,
      detail: 'Very good cat'
    }
  ];

  constructor() { }

  ngOnInit() {
  }

}
