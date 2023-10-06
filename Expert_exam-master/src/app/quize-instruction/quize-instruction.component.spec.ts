import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizeInstructionComponent } from './quize-instruction.component';

describe('QuizeInstructionComponent', () => {
  let component: QuizeInstructionComponent;
  let fixture: ComponentFixture<QuizeInstructionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuizeInstructionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuizeInstructionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
