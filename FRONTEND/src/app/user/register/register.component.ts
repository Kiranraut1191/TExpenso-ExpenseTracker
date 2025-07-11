import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UserserviceService } from '../../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user: any = {
      u_name: '',
      password: '',
      email: '',
      mob_no: ''
  };

  constructor(private service: UserserviceService, private router: Router) {}

  registerUser(form: any) {
    if (form.valid) {
      this.service.registerUser(this.user).subscribe(
        (res: any) => {
          alert('User Registered Successfully!');
          this.router.navigate(['/login']);
        },
        (err: any) => {
          console.error('Registration error:', err);
          alert('Registration failed!');
        }
      );
    }
  }
}
