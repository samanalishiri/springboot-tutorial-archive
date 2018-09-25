import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {UserComponent} from './user/user.component';
import {UserShowComponent} from './user-show/user-show.component';
import {UserCreateComponent} from './user-create/user-create.component';
import {UserEditComponent} from './user-edit/user-edit.component';

import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';

const appRoutes: Routes = [
  {
    path: 'user',
    component: UserComponent,
    data: {title: 'User List'}
  },
  {
    path: 'user-show/:id',
    component: UserShowComponent,
    data: {title: 'Show User'}
  },
  {
    path: 'user-create',
    component: UserCreateComponent,
    data: {title: 'Create User'}
  },
  {
    path: 'user-edit/:id',
    component: UserEditComponent,
    data: {title: 'Edit User'}
  },
  {
    path: '',
    redirectTo: '/user',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    UserShowComponent,
    UserCreateComponent,
    UserEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
