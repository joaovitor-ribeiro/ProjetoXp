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
import { CampeonatoDetalhesComponent } from './campeonato-detalhes/campeonato-detalhes.component';
import {MatTableModule} from '@angular/material/table';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTabsModule} from '@angular/material/tabs';
import { CampeonatoDetalhesResolver } from './guards/campeonato-detalhes.resolver';
import {MatSelectModule} from '@angular/material/select';


@NgModule({
  declarations: [
    CampeonatoComponent,
    CampeonatoFormComponent,
    CampeonatoDetalhesComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    CampeonatoRoutingModule,
    MatTableModule,
    MatSidenavModule,
    MatTabsModule,
    MatSelectModule
  ],
  providers: [
    CampeonatoService,
    CampeonatoFormService,
    CampeonatoResolver,
    CampeonatoFormResolver,
    CampeonatoDetalhesResolver,
  ]
})
export class CampeonatoModule { }
