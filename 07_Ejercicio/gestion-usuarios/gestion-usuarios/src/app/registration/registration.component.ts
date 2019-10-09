import { Component, OnInit } from '@angular/core';
import { UserRestService } from '../user-rest.service';
import { User } from '../model/user';
import { MessagesService } from '../messages.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  newUser: User;

  constructor(private userSrv: UserRestService,
              private msgSrv: MessagesService) { }

  send() {
    this.userSrv.addUser(this.newUser)
      .subscribe( (obj) => {
          this.msgSrv.add('Registration success');
          this.ngOnInit();
         },
         (error) =>  this.msgSrv.add('Registration failed'));
  }

  ngOnInit() {
    this.newUser = new User();
  }
}
