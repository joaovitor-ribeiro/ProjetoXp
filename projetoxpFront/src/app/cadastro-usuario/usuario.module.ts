import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { SharedModule } from "../shared/shared.module";
import { UsuarioFormResolver } from "./guards/usuarioForm.resolver";
import { UsuarioRoutingModule } from "./router/usuario-routing.module";
import { UsuarioFormService } from "./service/cadastro-usuario.service";
import { UsuarioFormComponent } from "./usuario-form.component";


@NgModule({
  declarations: [
    UsuarioFormComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    UsuarioRoutingModule,
  ],
  providers: [
    UsuarioFormService,
    UsuarioFormResolver,
  ]
})
export class UsuarioModule { }
