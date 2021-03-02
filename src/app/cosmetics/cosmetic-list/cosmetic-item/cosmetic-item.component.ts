import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { Cosmetic } from "../../cosmetic.model";
@Component({
  selector: "app-cosmetic-item",
  templateUrl: "./cosmetic-item.component.html",
  styleUrls: ["./cosmetic-item.component.css"],
})
export class CosmeticItemComponent implements OnInit {
  @Input() item: Cosmetic;

  constructor() {}

  ngOnInit() {}
}
