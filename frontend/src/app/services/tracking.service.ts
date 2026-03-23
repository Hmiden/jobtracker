import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Click } from '../models/click.model';

@Injectable({
  providedIn: 'root'
})
export class TrackingService {
  private apiUrl = 'http://localhost:8080/clicks';

  constructor(private http: HttpClient) { }

  getClicks(): Observable<Click[]> {
    return this.http.get<Click[]>(this.apiUrl);
  }
}
