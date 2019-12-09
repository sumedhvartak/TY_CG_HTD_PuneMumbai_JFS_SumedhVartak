import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  selectedEmployee: Employee  = {
    empID: null,
    name: null,
    phone: null,
    email: null,
    status: null,
    pk: null
  };

  constructor(public employeeservice: EmployeeService) { 
    this.employeeservice.getData();
    console.log(employeeservice.employees);
  }

  selectEmployee(employee: Employee){
    this.selectedEmployee = employee;
  }

  deleteEmployee(employee: Employee){
    this.employeeservice.deleteData(employee).subscribe(response => {
      console.log(response);
      console.log('deleted one employee');
      //to update the data again
      this.employeeservice.getData();
    }, err=>{
      console.log(err);
    });
  }

  submitForm(form: NgForm){
    this.employeeservice.putData(form.value).subscribe(response =>{
      console.log(response);
      form.reset();
    }, err => {
      console.log(err);
    })
  }

  ngOnInit() {
  }

}
