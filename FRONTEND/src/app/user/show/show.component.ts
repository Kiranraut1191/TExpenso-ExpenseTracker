import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-show',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css'] // ✅ Fixed from styleUrl to styleUrls
})
export class ShowComponent {
  expenses: any;
}
