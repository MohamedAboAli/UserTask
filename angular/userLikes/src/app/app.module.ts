import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { IgxListModule, IgxAvatarModule, IgxIconModule } from 'igniteui-angular';
import { HttpClientModule } from "@angular/common/http";
import { UserdetailsComponent } from './users/userdetails/userdetails.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UserdetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
     HttpClientModule,
     IgxListModule,
      IgxAvatarModule,
    IgxIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
