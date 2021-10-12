import { NgModule } from '@angular/core';
import { TimeRankingComponent } from './time/time-ranking/time-ranking.component';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from "./usuario/login/login/login.component";
import { LogoutComponent } from "./usuario/logout/logout/logout.component";

const routes: Routes = [
  {
    path: 'campeonato',
    loadChildren: () => import('./campeonato/campeonato.module').then(m => m.CampeonatoModule)
  },
  {
    path: 'usuario',
    loadChildren: () => import('./usuario/usuario.module').then(m => m.UsuarioModule)
  },
  {
    path: 'time',
    loadChildren: () => import('./time/time.module').then(m => m.TimeModule)
  },
  {
    path: 'profile',
    loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule)
  },
  { path: 'ranking/time', component: TimeRankingComponent},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
