import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TimeFormComponent } from './time-form/time-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
import { TimeRankingComponent } from './time-ranking/time-ranking.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTableModule} from '@angular/material/table';



@NgModule({
  declarations: [
    TimeFormComponent,
    TimeRankingComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    MatSidenavModule,
    MatTableModule
  ]
})
export class TimeModule { }
