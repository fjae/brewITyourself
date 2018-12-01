import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';
import { ApplicationHeaderComponent } from './application-header/application-header.component';
import { CompanyNameComponent } from './application-header/company-name/company-name.component';
import { CompanyLogoComponent } from './application-header/company-logo/company-logo.component';
import { AppBodyComponent } from './app-body/app-body.component';
import { MainDashboardComponent } from './app-body/main-dashboard/main-dashboard.component';
import { SuppliersButtonComponent } from './app-body/main-dashboard/suppliers-button/suppliers-button.component';
import { SuppliersDashboardComponent } from './app-body/suppliers-dashboard/suppliers-dashboard.component';
import { MainDashboardCrumbComponent } from './app-body/main-dashboard/main-dashboard-crumb/main-dashboard-crumb.component';
import { SupplierCreateComponent } from './app-body/suppliers-dashboard/supplier-create/supplier-create.component';
import { SupplierUpdateComponent } from './app-body/suppliers-dashboard/supplier-update/supplier-update.component';
import { SupplierDeleteComponent } from './app-body/suppliers-dashboard/supplier-delete/supplier-delete.component';
import { SupplierReadComponent } from './app-body/suppliers-dashboard/supplier-read/supplier-read.component';
// tslint:disable-next-line:max-line-length
import { SuppliersDashboardHeaderComponent } from './app-body/suppliers-dashboard/suppliers-dashboard-header/suppliers-dashboard-header.component';
import { SupplierCreateFormComponent } from './app-body/suppliers-dashboard/supplier-create-form/supplier-create-form.component';
import { SupplierDeleteFormComponent } from './app-body/suppliers-dashboard/supplier-delete-form/supplier-delete-form.component';
import { SupplierReadFormComponent } from './app-body/suppliers-dashboard/supplier-read-form/supplier-read-form.component';
import { SupplierUpdateFormComponent } from './app-body/suppliers-dashboard/supplier-update-form/supplier-update-form.component';
import { SuppliersTableComponent } from './app-body/suppliers-dashboard/suppliers-table/suppliers-table.component';


@NgModule({
  declarations: [
    AppComponent,
    ApplicationHeaderComponent,
    CompanyNameComponent,
    CompanyLogoComponent,
    AppBodyComponent,
    MainDashboardComponent,
    SuppliersButtonComponent,
    SuppliersDashboardComponent,
    MainDashboardCrumbComponent,
    SupplierCreateComponent,
    SupplierUpdateComponent,
    SupplierDeleteComponent,
    SupplierReadComponent,
    SuppliersDashboardHeaderComponent,
    SupplierCreateFormComponent,
    SupplierDeleteFormComponent,
    SupplierReadFormComponent,
    SupplierUpdateFormComponent,
    SuppliersTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FlexLayoutModule,
    MatCardModule,
    RouterModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
