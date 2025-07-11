import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../../userservice.service';

@Component({
  selector: 'app-balance',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent implements OnInit {
  Users: string = '';
  amount: number = 0;

  constructor(private service: UserserviceService) {}

  ngOnInit(): void {
    const userId = sessionStorage.getItem('userId');
    console.log('Balance - userId:', userId);

    this.service.getNetBalanceId().subscribe(
      data => {
        console.log('Balance received:', data);
        this.amount = data;
        this.Users = this.amount < 0 ? `-- ${-this.amount}` : `++ ${this.amount}`;
      },
      error => {
        console.error('Error fetching balance:', error);
      }
    );
  }
}
