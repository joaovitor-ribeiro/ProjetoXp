import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfileRoutingModule } from './profile-routing.module';
import { ProfileService } from './profile.service';
import { SummonerService } from './guards/summoner/summoner.service';
import { MatchService } from './guards/match/match.service';
import { ProfileResolver } from './guards/profile.resolver';
import { MatchResolver } from './guards/match.resolver';
import { ProfileComponent } from './profile.component';
import { MatchComponent } from './match/match.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTableModule } from '@angular/material/table';

@NgModule({
  declarations: [
    ProfileComponent,
    MatchComponent,
  ],
  imports: [
    CommonModule,
    ProfileRoutingModule,
    MatSidenavModule,
    MatTableModule,
  ],
  providers: [
    SummonerService,
    MatchService,
    ProfileResolver,
    MatchResolver,
    ProfileService
  ],
})
export class ProfileModule { }
