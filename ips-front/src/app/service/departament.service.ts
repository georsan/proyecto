import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { Departament } from '../interfaces/departament';

@Injectable({
  providedIn: 'root'
})
export class DepartamentService {
    private readonly url=environment.API;
  
    constructor(private readonly http:HttpClient) { }


    getAllDepartament():Observable<Departament[]>{
      return this.http.get<Departament[]>(`${this.url}department`)
    }

}

