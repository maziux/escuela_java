import { Injectable } from '@angular/core';
import { Hero } from './model/hero';
import { HEROES } from './model/array-heros';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  aHeroes: Hero [];

  constructor(private messageSrv: MessageService) {
    this.aHeroes = [];
    for (let i = 0; i < HEROES.length; i++)
      this.aHeroes.push(HEROES[i]);
   }

  getHeroes(): Hero[] {
    this.messageSrv.add("HeroService: capturando heroes");
    return this.aHeroes;
  }
  addHero(newId: number, newName: string, newFile: string){
    let newHero: Hero = {
      id: newId,
      name: newName,
      file: 'test.png'
    };
    this.aHeroes.push(newHero);
    this.messageSrv.add("Añadido: " + newName + " con ID: " + newId);
  }
  getHero(id: number): Hero {
    let hero = this.aHeroes.find( (hero) => { return hero.id === id});
    return hero;
  }
}
