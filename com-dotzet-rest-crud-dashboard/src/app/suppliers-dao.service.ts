import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


Injectable({
  providedIn: 'root'
});
/*export interface Suppliers {
  items: Supplier[];
  items_count: number;
}
export interface Supplier {
  vat: string;
  companyName: string;
  address: string;
  city: string;
  region: string;
  postalCode: string;
  country: string;
  phone: string;
  fax: string;
  homePage: string;
}
*/
export class Supplier {
  private vat: string;
  private companyName: string;
  private address: string;
  private city: string;
  private region: string;
  private postalCode: string;
  private country: string;
  private phone: string;
  private fax: string;
  private homePage: string;
  public getVat(): string{
    return this.vat;
  }
  public setVat(vat: string): void {
    this.vat = vat;
  }
  public getCompanyName(): string {
    return this.companyName;
  }
  public setCompanyName(companyName: string): void {
    this.companyName = companyName;
  }
  public getAddress(): string {
  return this.address;
  }
  public setAddress(address: string): void {
    this.address = address;
  }
  public getCity(): string {
    return this.city;
  }
  public setCity(city: string): void {
    this.city = city;
  }
  public getRegion(): string {
    return this.region;
  }
  public setRegion(region: string): void {
    this.region = region;
  }
  public getCountry(): string {
    return this.country;
  }
  public setCountry(country: string): void {
    this.country = country;
  }
  public getPhone(): string {
    return this.phone;
  }
  public setPhone(phone: string): void {
    this.phone = phone;
  }
  public getFax(): string {
    return this.fax;
  }
  public setFax(fax: string): void {
    this.fax = fax;
  }
  public getHomePage(): string {
    return this.homePage;
  }
  public setHomePage(homePage: string): void {
    this.homePage = homePage;
  }
  constructor({vat, companyName, address, city, region, postalCode, country, phone, fax, homePage}) {
    this.vat = vat;
    this.companyName = companyName;
    this.address = address;
    this.city = city;
    this.region = region;
    this.postalCode = postalCode;
    this.country = country;
    this.phone = phone;
    this.fax = fax;
    this.homePage = homePage;
  }
}

export class Suppliers {
  items: Supplier[];
  items_count: number;
  constructor() {
    this.items = [];
    this.items_count = 0;
  }
}

export class SuppliersDaoService {
  private endPointProxy: string = '/my-proxy';
  private endPointService: string = '/com.dotzet.rest.jersey.crud.suppliers/api/suppliers';
  private  URLRequestBase: string = this.endPointProxy + this.endPointService;
  // private httpOptions: any = {
    //  headers: new HttpHeaders({'Content-Type': 'application/json'})
 // };
  constructor(private http: HttpClient) { }

  private extractData(res: Response) {
    const body = res;
    return body || { };
  }
  getSuppliers (): Observable<Suppliers> {
    const endPointMethod: string = '/list';
    return this.http.get<Suppliers>(this.URLRequestBase + endPointMethod);
  }

  getSupplier(vat: string): Observable<any> {
    const endPointMethod: string = '/read';
    return this.http.get(this.URLRequestBase + endPointMethod + '/' + vat).pipe(map(this.extractData));
  }
}








