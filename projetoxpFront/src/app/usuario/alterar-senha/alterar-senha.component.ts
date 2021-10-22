import { UsuarioFormService } from './../service/usuario.service';
import { senhaDTO } from './../model/senhaDTO.model';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BaseFormComponent } from 'src/app/shared/base-form/base-form.component';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthenticationService } from '../service/authentication.service';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

@Component({
  selector: 'app-alterar-senha',
  templateUrl: './alterar-senha.component.html',
  styleUrls: ['./alterar-senha.component.css']
})
export class AlterarSenhaComponent extends BaseFormComponent implements OnInit {

  senhaDTO: senhaDTO = new senhaDTO();
  inscricao!: Subscription;
  nick!: string | null;
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  constructor(
    private formBuilder: FormBuilder,
    private usuario: UsuarioFormService,
    private route: ActivatedRoute,
    private router: Router,
    public loginService: AuthenticationService,
    private snackBar: MatSnackBar,
  ) {
    super();
  }

  ngOnInit() {
    this.formulario = this.formBuilder.group({
      'senhaAntiga': [null, [Validators.required, Validators.minLength(6)]],
      'senhaNova': [null, [Validators.required, Validators.minLength(6)]],
      'senhaNovaRepetida': [null, [Validators.required, Validators.minLength(6)]],
    });
    this.nick = this.loginService.getSessionNick();
  }

  preenchendoSenhaDto(){
    this.senhaDTO.senhaAntiga  = this.formulario.get('senhaAntiga')?.value;
    this.senhaDTO.senhaNova  = this.formulario.get('senhaNova')?.value;
  }

  submit() {
    this.preenchendoSenhaDto();
    this.usuario.atualizarSenha(this.nick, this.senhaDTO).subscribe(
      result =>{
        if(result == 1){
          this.router.navigate(['campeonato']);
          this.openSnackBar('Senha atualizado com sucesso')
        }else if(result == 2){
          this.openSnackBar('Senha antiga está incorreta')
        }
      }
    );
  }

  openSnackBar(text: string) {
    this.snackBar.open(text, '', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: 1500,
    });
  }
}
