import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../../userservice.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-delete-user',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css']
})
export class DeleteUserComponent implements OnInit {
  userId: number = 0;

  constructor(
    private userService: UserserviceService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  deleteUser(): void {
    if (this.userId > 0) {
      this.userService.deleteUser(this.userId).subscribe(
        response => {
          alert('User deleted successfully!');
          this.router.navigate(['/home']);
        },
        error => {
          console.error('Delete failed:', error);
          alert('Delete failed. Try again.');
        }
      );
    } else {
      alert('Enter a valid User ID.');
    }
  }
}
