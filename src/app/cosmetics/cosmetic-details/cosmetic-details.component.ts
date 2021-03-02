import { Component, Input, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { relative } from "path";
import { Cosmetic } from "../cosmetic.model";

@Component({
  selector: "app-cosmetic-details",
  templateUrl: "./cosmetic-details.component.html",
  styleUrls: ["./cosmetic-details.component.css"],
})
export class CosmeticDetailsComponent implements OnInit {
  @Input("InputCosmetic") cosmeticItem: Cosmetic;
  constructor(private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {}

  addToCart() {
    this.router.navigate(
      [`/cart/${this.cosmeticItem.name}/${this.cosmeticItem.price}`],
      {
        relativeTo: this.route,
      }
    );
  }
}
