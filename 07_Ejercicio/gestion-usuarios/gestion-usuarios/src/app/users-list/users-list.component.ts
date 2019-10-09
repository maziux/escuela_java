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
  activarUsuario: boolean = false;
  modUser: boolean = false;


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
    this.activarUsuario = true;
  }
  ocultar() {
    this.activarUsuario = false;
    this.modUser = false;
  }

  modify2(): void {    
    this.userSrv.updateUser(this.selectedUser).subscribe(
      (obj) => {
        this.msgSrv.add("CORRECT on UPDATE");
        this.ngOnInit();
       },
       (error) => this.msgSrv.add("ERROR on UPDATE") );
    
    this.activarUsuario = false;
  }
  modify(): void {
    this.modUser = !this.modUser;
  }
  delete(): void { 
    this.userSrv.deleteUser(this.selectedUser)
      .subscribe(
        (obj) => this.ngOnInit(),
        (error) => this.msgSrv.add("ERROR on DELETE"));
    this.activarUsuario = false;

  }


}
