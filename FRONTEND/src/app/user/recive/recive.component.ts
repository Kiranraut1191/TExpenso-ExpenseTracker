import { Component } from '@angular/core';
import { NavbarComponent } from '../../navbar/navbar.component';
import { SidebarComponent } from '../../home/sidebar/sidebar.component';
import { Router, RouterModule } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { UserserviceService } from '../../userservice.service';

@Component({
  selector: 'app-recive',
  standalone: true,
  imports: [NavbarComponent, SidebarComponent, RouterModule, FormsModule],
  templateUrl: './recive.component.html',
  styleUrls: ['./recive.component.css']
})
export class ReciveComponent {
  constructor(
    private service: UserserviceService,
    private router: Router
  ) {}

  recivePenny(recivemoneydata: NgForm): void {
    if (recivemoneydata?.value) {
      const request = this.service.recivePenny(recivemoneydata.value);

      if (request) {
        request.subscribe(
          (resp: any) => {
            console.log('User added successfully:', resp);
            alert('User added successfully!');
            this.router.navigate(['trancaction']);
          },
          (error: any) => {
            console.error('Error adding user:', error);
            alert('Error while adding user.');
            this.router.navigate(['trancaction']);
          }
        );
      } else {
        console.error('recivePenny returned undefined. Probably missing userId.');
        alert('User ID not found. Please log in again.');
      }
    } else {
      console.error('recivemoneydata or its value is undefined');
      alert('Invalid data provided.');
    }
  }
}
