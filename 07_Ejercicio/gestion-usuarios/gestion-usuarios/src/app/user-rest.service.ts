import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './model/user';

@Injectable({
  providedIn: 'root'
})
export class UserRestService {


  urlApiRest = 'http://localhost:8084/CRUD_Vista_JSTL/api/users';
  httpOptions = {
    headers: new HttpHeaders({"Content-Type": "application/json"})
  }
  constructor(private httpCli: HttpClient) { }

  addUser(newUser: User): Observable<User> {    
    return this.httpCli.post<User>(this.urlApiRest,newUser,this.httpOptions);
  }

  getUsers(): Observable<User[]>{
    
    let observResp: Observable<User[]>;
    observResp = this.httpCli.get<User[]>(this.urlApiRest);
    // Aqui no definimos las callback, mejor que las defina
    // donde se necesian, Devolvemos el observable para que 
    // se pueda gestionar desde fuera del servicio.
    return observResp;
  }
}
