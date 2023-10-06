import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatequizzeComponent } from './updatequizze.component';

describe('UpdatequizzeComponent', () => {
  let component: UpdatequizzeComponent;
  let fixture: ComponentFixture<UpdatequizzeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatequizzeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatequizzeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
