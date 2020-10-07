import { Component, OnInit } from '@angular/core';
import { CatalogueService } from '../catalogue.service';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products: any;
  constructor(private catalogueService: CatalogueService,private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit(): void {

    this.router.events.subscribe(val=>{
      if(val instanceof NavigationEnd){
        let url = val.url;
        console.log("url " + url)
        let p1 = this.route.snapshot.params.p1;
        console.log("snapshot: " , this.route.snapshot.params.p1);
        if(p1 == 1){
          this.getProducts("/products/search/selectedProducts");
        }else if(p1 == 2){
          let idcat = this.route.snapshot.params.p2
          this.getProducts("/categories/"+idcat+"/products");
        }
      }
    })


  }

  getProducts(url){
    this.catalogueService.getResource(url)
    .subscribe(
      (data) => {
        this.products=data;
      }
    )
  }
}
