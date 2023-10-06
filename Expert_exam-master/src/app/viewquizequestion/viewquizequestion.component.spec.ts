import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewquizequestionComponent } from './viewquizequestion.component';

describe('ViewquizequestionComponent', () => {
  let component: ViewquizequestionComponent;
  let fixture: ComponentFixture<ViewquizequestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewquizequestionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewquizequestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
