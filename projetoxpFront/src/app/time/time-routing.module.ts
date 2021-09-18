import { TimeFormComponent } from './time-form/time-form.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

const campeonatoRoutes = [
  {path: '', component: TimeFormComponent,},
];

@NgModule({
  imports: [RouterModule.forChild(campeonatoRoutes)],
  exports: [RouterModule]
})

export class TimeRoutingModule { }
