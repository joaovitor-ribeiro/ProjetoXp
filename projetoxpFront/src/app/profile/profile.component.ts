import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription, Observable, of } from 'rxjs';
import { SummonerDto } from './guards/summoner/summonerDto.model';
import { ProfileService } from './profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  logo : string = '../../logo.png';
  name : string = '';
  level !: number;
  nick !: string;
  profile !: string;
  lupaIcon: string = 'https://icones.pro/wp-content/uploads/2021/06/icone-loupe-bleu.png'
  summonerDto$ !: Observable<SummonerDto[]>;
  inscricao!: Subscription;
  displayedColumns: string[] = ['champion', 'kda', 'cs', 'gameDuration', 'gameMode', 'lupa'];
  semParemtro = false;
  nickNaoEcontrado = false;
  isLoading = true;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private profileService: ProfileService
  ) { }

  ngOnInit(){
    this.isLoading = true;
    this.semParemtro = false;
    this.nickNaoEcontrado = false;
    this.inscricao = this.route.params.subscribe( params => {
      if(params['name']){
        this.profileService.getSummoner(params['name']).subscribe(result =>{
          console.log(result);
          if(result){
            this.summonerDto$ = of(result);
            this.carregaDados(result);
          }else{
            this.nickNaoEcontrado = true;
            this.isLoading = false;
          }
        })
      }else{
        this.semParemtro = true;
        this.nickNaoEcontrado = false;
        this.isLoading = false;
      }
    });
  }

  ngOnDestroy(){
    this.inscricao.unsubscribe();
  }

  search( name: string) {
    this.router.navigate([ '/profile' , name.toLowerCase().replace(" ","")]);
    this.isLoading = true;
  }

  carregaDados(info: any){
    try {
      this.name = info[0].name.toLowerCase().replace(" ","");
      this.nick = info[0].name;
      this.level = info[0].level;
      this.profile = info[0].profile;
    } catch (error) {
      this.name = '';
    }
    this.isLoading = false;
  }

  venceu(win: any){
    if(win){
      return "Vitória";
    }
    return "Derrota";
  }

}
