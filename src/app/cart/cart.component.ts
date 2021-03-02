import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Params } from "@angular/router";

@Component({
  selector: "app-cart",
  templateUrl: "./cart.component.html",
  styleUrls: ["./cart.component.css"],
})
export class CartComponent implements OnInit {
  item: string;
  price: string;
  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    // this.item = this.route.snapshot.params["name"];
    // this.price = this.route.snapshot.params["price"];

    this.route.params.subscribe((params: Params) => {
      this.item = params["name"];
      this.price = params["price"];
    });
  }
}
