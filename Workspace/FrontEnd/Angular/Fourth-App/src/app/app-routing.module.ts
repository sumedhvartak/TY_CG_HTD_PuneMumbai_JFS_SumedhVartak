import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UsersComponent } from './users/users.component';
import { GitUsersComponent } from './git-users/git-users.component';
import { MovieComponent } from './movie/movie.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EmployeesComponent } from './employees/employees.component';
import { PractComponent } from './pract/pract.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'users',component:UsersComponent},
  {path:'git-users',component:GitUsersComponent},
  {path:'movie',component:MovieComponent },
  {path:'add-employee',component:AddEmployeeComponent},
  {path:'employees',component:EmployeesComponent},
  {path:'pract',component:PractComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
