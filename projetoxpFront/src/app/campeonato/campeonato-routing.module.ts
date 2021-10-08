import { CampeonatoDetalhesComponent } from './campeonato-detalhes/campeonato-detalhes.component';
import { CampeonatoFormResolver } from './guards/campeonatoForm.resolver';
import { CampeonatoFormComponent } from './campeonato-form/campeonato-form.component';
import { CampeonatoComponent } from './campeonato.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CampeonatoResolver } from './guards/campeonato.resolver';
import { AuthGuard } from '../usuario/guard/auth.guard';

const campeonatoRoutes = [
  {path: '', component: CampeonatoComponent,
    resolve: { campeonato : CampeonatoResolver },
    children : [
      {path: 'campeonato/cadastro', component: CampeonatoFormComponent, canActivate: [AuthGuard]},
      {
        path: 'campeonato/editar/:id', component: CampeonatoFormComponent,
        canActivate: [AuthGuard],
        resolve: { form: CampeonatoFormResolver },
      },
      {
        path: 'campeonato/detalhes', component: CampeonatoDetalhesComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(campeonatoRoutes)],
  exports: [RouterModule]
})

export class CampeonatoRoutingModule { }
