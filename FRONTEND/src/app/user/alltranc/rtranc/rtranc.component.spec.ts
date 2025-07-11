import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RtrancComponent } from './rtranc.component';

describe('RtrancComponent', () => {
  let component: RtrancComponent;
  let fixture: ComponentFixture<RtrancComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RtrancComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RtrancComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
