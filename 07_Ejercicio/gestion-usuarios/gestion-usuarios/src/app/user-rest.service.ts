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
}
