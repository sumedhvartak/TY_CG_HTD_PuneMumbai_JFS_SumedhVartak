import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  carts: any[];
  message = null;
  error = null;

  constructor(private medicineService: MedicalService) {
    this.medicineService.getCart().subscribe(data  => {
      console.log(data.cartList);
      this.carts = data.cartList;
      this.medicineService.getBill();
    }, err => {
      console.log(err);
    });
  }

  delete(cart) {
    this.medicineService.deleteCart(cart).subscribe(response =>{
      console.log(response);
      this.carts.splice(this.carts.indexOf(cart), 1);
      console.log('Cart Deleted');
      this.medicineService.getCart();
      if (response && response.statusCode === 201) {
        this.message = response.description;
      } else if (response && response.statusCode === 401) {
        this.error = response.description;
      }
    }, err => {
      console.log(err);
    });
  }

  clearCart(data){
    this.medicineService.deleteAllCart(data).subscribe(response =>{
      console.log(response);
      console.log('Cart Deleted');
      this.medicineService.getCart();
      if (response && response.statusCode === 201) {
        this.message = response.description;
      } else if (response && response.statusCode === 401) {
        this.error = response.description;
      }
    }, err => {
      console.log(err);
    });
  }

  
  ngOnInit() {
  }

}
