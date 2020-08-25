import { Component, OnInit } from '@angular/core';

import { CatalogueService } from '../app/catalogue.service'
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  categories:any;
  constructor(private catService: CatalogueService){}

  ngOnInit(): void {
    this.getCategories();
  }
  getCategories() {
     this.catService.getResource("/categories")
     .subscribe(
       (data) => {
         this.categories = data
       },(error)=>{
        console.log(error)
       }
     )
  }

}
