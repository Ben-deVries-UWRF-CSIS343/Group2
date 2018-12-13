import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private http: HttpClient) { }

  ngOnInit() {

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };

    const obs1 = this.http.get('http://localhost:8080/address');
    obs1.subscribe((response) => console.log(response));


    const obs2 = this.http.post<Map<String, String>>('http://localhost:8080/address', {
      id: '101010',
      name: 'Peter-POST',
      addressLine1: 'addressLine1-POST',
      addressLine2: 'addressLine2-POST',
      zipcode: 'zipcode-POST',
      state: 'state-POST',
      city: 'city-POST'
    }, httpOptions);
    obs2.subscribe((response) => console.log(response));
  }
}
