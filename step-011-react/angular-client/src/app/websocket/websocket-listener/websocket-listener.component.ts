import {Component, OnInit} from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-websocket-listener',
  templateUrl: './websocket-listener.component.html',
  styleUrls: ['./websocket-listener.component.css']
})
export class WebsocketListenerComponent implements OnInit {
  private stompClient;

  constructor() {
    this.initializeWebSocketConnection();
  }

  ngOnInit(): void {
  }

  initializeWebSocketConnection() {
    let ws = new SockJS('http://localhost:8080/greetingsEndPoint');
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function (frame) {
      that.stompClient.subscribe("/topic/greetings", (message) => {
        if (message.body) {
          console.log(message.body);
        }
      });
    });
  }

  sendMessage(message) {
    this.stompClient.send("/app/hello", {}, message);
  }
}
