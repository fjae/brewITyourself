import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestConsumerService {

  endpoint: String = 'http://localhost:8080/com.dotzet.rest.jersey.crud.suppliers/api/suppliers';
  httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};
  getSupplier(vat): Observable<any> {
    return this.http.get(this.endpoint + '/read/' + vat);
  }
  constructor(private http: HttpClient) { }
}
