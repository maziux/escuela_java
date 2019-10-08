import { Component, OnInit } from '@angular/core';
import { HeroRestService } from '../hero-rest.service';
import { Hero } from '../model/hero';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-hero-rest',
  template: `
    <h2>Listado Heroes REST</h2>
    <ul>
      <li *ngFor = "let hero of heroesRecibidos">
          {{ hero.id }} - {{ hero.name }}
      </li>
    </ul>
    <div>
      <!-- input id -->
      <label for="id">ID: </label>
      <input [(ngModel)]="id" type="number" id="id" placeholder="Id" />
      <!-- input name -->
      <label for="name">NAME: </label>
      <input [(ngModel)]="name" type="string" id="name" placeholder="Nombre" />
      <!-- button to submit -->
      <input type="button" (click)="enviar()" value="ENVIAR"/>
    </div>`,
  styleUrls: ['./hero-rest.component.css']
})
export class HeroRestComponent implements OnInit {
  heroesRecibidos: Hero[];
  id: string;
  name: string;
  
  constructor(private heroRestSrv: HeroRestService) { }
  
  enviar() {
    let nuevoHeroe = new Hero();
    nuevoHeroe.id = parseInt(this.id);
    nuevoHeroe.name = this.name;
    this.heroRestSrv.addHero(nuevoHeroe.id,nuevoHeroe.name,'test.png')
      .subscribe( (obj) => this.ngOnInit() );
  }
  ngOnInit() {
    let observableArrayHeroes: Observable<Hero[]>;
    observableArrayHeroes = this.heroRestSrv.getHeroes();
    // La ejecución continúa hasta que el array es recibido.
    // Para recibirlo asincronamente nos suscribimos al Observable
    observableArrayHeroes.subscribe( heroesRec => this.heroesRecibidos = heroesRec );
  }
}
