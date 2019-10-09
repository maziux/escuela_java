import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserRestService } from '../user-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  usersRecibidos: User[];
  selectedUser: User;
  constructor(private userSrv: UserRestService) { }

  ngOnInit() {
    let observableArrayUsers: Observable<User[]>;
    observableArrayUsers = this.userSrv.getUsers();
    // La ejecución continúa hasta que el array es recibido.
    // Para recibirlo asincronamente nos suscribimos al Observable
    observableArrayUsers.subscribe( usersRec => this.usersRecibidos = usersRec );
  }
  
  onSelect(user: User): void {
    this.selectedUser = user;
    alert(user.email);
  }

}
