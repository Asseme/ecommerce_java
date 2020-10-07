import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class CatalogueService {
  host = "http://localhost:8080"
  constructor(private http: HttpClient) {}

  getResource(url){
    return this.http.get(this.host+url);
  }
}
