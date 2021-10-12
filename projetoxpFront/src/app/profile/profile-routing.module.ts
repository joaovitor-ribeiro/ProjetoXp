import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatchResolver } from './guards/match.resolver';
import { ProfileResolver } from './guards/profile.resolver';
import { MatchComponent } from './match/match.component';
import { ProfileComponent } from './profile.component';

const profileRoutes = [
  {path: '' , component: ProfileComponent},
  {path: ':name', component: ProfileComponent},
  {path: ':name/match/:match', component: MatchComponent, resolve: { match: MatchResolver }}
];

@NgModule({
  imports: [RouterModule.forChild(profileRoutes)],
  exports: [RouterModule]
})

export class ProfileRoutingModule { }
