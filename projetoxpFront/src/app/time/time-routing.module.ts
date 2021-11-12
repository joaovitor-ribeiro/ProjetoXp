import { TimeResolver } from './guards/time.resolver';
import { TimeDetalhesComponent } from './time-detalhes/time-detalhes.component';
import { TimeFormComponent } from './time-form/time-form.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from '../usuario/guard/auth.guard';
import { TimeComponent } from './time.component';

const campeonatoRoutes = [
  {path: '', component: TimeFormComponent},
  {path: ':id/cadastro', component: TimeFormComponent, canActivate: [AuthGuard]},
  {path: ':id/detalhes', component: TimeDetalhesComponent, canActivate: [AuthGuard]},
  {path: ':id/editar/:timeCapitao', component: TimeFormComponent, canActivate: [AuthGuard]},
  {path: ':nick/listaTimes', component: TimeComponent,  resolve: { time : TimeResolver},canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(campeonatoRoutes)],
  exports: [RouterModule]
})

export class TimeRoutingModule { }
