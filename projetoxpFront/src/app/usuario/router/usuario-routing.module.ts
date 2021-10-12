import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { UsuarioFormComponent } from "../form/usuario-form.component";
import { UsuarioFormResolver } from "../guards/usuarioForm.resolver";

const usuarioRoutes = [
  {path: '', component: UsuarioFormComponent},
  {path: 'cadastro', component: UsuarioFormComponent},
  {path: 'editar/:nick', component: UsuarioFormComponent, resolve: { form: UsuarioFormResolver }}
];

@NgModule({
  imports: [RouterModule.forChild(usuarioRoutes)],
  exports: [RouterModule]
})

export class UsuarioRoutingModule { }
