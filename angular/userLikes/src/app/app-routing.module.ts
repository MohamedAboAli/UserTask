import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersComponent } from "src/app/users/users.component";

const routes: Routes = [
   { path: '', redirectTo: 'usersDetails', pathMatch: 'full'},
  { path: 'usersDetails', component: UsersComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
