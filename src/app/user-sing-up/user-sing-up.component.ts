import { Component, OnInit, ViewChild } from "@angular/core";
import { NgForm } from "@angular/forms";

@Component({
  selector: "app-user-sing-up",
  templateUrl: "./user-sing-up.component.html",
  styleUrls: ["./user-sing-up.component.css"],
})
export class UserSingUpComponent implements OnInit {
  @ViewChild("f") form: NgForm;
  constructor() {}

  ngOnInit() {}

  onSubmit() {
    console.log("Forms get Submitted");
    console.log(this.form);
  }
}
