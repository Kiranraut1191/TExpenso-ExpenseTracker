import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserserviceService } from '../../userservice.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginData: { email?: string; password?: string } = {}; // ✅ Use type-safe object

  constructor(
    private service: UserserviceService,
    private router: Router
  ) {}

  public login(): void {
    console.log('Login data:', this.loginData);

    if (!this.loginData.email || !this.loginData.password) {
      alert('Please enter both email and password');
      return;
    }

    this.service.loginUser(this.loginData).subscribe(
      resp => {
        console.log('Login response:', resp);

        const user = resp?.reponse;
        const userId = user?.uid;

        if (!userId) {
          alert('Invalid login credentials');
          return;
        }

        sessionStorage.setItem('userId', userId);
        sessionStorage.setItem('userData', JSON.stringify(user));

        alert('User logged in successfully!');
        this.router.navigate(['/alltranc']);
      },
      err => {
        console.error('Login error:', err);
        alert('Login failed. Please try again.');
      }
    );
  }
}
