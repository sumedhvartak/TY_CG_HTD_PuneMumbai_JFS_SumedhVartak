import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BindingComponent } from './binding/binding.component';

import { HomeComponent } from './home/home.component';
import { TwoWayDatabindingComponent } from './two-way-databinding/two-way-databinding.component';
import { StructuraldirectiveComponent } from './structuraldirective/structuraldirective.component';
import { ProductcomponentComponent } from './productcomponent/productcomponent.component';
import { ParentComponent } from './parent/parent.component';
import { BikesComponent } from './bikes/bikes.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';



const routes: Routes = [
  {path:'',component: HomeComponent},
  {path:'data-binding', component:BindingComponent},
  {path: 'two-way', component:TwoWayDatabindingComponent},
  {path:'structuredirective',component:StructuraldirectiveComponent},
  {path: 'productcomponent',component:ProductcomponentComponent},
  {path: 'parent', component:ParentComponent},
  {path:'bikes',component:BikesComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
