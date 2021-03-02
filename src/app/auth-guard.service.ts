import { Injectable } from "@angular/core";
import { AuthService } from "./authService";
import {
  ActivatedRouteSnapshot,
  CanActivate,
  RouterStateSnapshot,
  Router,
} from "@angular/router";
import { Observable } from "rxjs/Observable";

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private route: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> | boolean | Promise<boolean> {
    return this.authService.isAuthenticated().then((authenticated: boolean) => {
      if (authenticated) {
        return true;
      } else {
        this.route.navigate(["/"]);
      }
    });
  }
}
