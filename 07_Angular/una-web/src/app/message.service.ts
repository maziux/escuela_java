import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  messages: string[] = []; // new Array()

  // constructor() { } NO lo necesitamos para este ejemplo

  add(message: string): void {
    this.messages.push(message);
  }
  clear(): void {
    this.messages = [];
  }
}
