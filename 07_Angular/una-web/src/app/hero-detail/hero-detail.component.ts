import { Component, OnInit, Input } from '@angular/core';
import { Hero } from '../model/hero';

import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { HeroService } from '../hero.service';


@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {
  
  // Esta propiedad viene de algún componente externo
  @Input() hero: Hero;

  constructor(private route: ActivatedRoute,
              private heroSrv: HeroService,
              private location: Location) { }

  ngOnInit() {
    this.getHero();
  }

  getHero(): void {
    // Cogemos el id del parámetro de la ruta /detail/:id
    const id = this.route.snapshot.paramMap.get('id');
    // id -> string => +id -> transform string number to number
    this.hero = this.heroSrv.getHero(+id);
  }

}
