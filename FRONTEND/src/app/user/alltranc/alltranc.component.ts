import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from '../../navbar/navbar.component';
import { SidebarComponent } from '../../home/sidebar/sidebar.component';
import { Router, RouterModule } from '@angular/router';
import { UserserviceService } from '../../userservice.service';
import { CommonModule } from '@angular/common';
import { BalanceComponent } from '../balance/balance.component';

@Component({
  selector: 'app-alltranc',
  standalone: true,
  imports: [
    NavbarComponent,
    SidebarComponent,
    RouterModule,
    CommonModule,
    BalanceComponent
  ],
  templateUrl: './alltranc.component.html',
  styleUrls: ['./alltranc.component.css'] // ✅ Fixed typo from styleUrl to styleUrls
})
export class AlltrancComponent implements OnInit {
  Users: any;

  constructor(
    private service: UserserviceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const userId = sessionStorage.getItem('userId');
    console.log('Transactions - userId:', userId);

    this.service.getAllExpenseById().subscribe(
      data => {
        console.log('Transactions received:', data);
        this.Users = data;
      },
      err => {
        console.error('Error fetching transactions:', err);
      }
    );
  }

  redirectgetDates(): void {
    this.router.navigate(['getdates']);
  }

  recive(): void {
    // Placeholder for receive logic
  }

  send(): void {
    // Placeholder for send logic
  }
}
