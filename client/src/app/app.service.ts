import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class AppService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };
  constructor(private http: HttpClient) { }

  getAddress() {
    return this.http.get('http://localhost:8080/address');
  }

  addAddress() {
    const obs = this.http.post<Map<String, String>>('http://localhost:8080/address', {
      id: '101010',
      name: 'Peter-POST',
      addressLine1: 'addressLine1-POST',
      addressLine2: 'addressLine2-POST',
      zipcode: 54022,
      state: 'state-POST',
      city: 'city-POST'
    }, this.httpOptions);
    obs.subscribe((response) => console.log(response));
  }

  addTudeAddress(start: boolean, end: boolean, lat: number, long: number) {
    const obs = this.http.post<Map<String, String>>('http://localhost:8080/tudeAddress', {
      isStartingPoint: start,
      isEndingPoint: end,
      lat: lat,
      long: long,
    }, this.httpOptions);
    obs.subscribe((response) => console.log(response));
  }
}
