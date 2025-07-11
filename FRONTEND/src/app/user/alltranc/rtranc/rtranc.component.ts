import { Component, OnInit } from '@angular/core';
import { BalanceComponent } from '../../balance/balance.component';
import { UserserviceService } from '../../../userservice.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-rtranc',
  standalone: true,
  imports: [BalanceComponent, CommonModule],
  templateUrl: './rtranc.component.html',
  styleUrls: ['./rtranc.component.css'] // ✅ Fixed from styleUrl to styleUrls
})
export class RtrancComponent implements OnInit {
  Users: any;

  constructor(private service: UserserviceService, private router: Router) {}

  ngOnInit(): void {
    this.service.getAllExpenseById().subscribe(
      data => {
        this.Users = data;
        console.log(data);
      },
      error => {
        console.error('Error fetching expenses:', error);
      }
    );
  }
}
