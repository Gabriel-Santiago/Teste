import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EcgsComponent } from './ecgs/ecgs.component';

const routes: Routes = [
  { path: '', component: EcgsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EcgsRoutingModule { }
