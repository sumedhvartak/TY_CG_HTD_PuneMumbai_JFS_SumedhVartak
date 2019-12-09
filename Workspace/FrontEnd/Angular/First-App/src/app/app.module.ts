import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AboutComponent } from './about/about.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BikeComponent } from './bike/bike.component';
import { CarComponent } from './car/car.component';
import { PlaneComponent } from './plane/plane.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ContactUsComponent,
    LoginComponent,
    RegisterComponent,
    AboutComponent,
    PageNotFoundComponent,
    BikeComponent,
    CarComponent,
    PlaneComponent
  
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent},
      { path:'about',component: AboutComponent,children:[
        {path:'car',component:CarComponent},
        {path:'bike',component:BikeComponent},
        {path:'plane',component:PlaneComponent}
      ]},
      { path:'contact-us', component:ContactUsComponent},
      {path:'login',component:LoginComponent},
      {path:'register',component:RegisterComponent},
      { path:'**',component:PageNotFoundComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
