import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserserviceService } from '../userservice.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-allusers',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './allusers.component.html',
  styleUrls: ['./allusers.component.css']
})
export class AllusersComponent implements OnInit {
  users: any[] = [];

  constructor(private userService: UserserviceService) {}

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers(): void {
    this.userService.getUsers().subscribe(
      (data: any[]) => {
        this.users = data.map(user => ({
          uid: user.uid,
          u_name: user.u_name,
          email: user.email,
          mob_no: user.mob_no
        }));
      },
      error => {
        console.error('Error fetching users:', error);
      }
    );
  }

  deleteUser(id: number): void {
    if (confirm('Are you sure you want to delete this user?')) {
      this.userService.deleteUser(id).subscribe(
        () => {
          alert('User deleted successfully!');
          this.getAllUsers(); // Refresh the list
        },
        error => {
          console.error('Error deleting user:', error);
          alert('Failed to delete user.');
        }
      );
    }
  }
}
