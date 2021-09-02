import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { UsuarioFormComponent } from "../usuario-form.component";
import { UsuarioFormResolver } from "../guards/usuarioForm.resolver";

const usuarioRoutes = [
    {path: '', component: UsuarioFormComponent,
      children : [
        {path: 'usuario/cadastro', component: UsuarioFormComponent},
        {
          path: 'usuario/editar/:id', component: UsuarioFormComponent,
          resolve: { form: UsuarioFormResolver },
        },
      ],
    },
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(usuarioRoutes)],
    exports: [RouterModule]
  })
  
  export class UsuarioRoutingModule { }
  