import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserRestService } from '../user-rest.service';
import { Observable } from 'rxjs';
import { MessagesService } from '../messages.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  usersRecibidos: User[];
  selectedUser: User;
  // test boolean
  activarModificar: boolean = false;


  constructor(private userSrv: UserRestService,
              private msgSrv: MessagesService) { }

  ngOnInit() {
    let observableArrayUsers: Observable<User[]>;
    observableArrayUsers = this.userSrv.getUsers();
    // La ejecución continúa hasta que el array es recibido.
    // Para recibirlo asincronamente nos suscribimos al Observable
    observableArrayUsers.subscribe( usersRec => this.usersRecibidos = usersRec );
  }
  
  onSelect(user: User): void {
    this.selectedUser = user;
    this.activarModificar = true;
  }
  ocultar() {
    this.activarModificar = false;
  }
  modify(): void {    
    this.userSrv.updateUser(this.selectedUser).subscribe( (obj) => this.ngOnInit() );
    this.msgSrv.add("User correctly UPDATE");
    this.activarModificar = false;
  }
  delete(): void { 
    this.userSrv.deleteUser(this.selectedUser).subscribe( (obj) => this.ngOnInit() );
    this.msgSrv.add("User correctly DELETE");
    this.activarModificar = false;

  }


}
