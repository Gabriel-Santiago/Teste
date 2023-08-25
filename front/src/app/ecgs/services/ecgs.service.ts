import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ecg } from '../model/ecg';

@Injectable({
  providedIn: 'root'
})
export class EcgsService {

  private readonly API = 'http://localhost:8080/pacientes';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Ecg[]>(this.API);
  }
}
