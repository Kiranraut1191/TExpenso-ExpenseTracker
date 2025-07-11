import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AlltrancComponent } from './alltranc.component';

describe('AlltrancComponent', () => {
  let component: AlltrancComponent;
  let fixture: ComponentFixture<AlltrancComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlltrancComponent] // ✅ for standalone component
    }).compileComponents();

    fixture = TestBed.createComponent(AlltrancComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
