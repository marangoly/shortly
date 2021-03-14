import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  constructor(private http: HttpClient) { }

  shortenUrl(longUrl: string) {
    return this.http.post<any>('http://localhost:9001/api/urls', { longUrl: longUrl });
  }
}