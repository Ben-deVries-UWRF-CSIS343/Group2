import { AppService } from './app.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private appService: AppService) { }

  ngOnInit() {

    // // Example of RESTful GET
    // this.appService.getAddress().subscribe((response) => console.log(response));

    // // Example of RESTful POST
    // this.appService.addAddress();
  }
}
