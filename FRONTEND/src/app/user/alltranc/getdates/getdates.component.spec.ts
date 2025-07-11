import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetdatesComponent } from './getdates.component';

describe('GetdatesComponent', () => {
  let component: GetdatesComponent;
  let fixture: ComponentFixture<GetdatesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetdatesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetdatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
