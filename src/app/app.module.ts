import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpModule } from "@angular/http";

import { AppComponent } from "./app.component";
import { CosmeticsComponent } from "./cosmetics/cosmetics.component";
import { CosmeticListComponent } from "./Cosmetics/cosmetic-list/cosmetic-list.component";
import { CosmeticItemComponent } from "./cosmetics/cosmetic-list/cosmetic-item/cosmetic-item.component";
import { CosmeticDetailsComponent } from "./cosmetics/cosmetic-details/cosmetic-details.component";
import { HeaderComponent } from "./header/header.component";
import { CartComponent } from "./cart/cart.component";
import { UserSingInComponent } from "./user-sing-in/user-sing-in.component";
import { UserSingUpComponent } from "./user-sing-up/user-sing-up.component";
import { AppRouteModule } from "./app.route.module";
import { AuthGuard } from "./auth-guard.service";
import { AuthService } from "./authService";
// import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    CosmeticsComponent,
    CosmeticListComponent,
    CosmeticItemComponent,
    CosmeticDetailsComponent,
    HeaderComponent,
    CartComponent,
    UserSingInComponent,
    UserSingUpComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRouteModule,
    ReactiveFormsModule,
    // HttpClientModule,
  ],
  providers: [AuthGuard, AuthService],
  bootstrap: [AppComponent],
})
export class AppModule {}
