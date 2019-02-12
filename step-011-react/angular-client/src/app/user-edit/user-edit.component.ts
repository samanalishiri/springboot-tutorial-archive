import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {


  user = {};

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getUser(this.route.snapshot.params['id']);
  }

  getUser(id) {
    this.http.get('http://localhost:8080/user/read/' + id).subscribe(data => this.user = data);
  }

  updateUser(id, data) {
    this.http.put('http://localhost:8080/user/update', this.user)
      .subscribe(res => this.router.navigate(['/user']), (err) => console.log(err));
  }

}
