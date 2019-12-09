import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { CarComponent } from './car/car.component';
import { CarDetailComponent } from './car-detail/car-detail.component';
import { BikeComponent } from './bike/bike.component';
import { BikeDetailComponent } from './bike-detail/bike-detail.component';
import { MovieComponent } from './movie/movie.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';
import { LaptopComponent } from './laptop/laptop.component';
import { LaptopDetailComponent } from './laptop-detail/laptop-detail.component';
import { MobileComponent } from './mobile/mobile.component';
import { MobileDetailComponent } from './mobile-detail/mobile-detail.component';
import { ProductComponent } from './product/product.component';
import { EventbindingComponent } from './eventbinding/eventbinding.component';
import { EmployeeComponent } from './employee/employee.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CarComponent,
    CarDetailComponent,
    BikeComponent,
    BikeDetailComponent,
    MovieComponent,
    MovieDetailComponent,
    LaptopComponent,
    LaptopDetailComponent,
    MobileComponent,
    MobileDetailComponent,
    ProductComponent,
    EventbindingComponent,
    EmployeeComponent,
    AddemployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
