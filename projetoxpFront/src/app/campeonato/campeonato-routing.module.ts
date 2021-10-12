import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CampeonatoDetalhesComponent } from './campeonato-detalhes/campeonato-detalhes.component';
import { CampeonatoDetalhesResolver } from './guards/campeonato-detalhes.resolver';
import { CampeonatoFormComponent } from './campeonato-form/campeonato-form.component';
import { CampeonatoFormResolver } from './guards/campeonatoForm.resolver';
import { CampeonatoComponent } from './campeonato.component';
import { CampeonatoResolver } from './guards/campeonato.resolver';
import { AuthGuard } from '../usuario/guard/auth.guard';

const campeonatoRoutes: Routes = [
  {path: '', component: CampeonatoComponent, resolve: { campeonato : CampeonatoResolver }},
  {path: 'cadastro', component: CampeonatoFormComponent},
  {path: 'editar/:id', component: CampeonatoFormComponent,canActivate: [AuthGuard], resolve: { form: CampeonatoFormResolver }},
  {path: 'detalhes/:id', component: CampeonatoDetalhesComponent, resolve: { detalhes: CampeonatoDetalhesResolver }}
];

@NgModule({
  imports: [RouterModule.forChild(campeonatoRoutes)],
  exports: [RouterModule]
})
export class CampeonatoRoutingModule { }
