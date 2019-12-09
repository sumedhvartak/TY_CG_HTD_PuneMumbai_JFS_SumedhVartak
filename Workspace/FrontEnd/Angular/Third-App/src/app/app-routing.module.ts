import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BikeComponent } from './bike/bike.component';
import { CarComponent } from './car/car.component';
import { MovieComponent } from './movie/movie.component';
import { LaptopComponent } from './laptop/laptop.component';
import { MobileComponent } from './mobile/mobile.component';
import { ProductComponent } from './product/product.component';
import { EventbindingComponent } from './eventbinding/eventbinding.component';
import { EmployeeComponent } from './employee/employee.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'bike', component: BikeComponent},
  {path: 'car', component: CarComponent},
  {path: 'movie', component: MovieComponent},
  {path: 'laptop', component: LaptopComponent},
  {path: 'mobile', component: MobileComponent},
  {path: 'product', component: ProductComponent},
  {path: 'eventbinding', component: EventbindingComponent},
  {path: 'employee', component: EmployeeComponent},
  {path: 'addemployee', component: AddemployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
