import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';
import { Medicine } from '../medicine';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-view-all-product',
  templateUrl: './view-all-product.component.html',
  styleUrls: ['./view-all-product.component.css']
})
export class ViewAllProductComponent implements OnInit {

  medicines: any[];
  error = null;
  message = null;
  selectedMedicine: Medicine = {
    productId: null,
    productName: null,
    productPrice: null,
    quantity: null,
    status: null
  };
  constructor(private medicineService: MedicalService) {
    this.medicineService.getMedicine().subscribe(data => {
      console.log(data.productList);
      this.medicines = data.productList;
    }, err => {
      console.log(err);
    });
  }

  deleteMedicine(medicine) {
    this.medicineService.deleteProduct(medicine).subscribe(response => {
      console.log(response);
      this.medicines.splice(this.medicines.indexOf(medicine), 1);
      console.log('Medicine deleted');
      this.medicineService.getMedicine();
      if (response && response.statusCode === 201) {
        this.message = response.description;
      } else if (response && response.statusCode === 401) {
        this.error = response.description;
      }
    }, err => {
      console.log(err);
    });
  }

  selectMedicine(medicine: Medicine) {
    this.selectedMedicine = medicine;
  }

  updateForm(updateProduct: NgForm) {
    this.medicineService.updateProduct(updateProduct.value).subscribe(response => {
      console.log(response);
      updateProduct.reset();
      this.medicineService.getMedicine();
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
