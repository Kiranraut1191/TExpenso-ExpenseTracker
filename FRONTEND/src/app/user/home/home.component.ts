import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { SidebarComponent } from '../../home/sidebar/sidebar.component';
import { NavbarComponent } from '../../navbar/navbar.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterOutlet, RouterLink, SidebarComponent, NavbarComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'] // ✅ Fixed from styleUrl to styleUrls
})
export class HomeComponent {
  
}
