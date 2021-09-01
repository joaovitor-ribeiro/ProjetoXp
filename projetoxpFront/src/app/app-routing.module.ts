import { CampeonatoFormComponent } from './campeonato/campeonato-form/campeonato-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';
import { CampeonatoFormResolver } from './campeonato/guards/campeonatoForm.resolver';

const routes: Routes = [
  { path: 'cadastro/usuario', component: CadastroUsuarioComponent },
  {
    path: 'campeonato',
    loadChildren: () => import('./campeonato/campeonato.module').then(m => m.CampeonatoModule),
  },
  {
    path: 'campeonato/editar/:id', component: CampeonatoFormComponent,
    resolve: { form: CampeonatoFormResolver },
  },
  { path: '**', component: CampeonatoFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
