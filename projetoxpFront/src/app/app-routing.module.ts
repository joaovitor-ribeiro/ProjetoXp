import { TimeFormComponent } from './time/time-form/time-form.component';
import { CampeonatoFormComponent } from './campeonato/campeonato-form/campeonato-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';
import { CampeonatoFormResolver } from './campeonato/guards/campeonatoForm.resolver';
import { CampeonatoDetalhesComponent } from './campeonato/campeonato-detalhes/campeonato-detalhes.component';
import { CampeonatoDetalhesResolver } from './campeonato/guards/campeonato-detalhes.resolver';

const routes: Routes = [
  { path: 'cadastro/usuario', component: CadastroUsuarioComponent },
  { path: 'cadastro/time', component: TimeFormComponent },
  {
    path: 'campeonato',
    loadChildren: () => import('./campeonato/campeonato.module').then(m => m.CampeonatoModule),
  },
  {
    path: 'campeonato/editar/:id', component: CampeonatoFormComponent,
    resolve: { form: CampeonatoFormResolver },
  },
  {
    path: 'campeonato/detalhes/:id', component: CampeonatoDetalhesComponent,
    resolve: { detalhes: CampeonatoDetalhesResolver },
  },
  { path: '**', component: CampeonatoFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
