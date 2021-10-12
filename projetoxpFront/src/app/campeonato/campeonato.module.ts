import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CampeonatoRoutingModule } from './campeonato-routing.module';
import { CampeonatoComponent } from './campeonato.component';
import { CampeonatoResolver } from './guards/campeonato.resolver';
import { CampeonatoService } from './service/campeonato.service';
import { CampeonatoFormComponent } from './campeonato-form/campeonato-form.component';
import { CampeonatoFormResolver } from './guards/campeonatoForm.resolver';
import { CampeonatoFormService } from './service/campeonato-form.service';
import { CampeonatoDetalhesComponent } from './campeonato-detalhes/campeonato-detalhes.component';
import { CampeonatoDetalhesResolver } from './guards/campeonato-detalhes.resolver';
import { UploadFileService } from 'src/app/campeonato/service/upload-file.service';
import { MatSidenavModule} from '@angular/material/sidenav';
import { MatTableModule} from '@angular/material/table';
import { MatTabsModule} from '@angular/material/tabs';
import { SharedModule } from './../shared/shared.module';


@NgModule({
  declarations: [
    CampeonatoComponent,
    CampeonatoFormComponent,
    CampeonatoDetalhesComponent,
  ],
  imports: [
    CommonModule,
    CampeonatoRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
    MatTableModule,
    MatSidenavModule,
    MatTabsModule,
  ],
  providers: [
    CampeonatoService,
    CampeonatoFormService,
    UploadFileService,
    CampeonatoResolver,
    CampeonatoFormResolver,
    CampeonatoDetalhesResolver,
  ]
})
export class CampeonatoModule { }
