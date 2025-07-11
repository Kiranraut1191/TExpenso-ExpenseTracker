import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DeleteUserComponent } from './delete-user.component';
import { UserserviceService } from '../../userservice.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

describe('DeleteUserComponent', () => {
  let component: DeleteUserComponent;
  let fixture: ComponentFixture<DeleteUserComponent>;
  let userService: UserserviceService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DeleteUserComponent],
      imports: [HttpClientTestingModule, RouterTestingModule],
      providers: [UserserviceService]
    }).compileComponents();

    fixture = TestBed.createComponent(DeleteUserComponent);
    component = fixture.componentInstance;
    userService = TestBed.inject(UserserviceService);
    fixture.detectChanges();
  });

  it('should create DeleteUserComponent', () => {
    expect(component).toBeTruthy();
  });

  it('should call deleteUser API when deleteUser is invoked', () => {
    component.userId = 1;

    // Mock deleteUser API call
    spyOn(userService, 'deleteUser').and.returnValue(of({ message: 'User deleted' }));

    component.deleteUser();

    expect(userService.deleteUser).toHaveBeenCalledWith(1);
  });
});
