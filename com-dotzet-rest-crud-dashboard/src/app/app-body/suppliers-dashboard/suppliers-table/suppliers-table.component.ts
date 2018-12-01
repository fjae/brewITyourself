import { Component, OnInit } from '@angular/core';
import { RestConsumerService } from '../../../rest-consumer.service';

@Component({
  selector: 'app-suppliers-table',
  templateUrl: './suppliers-table.component.html',
  styleUrls: ['./suppliers-table.component.css']
})
export class SuppliersTableComponent implements OnInit {

  suppliers: any = [];
  constructor(public rest: RestConsumerService) { }

  ngOnInit() {
    this.getSupplier();
  }

  getSupplier() {
    this.suppliers = [];
    this.suppliers = this.rest.getSupplier('B85740397');
    console.log('here ' + this.suppliers);
  }
}

