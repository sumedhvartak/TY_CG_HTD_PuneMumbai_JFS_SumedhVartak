import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';

@Component({
  selector: 'app-viewuserproduct',
  templateUrl: './viewuserproduct.component.html',
  styleUrls: ['./viewuserproduct.component.css']
})
export class ViewuserproductComponent implements OnInit {

  medicines: any[];
  send: any[];
  error: any[];

  constructor(private medicineService: MedicalService) {
    this.medicineService.getMedicine().subscribe(data => {
      console.log(data.productList);
      this.medicines = data.productList;
    }, err => {
      console.log(err);
    });
  }

  AddCart(medicine) {
    console.log(medicine.value);
    this.medicineService.addCart(medicine).subscribe(response => {
      console.log(response);
      if (response && response.statusCode === 201) {
        this.send = response.description;
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
