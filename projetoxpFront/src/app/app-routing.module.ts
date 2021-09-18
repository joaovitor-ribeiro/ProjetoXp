import { TimeFormComponent } from './time/time-form/time-form.component';
import { CampeonatoFormComponent } from './campeonato/campeonato-form/campeonato-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CampeonatoFormResolver } from './campeonato/guards/campeonatoForm.resolver';
import { CampeonatoDetalhesComponent } from './campeonato/campeonato-detalhes/campeonato-detalhes.component';
import { CampeonatoDetalhesResolver } from './campeonato/guards/campeonato-detalhes.resolver';
import { UsuarioFormComponent } from './cadastro-usuario/usuario-form.component';
import { CampeonatoComponent } from './campeonato/campeonato.component';
import { CampeonatoResolver } from './campeonato/guards/campeonato.resolver';
import { UsuarioFormResolver } from './cadastro-usuario/guards/usuarioForm.resolver';

const routes: Routes = [
  { path: 'cadastro/usuario', component: CadastroUsuarioComponent },
  { path: 'cadastro/time', component: TimeFormComponent },
  // {
  //   path: 'campeonato',
  //   loadChildren: () => import('./campeonato/campeonato.module').then(m => m.CampeonatoModule),
  // },
  {
    path: 'campeonato/editar/:id', component: CampeonatoFormComponent,
    resolve: { form: CampeonatoFormResolver },
  },
  //{ path: '**', component: CampeonatoFormComponent },
  {
    path: 'usuario/cadastro', component: UsuarioFormComponent,
  },
  {
    path: 'usuario/editar/:id', component: UsuarioFormComponent,
    resolve: { form: UsuarioFormResolver },
  },
  {
    path: 'campeonato/cadastro', component: CampeonatoFormComponent,
  },
  {
    path: 'campeonato', component: CampeonatoComponent,
    resolve: { campeonato: CampeonatoResolver },
  },
  {
    path: 'campeonato/detalhes/:id', component: CampeonatoDetalhesComponent,
    resolve: { detalhes: CampeonatoDetalhesResolver },
  },
  { path: '**', component: CampeonatoFormComponent }
  // {
  //   path: 'usuario',
  //   loadChildren: () => import('./cadastro-usuario/usuario.module').then(m => m.UsuarioModule),
  // },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
