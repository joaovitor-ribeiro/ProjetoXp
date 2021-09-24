import { CampeonatoModule } from './campeonato/campeonato.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from './shared/shared.module';
import { TimeFormComponent } from './time/time-form/time-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UsuarioModule } from './usuario/usuario.module';
import { TimeModule } from './time/time.module';
import {MatMenuModule} from '@angular/material/menu';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    CampeonatoModule,
    UsuarioModule,
    TimeModule,
    BrowserAnimationsModule,
    MatMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
