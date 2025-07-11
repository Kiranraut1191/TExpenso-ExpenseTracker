import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-userdetails',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {
addUser(_t5: NgForm) {
this.router.navigate(['home']);
}
  selectedUser: any;

  constructor(
    private service: UserserviceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const nav = this.router.getCurrentNavigation();
    const user = nav?.extras?.state?.['userdetails'];
    const stored = sessionStorage.getItem('userData');

    if (stored) {
      const parsed = JSON.parse(stored)?.reponse;
      console.log('User retrieved from sessionStorage:', parsed);
      this.fetchUserDetails(parsed?.uid || parsed?.userId);
      this.selectedUser = parsed;
      sessionStorage.setItem('userUID', String(parsed?.uid || parsed?.userId));
      const userUID = Number(sessionStorage.getItem('userUID'));
      console.log(userUID); // Now it's an integer
    }  else {
      console.warn('No user found in navigation state or sessionStorage.');
      alert('Please log in first.');
      this.router.navigate(['/login']);
    }
  }
  
  fetchUserDetails(userId:any): void {
    this.service.viewUser(userId).subscribe();
  }
}