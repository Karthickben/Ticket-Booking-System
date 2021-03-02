import { Routes, RouterModule, Router } from "@angular/router";
import { AppComponent } from "./app.component";
import { CosmeticsComponent } from "./cosmetics/cosmetics.component";

import { CartComponent } from "./cart/cart.component";
import { UserSingInComponent } from "./user-sing-in/user-sing-in.component";
import { UserSingUpComponent } from "./user-sing-up/user-sing-up.component";
import { NgModule } from "@angular/core";
import { AuthGuard } from "./auth-guard.service";

const appRoutes: Routes = [
  { path: "", component: CosmeticsComponent },
  {
    path: "cart",
    canActivate: [AuthGuard],
    component: CartComponent,
    children: [{ path: ":name/:price", component: CartComponent }],
  },

  { path: "signIn", component: UserSingInComponent },
  { path: "signUp", component: UserSingUpComponent },
  { path: "**", component: CosmeticsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule],
})
export class AppRouteModule {}
