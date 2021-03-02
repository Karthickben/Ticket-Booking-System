import { Component, OnInit, Output, EventEmitter } from "@angular/core";

import { Cosmetic } from "../cosmetic.model";

@Component({
  selector: "app-cosmetic-list",
  templateUrl: "./cosmetic-list.component.html",
  styleUrls: ["./cosmetic-list.component.css"],
})
export class CosmeticListComponent implements OnInit {
  cosmeticsList: Cosmetic[] = [
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
    {
      name: "Lipstick",
      color: "red",
      imagePath:
        "https://images-na.ssl-images-amazon.com/images/I/51CS07LMOWL._SY450_.jpg",
      description: "Lipstick",
      price: 100.0,
    },
    {
      name: "Nail Polish",
      color: "Yellow",
      imagePath:
        "https://m.media-amazon.com/images/I/61niKli2YiL._AC_UL320_.jpg",
      description: "NailPolish",
      price: 50.0,
    },
  ];

  @Output() cosmeticClicked = new EventEmitter<Cosmetic>();

  constructor() {}

  ngOnInit() {}

  clickCosmetics(item: Cosmetic) {
    console.log(item);
    this.cosmeticClicked.emit(item);
  }
}
