import { Component, AfterViewInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SuppliersDaoService } from '../../../suppliers-dao.service';
import { MatTableDataSource } from '@angular/material';




@Component({
  selector: 'app-suppliers-table',
  templateUrl: './suppliers-table.component.html',
  styleUrls: ['./suppliers-table.component.css']
})
export class SuppliersTableComponent implements AfterViewInit {
  displayedColumns: string[] = ['vat', 'companyName', 'address', 'city', 'region', 'postalCode', 'country', 'phone', 'fax', 'homePage'];

  suppliersDao: SuppliersDaoService | null;
  suppliersJSONstring: string;
  suppliersJSON: JSON[];
  datasource: MatTableDataSource<JSON> = new MatTableDataSource(this.suppliersJSON);

  constructor(private http: HttpClient) { }

  ngAfterViewInit() {
    this.suppliersDao = new SuppliersDaoService(this.http);
    this.suppliersDao.getSuppliers().subscribe((data) => {
      console.log(data);
      this.suppliersJSONstring = JSON.stringify(data);
      this.suppliersJSON = JSON.parse(this.suppliersJSONstring);
      this.datasource = new MatTableDataSource(this.suppliersJSON);
      console.log('suppliers JSON string not iterative: ' + this.suppliersJSONstring);
      console.log('suppliers JSON same as any: ' + this.suppliersJSON);
    });
  }
}

