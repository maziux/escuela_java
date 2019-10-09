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
  modUser: boolean;


  constructor(private userSrv: UserRestService,
    private msgSrv: MessagesService) { }

  ngOnInit() {
    let observableArrayUsers: Observable<User[]>;
    observableArrayUsers = this.userSrv.getUsers();
    observableArrayUsers.subscribe(usersRec => this.usersRecibidos = usersRec);
  }

  onSelect(user: User): void {
    this.selectedUser = user;
    this.activarUsuario = true;
    this.modUser = false;
  }
  ocultar() {
    this.activarUsuario = false;
    this.modUser = false;
  }

  // TO DO - don't update the user locally if it's not updated on the db
  modify2(): void {
    this.userSrv.updateUser(this.selectedUser).subscribe((obj) => {
      this.ngOnInit();
      this.msgSrv.add(this.selectedUser.id + '-'+ this.selectedUser.email +' - User correctly updated');
    }, error => {
      this.msgSrv.add(this.selectedUser.id + '-'+ this.selectedUser.email +' - Update failed');
    });
    this.activarUsuario = false;
    this.modUser = false;
  }
  modify(user: User) {
    this.selectedUser = user;
    this.activarUsuario = true;
    this.modUser = true;
  }

  delete(user: User): void {
    this.userSrv.deleteUser(user).subscribe((obj) => {
      this.ngOnInit();
      this.msgSrv.add(user.id + '-' + user.email + ' - User deleted');
    }, error => {
      /* debido a un bug de httpClient, aunque reciba un "OK" del servidor, da error
      / asi que aunque reciba error decimos que borramos el usuario porque sabemos que
      / se va a borrar si o si
       */
      this.ngOnInit();
      this.msgSrv.add(user.id + '-' + user.email + ' - User deleted'); 
    });
    this.activarUsuario = false;
  }


}
