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
  age: string;

  constructor(private userSrv: UserRestService) { }

  
  send() {
    alert
  }

  ngOnInit() {
    this.newUser = new User();
  }



}
