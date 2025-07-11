import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    const user = sessionStorage.getItem('userData');
    if (user) {
      return true; // ✅ Logged in
    }

    alert('Please log in first.');
    this.router.navigate(['/login']);
    return false;
  }
}
