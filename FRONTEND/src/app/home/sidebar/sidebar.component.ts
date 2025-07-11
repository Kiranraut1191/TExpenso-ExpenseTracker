import { Component } from '@angular/core';
import { RouterModule, Router } from '@angular/router';
import { CommonModule } from '@angular/common'; // ✅ Fixes CommonModule error
import { UserdetailsComponent } from '../../userdetails/userdetails.component'; // ✅ Adjust path if needed

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule, RouterModule, UserdetailsComponent], // ✅ Add RouterModule if using routerLink
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  constructor(private router: Router) {}

  redirectToSend() {
    this.router.navigate(['send']);
  }

  redirectToRecive() {
    this.router.navigate(['recive']);
  }

  redirectToAllTranc() {
    this.router.navigate(['alltranc']);
  }

  redirectToBalance() {
    this.router.navigate(['balance']);
  }

  redirectToAllUsers() {
    this.router.navigate(['allusers']);
  }
}
