import { Injectable } from "@angular/core";
import { Router } from "@angular/router";

@Injectable()
export class AuthService {
  constructor(private route: Router) {}
  loggedIn = false;

  logIn() {
    console.log("login..");
    this.loggedIn = true;
    this.route.navigate(["/"]);
  }
  logOut() {
    this.loggedIn = false;
  }

  isAuthenticated = () => {
    const promise = new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve(this.loggedIn);
      }, 400);
    });

    return promise;
  };
}
