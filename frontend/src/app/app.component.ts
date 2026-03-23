import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TrackingService } from './services/tracking.service';
import { Click } from './models/click.model';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  clicks: Click[] = [];
  loading = true;

  constructor(private trackingService: TrackingService) {}

  ngOnInit(): void {
    this.loadClicks();
  }

  loadClicks(): void {
    this.loading = true;
    this.trackingService.getClicks().subscribe({
      next: (data) => {
        this.clicks = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching clicks', err);
        this.loading = false;
      }
    });
  }

  getClickCount(): number {
    return this.clicks.length;
  }
}
