import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CampeonatoDetalhesComponent } from './campeonato-detalhes.component';

describe('CampeonatoDetalhesComponent', () => {
  let component: CampeonatoDetalhesComponent;
  let fixture: ComponentFixture<CampeonatoDetalhesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CampeonatoDetalhesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CampeonatoDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
