import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadQuizzeComponent } from './load-quizze.component';

describe('LoadQuizzeComponent', () => {
  let component: LoadQuizzeComponent;
  let fixture: ComponentFixture<LoadQuizzeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoadQuizzeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoadQuizzeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
