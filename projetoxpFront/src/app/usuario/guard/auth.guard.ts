import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

constructor(public loginService: AuthenticationService, private router:Router) { }

canActivate(
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot,
): Observable<boolean> | boolean {

  if(this.loginService.isUserLoggedIn()){
    return true;
  }

  this.router.navigate(['/login']);

  return false;

}

}
