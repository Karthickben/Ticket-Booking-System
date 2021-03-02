import { Component, OnInit } from "@angular/core";
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "app/authService";

@Component({
  selector: "app-user-sing-in",
  templateUrl: "./user-sing-in.component.html",
  styleUrls: ["./user-sing-in.component.css"],
})
export class UserSingInComponent implements OnInit {
  signInForm: FormGroup;
  constructor(
    private authService: AuthService,
    private route: Router,
    private builder: FormBuilder
  ) {}

  logInUser() {
    console.log("Logging In....");
    this.authService.logIn();
  }

  onSubmit() {
    console.log(this.signInForm.value);
  }

  ngOnInit() {
    this.signInForm = this.builder.group({
      userName: ["Example@gmail.com", [Validators.required]],
      password: ["", [Validators.required]],
    });
  }
}
