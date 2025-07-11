import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { UserserviceService } from '../../../userservice.service';

@Component({
  selector: 'app-getdates',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './getdates.component.html',
  styleUrls: ['./getdates.component.css']
})
export class GetdatesComponent {
  startDate: string | undefined;
  endDate: string | undefined;

  constructor(private service: UserserviceService) {}

  recivePenny(recivemoneydata: NgForm): void {
    if (recivemoneydata.valid) {
      console.log('Start Date:', this.startDate);
      console.log('End Date:', this.endDate);

      // Convert to timestamps (Date objects)
      const startTimestamp = this.startDate ? new Date(this.startDate) : null;
      const endTimestamp = this.endDate ? new Date(this.endDate) : null;

      console.log('Start Timestamp:', startTimestamp);
      console.log('End Timestamp:', endTimestamp);

      if (startTimestamp && endTimestamp) {
        // Store timestamps as strings in session storage
        sessionStorage.setItem('StartDate', startTimestamp.toString());
        sessionStorage.setItem('EndDate', endTimestamp.toString());

        console.log('Stored StartDate:', sessionStorage.getItem('StartDate'));
        console.log('Stored EndDate:', sessionStorage.getItem('EndDate'));
      } else {
        console.error('Start date or end date is invalid!');
        return;
      }

      // Then make API call
      this.service.getExpenseByDate().subscribe(
        response => {
          console.log('Response from backend:', response);
        },
        error => {
          console.error('Error occurred while sending data:', error);
        }
      );
    } else {
      console.error('Form is invalid!');
    }
  }
}
