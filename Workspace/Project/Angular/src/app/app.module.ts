import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ViewAllProductComponent } from './view-all-product/view-all-product.component';
import { ViewAllUserComponent } from './view-all-user/view-all-user.component';
import { AddProductComponent } from './add-product/add-product.component';
import { AddUserComponent } from './add-user/add-user.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { CartComponent } from './cart/cart.component';
import { ViewuserproductComponent } from './viewuserproduct/viewuserproduct.component';
import { AddmessageUserComponent } from './addmessage-user/addmessage-user.component';
import { ViewmessageuserComponent } from './viewmessageuser/viewmessageuser.component';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';
import { ProductdisplayComponent } from './productdisplay/productdisplay.component';
import { UserSendMessageComponent } from './user-send-message/user-send-message.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    ViewAllProductComponent,
    ViewAllUserComponent,
    AddProductComponent,
    AddUserComponent,
    PagenotfoundComponent,
    CartComponent,
    ViewuserproductComponent,
    AddmessageUserComponent,
    ViewmessageuserComponent,
    UpdatepasswordComponent,
    ProductdisplayComponent,
    UserSendMessageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
