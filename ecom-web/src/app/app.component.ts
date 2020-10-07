import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { CatalogueService } from '../app/catalogue.service'
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  categories:any;
  currentCategorie;
  constructor(private catService: CatalogueService, private router: Router){}

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

  getProductByCat(c){
    this.currentCategorie = c;
    this.router.navigateByUrl("/products/2/"+c.id);
  }

}
