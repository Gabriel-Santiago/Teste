import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EcgsRoutingModule } from './ecgs-routing.module';
import { EcgsComponent } from './ecgs/ecgs.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';


@NgModule({
  declarations: [
    EcgsComponent
  ],
  imports: [
    CommonModule,
    EcgsRoutingModule,
    AppMaterialModule
  ]
})
export class EcgsModule { }
