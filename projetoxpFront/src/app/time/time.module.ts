import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TimeFormComponent } from './time-form/time-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { TimeRankingComponent } from './time-ranking/time-ranking.component';
import { TimeRoutingModule } from './time-routing.module';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTableModule} from '@angular/material/table';
import {MatSelectModule} from '@angular/material/select';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { TimeDetalhesComponent } from './time-detalhes/time-detalhes.component';
import { MatTabsModule } from '@angular/material/tabs';



@NgModule({
  declarations: [
    TimeFormComponent,
    TimeRankingComponent,
    TimeDetalhesComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
    MatSidenavModule,
    MatSelectModule,
    TimeRoutingModule,
    MatSnackBarModule,
    MatTableModule,
    MatTabsModule,
  ]
})
export class TimeModule { }
