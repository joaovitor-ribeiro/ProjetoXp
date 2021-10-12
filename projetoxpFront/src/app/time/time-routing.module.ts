import { TimeFormComponent } from './time-form/time-form.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from '../usuario/guard/auth.guard';

const campeonatoRoutes = [
  {path: '', component: TimeFormComponent},
  {path: ':id/cadastro', component: TimeFormComponent, canActivate: [AuthGuard]},
  {path: ':id/editar/:timeCapitao', component: TimeFormComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(campeonatoRoutes)],
  exports: [RouterModule]
})

export class TimeRoutingModule { }
