import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TimeFormComponent } from './time-form/time-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [
    // TimeFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
  ]
})
export class TimeModule { }
