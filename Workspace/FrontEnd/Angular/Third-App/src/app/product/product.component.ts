import { Component, OnInit } from '@angular/core';
import { Product } from '../product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[] = [
    {
      name: 'Samsung',
      imageURL: 'https://cdn.pixabay.com/photo/2016/03/27/19/43/smartphone-1283938__340.jpg',
      price: 56000,
      detail: 'The latest phone in market'
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
