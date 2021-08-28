import { CadastroCampeonatoComponent } from './cadastro-campeonato/cadastro-campeonato.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';

const routes: Routes = [
  { path: 'cadastro/usuario', component: CadastroUsuarioComponent},
  { path: 'cadastro/campeonato', component: CadastroCampeonatoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
