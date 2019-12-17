import { Component, OnInit } from '@angular/core';
import { MedicalService } from '../medical.service';

@Component({
  selector: 'app-productdisplay',
  templateUrl: './productdisplay.component.html',
  styleUrls: ['./productdisplay.component.css']
})
export class ProductdisplayComponent implements OnInit {

  medicines: any[];

  constructor(private medicineService: MedicalService) {
    this.medicineService.getMedicine().subscribe(data => {
      console.log(data.productList);
      this.medicines = data.productList;
    }, err => {
      console.log(err);
    });
  }



  ngOnInit() {
  }

}
