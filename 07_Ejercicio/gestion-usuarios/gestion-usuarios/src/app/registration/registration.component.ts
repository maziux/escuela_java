import { Component, OnInit } from '@angular/core';
import { UserRestService } from '../user-rest.service';
import { User } from '../model/user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  newUser: User;


  constructor(private userSrv: UserRestService) { }

  send() {
    alert(this.newUser.name);
  }

  ngOnInit() {
    this.newUser = new User();
  }



}
