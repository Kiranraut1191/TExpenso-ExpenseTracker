import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { UserserviceService } from '../../userservice.service';

@Component({
  selector: 'app-send',
  standalone: true,
  imports: [RouterModule, FormsModule],
  templateUrl: './send.component.html',
  styleUrls: ['./send.component.css']  // ✅ Fixed spelling from "styleUrl"
})
export class SendComponent {
  constructor(private service: UserserviceService, private router: Router) {}

  // ✅ Optional: method to redirect manually
  redirectToAllTranc() {
    this.router.navigate(['trancaction']);
  }

  // ✅ Used by form submit handler
  submitSend(sendForm: NgForm) {
    this.sendPenny(sendForm);
  }

  // ✅ Handles actual service call
  sendPenny(sendmoneydata: NgForm) {
    if (sendmoneydata && sendmoneydata.value) {
      const request = this.service.sendPenny(sendmoneydata.value);

      if (request) {
        request.subscribe(
          (resp: any) => {
            console.log('Transaction sent successfully:', resp);
            alert('Transaction sent successfully!');
            this.router.navigate(['/trancaction']);
          },
          (error: any) => {
            console.error('Error sending transaction:', error);
            this.router.navigate(['/trancaction']);
          }
        );
      } else {
        console.error('sendPenny returned undefined. Probably missing userId.');
        alert('User ID not found. Please log in again.');
      }
    } else {
      console.error('sendmoneydata or its value is undefined');
      alert('Invalid data provided.');
    }
  }
}
