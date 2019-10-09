import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './model/user';

@Injectable({
  providedIn: 'root'
})
export class UserRestService {

  arrayUsers: User[]; 
  urlApiRest = 'http://localhost:8084/CRUD_Vista_JSTL/api/users';
  httpOptions = {
    headers: new HttpHeaders({ "Content-Type": "application/json" })
  }
  constructor(private httpCli: HttpClient,
              private userSrv: UserRestService) {
   }

  addUser(newUser: User): Observable<User> {
    return this.httpCli.post<User>(this.urlApiRest, newUser, this.httpOptions);
  }

  updateUser(newUser: User): Observable<User> {
    return this.httpCli.put<User>(this.urlApiRest, newUser, this.httpOptions);
  }

  deleteUser(newUser: User): Observable<User> {{
    const id = newUser.id;
    const url = `${this.urlApiRest}/${id}`;
  
    return this.httpCli.delete<User>(url, this.httpOptions);
    
  }
    return this.httpCli.delete<User>(this.urlApiRest, this.httpOptions);
  }
  getUsers(): Observable<User[]> {
   let observResp: Observable<User[]>;
    observResp = this.httpCli.get<User[]>(this.urlApiRest);
    // Aqui no definimos las callback, mejor que las defina
    // donde se necesian, Devolvemos el observable para que 
    // se pueda gestionar desde fuera del servicio.
    return observResp;
  }
  getUser(id: number): User {
    let observableArrayUsers: Observable<User[]>;
    observableArrayUsers = this.userSrv.getUsers();
    // La ejecución continúa hasta que el array es recibido.
    // Para recibirlo asincronamente nos suscribimos al Observable
    observableArrayUsers.subscribe( usersRec => this.arrayUsers = usersRec );
    let hero = this.arrayUsers.find( (user) => { return +user.id === id});
    return hero;
  }
}
