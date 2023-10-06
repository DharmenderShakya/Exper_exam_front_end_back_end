import { Injectable, inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChildFn, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';
import { state } from '@angular/animations';

@Injectable({
  providedIn: 'root'
})
export class AdminGaurdGuard{
  constructor(private router:Router,private authService:LoginService){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
      if (this.authService.isLoggedIn() && this.authService.getUserRole()=="ADMIN") {
        return true;
      }
      this.router.navigate(['/login']);
    return false;
  }
  
}
export const AdminAuth:CanActivateFn=(next: ActivatedRouteSnapshot,state: RouterStateSnapshot):boolean=>{
  return inject(AdminGaurdGuard).canActivate(next,state);
}

