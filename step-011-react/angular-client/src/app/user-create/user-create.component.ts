import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent implements OnInit {

  user = {};

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  saveUser() {
    this.http.post('http://localhost:8080/user/create', this.user)
      .subscribe(res => {
          this.router.navigate(['/user', res]);
        }, (err) => {
          console.log(err);
        }
      );
  }

}
