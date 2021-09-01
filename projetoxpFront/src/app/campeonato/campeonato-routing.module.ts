import { CampeonatoFormResolver } from './guards/campeonatoForm.resolver';
import { CampeonatoFormComponent } from './campeonato-form/campeonato-form.component';
import { CampeonatoComponent } from './campeonato.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CampeonatoResolver } from './guards/campeonato.resolver';

const campeonatoRoutes = [
  {path: '', component: CampeonatoComponent,
    children : [
      {path: 'campeonato/cadastro', component: CampeonatoFormComponent},
      {
        path: 'campeonato/editar/:id', component: CampeonatoFormComponent,
        resolve: { form: CampeonatoFormResolver },
      },
    ],
    resolve: { campeonato : CampeonatoResolver },
  },
];

@NgModule({
  imports: [RouterModule.forChild(campeonatoRoutes)],
  exports: [RouterModule]
})

export class CampeonatoRoutingModule { }
