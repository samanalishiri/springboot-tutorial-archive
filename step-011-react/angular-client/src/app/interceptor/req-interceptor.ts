import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Injectable()
export class RequestInterceptor implements HttpInterceptor {

  constructor(private router: Router) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let token = localStorage.getItem("navaco_token");

    if (token == null) {
      // this.router.navigate(['/zcore']);
    }

    console.log('Intercepted HTTP call', req);

    return next.handle(req);
  }
}
