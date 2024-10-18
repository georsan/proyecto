import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ilogin } from '../interfaces/ilogin';
import { map, tap } from 'rxjs';
import { environment } from '../../environments/environment';
import { UserRegister } from '../interfaces/user-register';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly url=environment.API;

  constructor(private readonly http:HttpClient) { }

  login(auth:Ilogin){
    return this.http.post(`${this.url}auth/login`,auth);
  }

  register(data:UserRegister){

    return this.http.post<{token:string}>(`${this.url}auth/register`,data).pipe(map(token=>token.token),);
  }

}
