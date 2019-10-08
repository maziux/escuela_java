import { Component, OnInit } from '@angular/core';
import { Hero } from '../model/hero';
// import { HEROES } from '../model/array-heros';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-heros-list',
  templateUrl: './heros-list.component.html',
  styleUrls: ['./heros-list.component.css']
})
export class HerosListComponent implements OnInit {

  heroes: Hero[];
  selectedHero: Hero;

  constructor(private heroSrv: HeroService) { }

  ngOnInit() {
    // this.heroes = HEROES;
    this.getHeroesFromService();
  }
  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }
  getHeroesFromService(): void {
    this.heroes = this.heroSrv.getHeroes();
  }

}
