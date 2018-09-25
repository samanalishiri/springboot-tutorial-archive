import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-user-show',
  templateUrl: './user-show.component.html',
  styleUrls: ['./user-show.component.css']
})
export class UserShowComponent implements OnInit {

  user = {};

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit() {
    this.getUser(this.route.snapshot.params['id']);
  }

  deleteUser(id) {
    this.http.delete('http://localhost:8080/user/delete/' + id)
      .subscribe(res => {
          this.router.navigate(['/user']);
        }, (err) => {
          console.log(err);
        }
      );
  }

  getUser(id) {
    this.http.get('http://localhost:8080/user/read/' + id).subscribe(data => {
      this.user = data;
    });
  }

}
