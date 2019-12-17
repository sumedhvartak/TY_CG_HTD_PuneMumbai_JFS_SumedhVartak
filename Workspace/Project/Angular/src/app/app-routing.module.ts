import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ViewAllProductComponent } from './view-all-product/view-all-product.component';
import { ViewAllUserComponent } from './view-all-user/view-all-user.component';
import { AddProductComponent } from './add-product/add-product.component';
import { AuthGuard } from './auth.guard';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { CartComponent } from './cart/cart.component';
import { ViewuserproductComponent } from './viewuserproduct/viewuserproduct.component';
import { AddmessageUserComponent } from './addmessage-user/addmessage-user.component';
import { ViewmessageuserComponent } from './viewmessageuser/viewmessageuser.component';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';
import { ProductdisplayComponent } from './productdisplay/productdisplay.component';
import { UserSendMessageComponent } from './user-send-message/user-send-message.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'viewAllProduct', component: ViewAllProductComponent, canActivate: [AuthGuard], data: {type: ['admin']}},
  {path: 'viewAllUser', component: ViewAllUserComponent},
  {path: 'addProduct', component: AddProductComponent},
  {path: 'cartview', component: CartComponent},
  {path: 'viewuserproduct', component: ViewuserproductComponent},
  {path: 'addmessageuser', component: AddmessageUserComponent},
  {path: 'viewmessageuser', component: ViewmessageuserComponent},
  {path: 'updatepassword', component: UpdatepasswordComponent},
  {path: 'productdisplay', component: ProductdisplayComponent},
  {path: 'usersendmessage', component: UserSendMessageComponent},
  {path: 'pagenotfound', component: PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
