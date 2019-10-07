import { Component, OnInit } from '@angular/core';
import { Hero } from '../model/hero';

@Component({
  selector: 'app-mi-control',
  templateUrl: './mi-control.component.html',
  styleUrls: ['./mi-control.component.css']
})
export class MiControlComponent implements OnInit {

  static contIds: number = 0;
  propiedadHola = 'Vamos a comer ya!';
  hero: Hero = {
    id: 1,
    name: 'Iron Man',
    file: 'Iron-Man.jpg',
  };

  constructor() {
    MiControlComponent.contIds++;
    this.hero.id = MiControlComponent.contIds;
  }

  ngOnInit() {
  }

}
