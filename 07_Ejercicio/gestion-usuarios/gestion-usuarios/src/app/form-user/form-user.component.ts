import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-form-user',
  templateUrl: './form-user.component.html',
  styleUrls: ['./form-user.component.css']
})
export class FormUserComponent implements OnInit {

  @Input()
  user: User;
  constructor() { }

  ngOnInit() {
  }

}
