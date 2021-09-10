import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { CampeonatoFormComponent } from "./campeonato/campeonato-form/campeonato-form.component";
import { CampeonatoComponent } from "./campeonato/campeonato.component";
import { CampeonatoResolver } from "./campeonato/guards/campeonato.resolver";
import { CampeonatoFormResolver } from "./campeonato/guards/campeonatoForm.resolver";
import { UsuarioFormComponent } from "./usuario/form/usuario-form.component";
import { UsuarioFormResolver } from "./usuario/guards/usuarioForm.resolver";
import { LoginComponent } from "./usuario/login/login/login.component";
import { LogoutComponent } from "./usuario/logout/logout/logout.component";


const routes: Routes = [
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
  // {
  //   path: 'usuario',
  //   loadChildren: () => import('./cadastro-usuario/usuario.module').then(m => m.UsuarioModule),
  // },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
