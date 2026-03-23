import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Click } from '../models/click.model';

@Injectable({
  providedIn: 'root'
})
export class TrackingService {
  private apiUrl = 'https://jobtracker-1-9wc7.onrender.com/clicks';

  constructor(private http: HttpClient) { }

  getClicks(): Observable<Click[]> {
    return this.http.get<Click[]>(this.apiUrl);
  }
}
