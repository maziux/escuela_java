import { Component, OnInit } from '@angular/core';
import { UserRestService } from '../user-rest.service';
import { MessagesService } from '../messages.service'

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  constructor(private messageSrv: MessagesService) { }

  ngOnInit() {
  }

}
