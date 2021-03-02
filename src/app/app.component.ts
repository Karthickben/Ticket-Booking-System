import { Component, Input } from "@angular/core";
import { Cosmetic } from "./cosmetics/cosmetic.model";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  title = "Cosmetic Mart";
  // view: string = "home";

  // wasCartClicked(event: string) {
  //   console.log(event);
  //   this.view = event;
  // }

  // wasHomeClicked(event: string) {
  //   console.log(event);
  //   this.view = event;
  // }
}
