import { EcgsService } from './../services/ecgs.service';
import { Component, OnInit } from '@angular/core';
import { Ecg } from '../model/ecg';
import { Observable } from 'rxjs/internal/Observable';


@Component({
  selector: 'app-ecgs',
  templateUrl: './ecgs.component.html',
  styleUrls: ['./ecgs.component.scss']
})
export class EcgsComponent implements OnInit {

  ecgs$: Observable<Ecg[]>;
  displayedColumns = ['nome', 'cidade', 'estado', 'frequenciaCardiaca'];

  // ecgsService: EcgsService;

  constructor(private ecgsService: EcgsService){
    // this.ecgs = [];
    // this.ecgsService = new EcgsService();
    this.ecgs$ = this.ecgsService.list();
  }

  ngOnInit(): void{
  }

}
