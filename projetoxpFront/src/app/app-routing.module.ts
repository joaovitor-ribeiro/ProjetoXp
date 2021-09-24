import { AuthGuard } from './usuario/guard/auth.guard';
import { TimeRankingComponent } from './time/time-ranking/time-ranking.component';
import { TimeFormComponent } from './time/time-form/time-form.component';
import { CampeonatoFormComponent } from './campeonato/campeonato-form/campeonato-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CampeonatoFormResolver } from './campeonato/guards/campeonatoForm.resolver';
import { CampeonatoDetalhesComponent } from './campeonato/campeonato-detalhes/campeonato-detalhes.component';
import { CampeonatoDetalhesResolver } from './campeonato/guards/campeonato-detalhes.resolver';
import { CampeonatoComponent } from './campeonato/campeonato.component';
import { CampeonatoResolver } from './campeonato/guards/campeonato.resolver';
import { LoginComponent } from "./usuario/login/login/login.component";
import { LogoutComponent } from "./usuario/logout/logout/logout.component";
import { UsuarioFormComponent } from './usuario/form/usuario-form.component';
import { UsuarioFormResolver } from './usuario/guards/usuarioForm.resolver';

const routes: Routes = [
  { path: 'time/:id/cadastro', component: TimeFormComponent,canActivate: [AuthGuard] },
  { path: 'ranking/time', component: TimeRankingComponent },
  // {
  //   path: 'campeonato',
  //   loadChildren: () => import('./campeonato/campeonato.module').then(m => m.CampeonatoModule),
  // },
  {
    path: 'campeonato/editar/:id', component: CampeonatoFormComponent,
    resolve: { form: CampeonatoFormResolver },
    canActivate: [AuthGuard]
  },
  //{ path: '**', component: CampeonatoFormComponent },
  {
    path: 'usuario/cadastro', component: UsuarioFormComponent,
  },
  {
    path: 'usuario/editar/:id', component: UsuarioFormComponent,
    resolve: { form: UsuarioFormResolver },
    canActivate: [AuthGuard]
  },
  {
    path: 'campeonato/cadastro', component: CampeonatoFormComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'campeonato', component: CampeonatoComponent,
    resolve: { campeonato: CampeonatoResolver },
  },
  {
    path: 'campeonato/detalhes/:id', component: CampeonatoDetalhesComponent,
    resolve: { detalhes: CampeonatoDetalhesResolver },
  },
  //{ path: '**', component: CampeonatoFormComponent },
  // {
  //   path: 'usuario',
  //   loadChildren: () => import('./cadastro-usuario/usuario.module').then(m => m.UsuarioModule),
  // },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent,
    canActivate: [AuthGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
