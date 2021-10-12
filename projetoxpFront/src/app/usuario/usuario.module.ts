import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { SharedModule } from "../shared/shared.module";
import { UsuarioFormComponent } from "./form/usuario-form.component";
import { UsuarioFormResolver } from "./guards/usuarioForm.resolver";
import { LoginComponent } from "./login/login/login.component";
import { LogoutComponent } from "./logout/logout/logout.component";
import { UsuarioRoutingModule } from "./router/usuario-routing.module";
import { AuthenticationService } from "./service/authentication.service";
import { UsuarioFormService } from "./service/usuario.service";

@NgModule({
  declarations: [
    UsuarioFormComponent,
    LoginComponent,
    LogoutComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
    UsuarioRoutingModule,
  ],
  providers: [
    UsuarioFormService,
    AuthenticationService,
    UsuarioFormResolver,
  ]
})
export class UsuarioModule { }
