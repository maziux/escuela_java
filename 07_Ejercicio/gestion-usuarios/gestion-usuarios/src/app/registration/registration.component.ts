import { Component, OnInit } from '@angular/core';
import { UserRestService } from '../user-rest.service';
import { User } from '../model/user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  id: string;
  email: string;
  password: string;
  name: string;
  age: string

  constructor(private userSrv: UserRestService) { }

  
  enviar() {
    let nuevoUser = new User();
    nuevoUser.id = '';//this.id;
    nuevoUser.email = this.email;
    nuevoUser.password = this.password;
    nuevoUser.name = this.name;
    nuevoUser.age = this.age;
    this.userSrv.addUser(nuevoUser).subscribe( (obj) => this.ngOnInit() );
  }

  ngOnInit() {
  }



}
