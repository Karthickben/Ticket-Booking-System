import { Component, EventEmitter, OnInit, Output } from "@angular/core";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"],
})
export class HeaderComponent implements OnInit {
  @Output() cartClicked = new EventEmitter<string>();
  @Output() homeClicked = new EventEmitter<string>();
  constructor() {}

  ngOnInit() {}

  handleCartClick() {
    this.cartClicked.emit("cart");
  }

  handleHomeClick() {
    this.homeClicked.emit("home");
  }
}
