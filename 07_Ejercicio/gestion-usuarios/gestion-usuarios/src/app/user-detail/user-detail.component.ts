import { Component, OnInit, Input } from '@angular/core';
import { User } from '../model/user';
import { ActivatedRoute } from '@angular/router';
import { UserRestService } from '../user-rest.service';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  
  @Input() user: User;
  constructor(private route: ActivatedRoute,
              private userSrv: UserRestService,
              private location: Location) { }

  ngOnInit() {
    this.getUser();
  }

  getUser() {
    // Cogemos el id del parámetro de la ruta /detail/:id
    const id = this.route.snapshot.paramMap.get('id');
    // id -> string => +id -> transform string number to number
    this.user = this.userSrv.getUser(+id);

  }

}
