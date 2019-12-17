import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  canActivate(
    next: ActivatedRouteSnapshot): boolean {
      const userTypeArray = next.data.type;
      const userDetails = JSON.parse(localStorage.getItem('key'));
      for (const user in userTypeArray) {
        if (userDetails && userDetails.type === userTypeArray[user]) {
          return true;
        } else {
          return false;
        }
      }
  }

}
