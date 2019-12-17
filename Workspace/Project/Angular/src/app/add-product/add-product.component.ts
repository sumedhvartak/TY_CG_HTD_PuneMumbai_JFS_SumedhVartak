import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  error = null;
  message = null;
  constructor(private medicineService: MedicalService) {}
    submitForm(addProduct: NgForm) {
      console.log(addProduct.value);
      this.medicineService.putMedicine(addProduct.value).subscribe(response => {
        console.log(response);
        addProduct.reset();
        if (response && response.statusCode === 201) {
          this.message = response.description;
        } else if (response && response.statusCode === 401) {
          this.error = response.description;
        }
      },
      err => {
        console.log(err);
      });
   }

  ngOnInit() {
  }

}
