import { Injectable, inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class UserGuardGuard{

constructor(private router:Router,private authService:LoginService){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
      if (this.authService.isLoggedIn() && this.authService.getUserRole() == "NORMAL") {
        return true;
      }
      this.router.navigate(['/login'])
    return false;
  }
  
}
export const AuthGuard:CanActivateFn=(next: ActivatedRouteSnapshot,state: RouterStateSnapshot):boolean=>{
  return inject(UserGuardGuard).canActivate(next,state);
}
