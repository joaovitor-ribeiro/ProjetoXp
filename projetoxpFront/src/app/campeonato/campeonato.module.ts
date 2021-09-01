import { CampeonatoComponent } from './campeonato.component';
import { SharedModule } from './../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CampeonatoFormComponent } from './campeonato-form/campeonato-form.component';
import { CampeonatoRoutingModule } from './campeonato-routing.module';
import { CampeonatoResolver } from './guards/campeonato.resolver';
import { HttpClientModule } from '@angular/common/http';
import { CampeonatoService } from './service/campeonato.service';
import { CampeonatoFormService } from './service/campeonato-form.service';
import { CampeonatoFormResolver } from './guards/campeonatoForm.resolver';

@NgModule({
  declarations: [
    CampeonatoComponent,
    CampeonatoFormComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    CampeonatoRoutingModule,
  ],
  providers: [
    CampeonatoService,
    CampeonatoFormService,
    CampeonatoResolver,
    CampeonatoFormResolver,
  ]
})
export class CampeonatoModule { }
