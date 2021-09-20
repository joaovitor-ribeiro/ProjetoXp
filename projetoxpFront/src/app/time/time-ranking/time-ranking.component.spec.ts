import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeRankingComponent } from './time-ranking.component';

describe('TimeRankingComponent', () => {
  let component: TimeRankingComponent;
  let fixture: ComponentFixture<TimeRankingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimeRankingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TimeRankingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
