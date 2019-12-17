import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Loginresponse } from './loginresponse';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MedicalService {

  bills: any[];

  constructor(private http: HttpClient) { }

 getMedicine() {
   return this.http.get<any>(`http://localhost:8080/parallelrest/showAllProduct`);
 }

 getUser() {
   return this.http.get<any>(`http://localhost:8080/parallelrest/showAllUser`);
 }

 putMedicine(data): Observable<any> {
  return this.http.put<any>(`http://localhost:8080/parallelrest/addProduct`, data);
 }

 putUser(data): Observable<any> {
  return this.http.put<any>(`http://localhost:8080/parallelrest/addRegister`, data);
 }

 deleteProduct(data): Observable<any> {
   return this.http.delete<any>(`http://localhost:8080/parallelrest/deleteProduct?productId=${data.productId}`, data);
 }

 updateProduct(data): Observable<any> {
   // tslint:disable-next-line: max-line-length
   return this.http.post<any>(`http://localhost:8080/parallelrest/updateProduct?productId=${data.productId}&productPrice=${data.productPrice}&quantity=${data.quantity}`, data);
 }

 deleteUserS(data): Observable<any> {
  // tslint:disable-next-line: max-line-length
  return this.http.delete<any>(`http://localhost:8080/parallelrest/removeUser?userId=${data.userId}`, data);
 }

 login(data) {
   return this.http.get<any>(`http://localhost:8080/parallelrest/userLogin?email=${data.email}&password=${data.password}`);
 }

 getCart(): Observable<any> {
   return this.http.get<any>(`http://localhost:8080/parallelrest/showCart`);
 }

 deleteCart(data): Observable<any> {
  return this.http.delete<any>(`http://localhost:8080/parallelrest/deleteItem?cartId=${data.cartId}`);
 }

 deleteAllCart(data): Observable<any>{
  return this.http.delete<any>(`http://localhost:8080/parallelrest/deleteAllItem`);
 }

 addCart(data): Observable<any> {
  return this.http.put<any>(`http://localhost:8080/parallelrest/addCart?productId=${data.productId}`, data);
 }

 addMessage(data): Observable<any> {
   // tslint:disable-next-line: max-line-length
   return this.http.put<any>(`http://localhost:8080/parallelrest/addMessage?userId=${data.userId}&message=${data.message}&type=${data.type}&question=${data.question}`, data);

 }

 getMessage(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/parallelrest/showAllMessage`);
 }

 getBill() {
   return this.http.get<any>(`http://localhost:8080/parallelrest/getBill`).subscribe(data => {
    console.log(data);
    this.bills = data;
   }, err => {
     console.log(err);
   });
 }

 updatePassword(data): Observable<any> {
   return this.http.post<any>(`http://localhost:8080/parallelrest/updateUser`, data);
 }



}
