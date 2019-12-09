import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  selectedEmployee: Employee  = {
    empID:null,
    name:null,
    phone:null,
    email:null,
    status:null,
    pk:null


  };
  


  constructor(public employeeservice: EmployeeService) { 
    this.employeeservice.getData();
    console.log(employeeservice.employees);
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

  selectEmployee(employee: Employee){
    this.selectedEmployee = employee;
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
