import { Injectable } from '@angular/core';
import { HEROES } from './model/array-heros';
import { Hero } from './model/hero';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HeroRestService {

  urlApiRest = 'http://localhost:8084/CRUD_Vista_JSTL/api/heroes';
  httpOptions = {
    headers: new HttpHeaders({"Content-Type": "application/json"})
  }

  constructor(private httpCli: HttpClient) {
   }

  getHeroes(): Observable<Hero[]> {
    /* 1º modo */
    // Devolvemos un observable que encapsula el array.
    // Inmediatamente emite el evento que ya tiene el
    // array.
    // return of(this.aHeroes);
    /* 2º modo */
    let observResp: Observable<Hero[]>;
    observResp = this.httpCli.get<Hero[]>(this.urlApiRest);
    // Aqui no definimos las callback, mejor que las defina
    // donde se necesian, Devolvemos el observable para que 
    // se pueda gestionar desde fuera del servicio.
    return observResp;
  }
  addHero(newId: number, newName: string, newFile: string): Observable<Hero>{
    let newHero: Hero = {
      id: newId,
      name: newName,
      file: 'test.png'
    };
    return this.httpCli.post<Hero>(this.urlApiRest,newHero,this.httpOptions);
  }
}
