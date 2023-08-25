import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcgsComponent } from './ecgs.component';

describe('EcgsComponent', () => {
  let component: EcgsComponent;
  let fixture: ComponentFixture<EcgsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EcgsComponent]
    });
    fixture = TestBed.createComponent(EcgsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
