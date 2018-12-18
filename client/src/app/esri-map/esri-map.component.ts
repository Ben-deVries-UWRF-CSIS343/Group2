import { Component, OnInit, ViewChild, ElementRef, Input, Output, EventEmitter } from '@angular/core';
import { loadModules } from 'esri-loader';
import esri = __esri;

@Component({
  selector: 'app-esri-map',
  templateUrl: './esri-map.component.html',
  styleUrls: ['./esri-map.component.css']
})

export class EsriMapComponent implements OnInit {

  // Private vars with default values
  private _zoom = 15;
  private _center = [-92.6213, 44.8523]; // River Falls
  private _basemap = 'streets-navigation-vector'; // streets
  map: esri.Map;
  mapView: esri.MapView;
  routeTask: any;

  @Output() mapLoaded = new EventEmitter<esri.MapView>();

  // this is needed to be able to create the MapView at the DOM element in this component
  @ViewChild('mapViewNode') private mapViewEl: ElementRef;

  constructor() { }

  async initializeMap() {
    try {
      const [EsriMap, EsriMapView, SimpleMarkerSymbol] = await loadModules([
        'esri/Map',
        'esri/views/MapView',
        'esri/symbols/SimpleMarkerSymbol'
      ]);

      // Set type of map
      const mapProperties: esri.MapProperties = {
        basemap: this._basemap
      };

      this.map = new EsriMap(mapProperties);

      // Set type of map view
      const mapViewProperties: esri.MapViewProperties = {
        container: this.mapViewEl.nativeElement,
        center: this._center,
        zoom: this._zoom,
        map: this.map
      };

      this.mapView = new EsriMapView(mapViewProperties);

      // All resources in the MapView and the map have loaded.
      // Now execute additional processes
      this.mapView.when(() => {
        this.mapLoaded.emit(this.mapView);
        console.log('map: ' , this.map);
        console.log('mapView: ', this.mapView);
        // this.mapView.toMap();
      });
    } catch (error) {
      alert('We have an error: ' + error);
    }
  }

  ngOnInit() {
    this.initializeMap();
  }
}
