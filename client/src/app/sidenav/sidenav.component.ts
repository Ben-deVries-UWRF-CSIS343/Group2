import { AppService } from './../app.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})

export class SidenavComponent implements OnInit {

  title = 'Project Name';
  mapView: any;
  startLatitude = 0.0;
  startLongitude = 0.0;
  endLatitude = 0.0;
  endLongitude = 0.0;
  counter = 0;

  constructor(private appService: AppService) { }

  ngOnInit() {
  }

  onClick(event: any) {
    this.counter++;

    if (this.counter === 1) {
      this.addStartCoordinates(event.x, event.y);
    } else if (this.counter === 2) {
      this.addEndCoordinates(event.x, event.y);
    } else {
      this.counter = 0;
      this.removeMarkers();
    }
  }

  calculateRoute(startLat: number, startLong: number, endLat: number, endLong: number) {
    console.log('Calculating route ...');
    this.appService.addTudeAddress(true, false, startLat, startLong);
    this.appService.addTudeAddress(false, true, endLat, endLong);
  }

  addStartCoordinates(x: number, y: number) {
    // Converts x and y coordinates to latitude and longitude
    const obj = this.mapView.toMap(x, y);
    this.startLatitude = obj.latitude;
    this.startLongitude = obj.longitude;
  }

  addEndCoordinates(x: number, y: number) {
    // Converts x and y coordinates to latitude and longitude
    const obj = this.mapView.toMap(x, y);
    this.endLatitude = obj.latitude;
    this.endLongitude = obj.longitude;
  }

  removeMarkers() {
    console.log('Resetting coordinates ...');
    this.resetCoordinates();
  }

  resetCoordinates() {
    this.startLatitude = 0.0;
    this.startLongitude = 0.0;
    this.endLatitude = 0.0;
    this.endLongitude = 0.0;
  }

  // The MapView should be typed to the esri.MapView
  saveMapView(mapView: any) {
    this.mapView = mapView;
  }
}
