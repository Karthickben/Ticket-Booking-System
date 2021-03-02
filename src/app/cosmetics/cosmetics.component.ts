import { Component, Input, OnInit } from "@angular/core";
import { Cosmetic } from "./cosmetic.model";

@Component({
  selector: "app-cosmetics",
  templateUrl: "./cosmetics.component.html",
  styleUrls: ["./cosmetics.component.css"],
})
export class CosmeticsComponent implements OnInit {
  item: Cosmetic = null;

  constructor() {}

  ngOnInit() {}

  wasCosmeticCliked(item: Cosmetic) {
    console.log("Was Cosmetic Clicked...");
    this.item = item;
  }
}
