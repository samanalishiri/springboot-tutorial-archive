import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {WebsocketListenerComponent} from './websocket-listener.component';

describe('WebsocketListenerComponent', () => {
  let component: WebsocketListenerComponent;
  let fixture: ComponentFixture<WebsocketListenerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [WebsocketListenerComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WebsocketListenerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
