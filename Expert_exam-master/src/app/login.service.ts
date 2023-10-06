import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Subject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject = new Subject<boolean>();


  private baseUrl='/auth';

  constructor(private httpClient: HttpClient) { }

  // Example of sending a request with the token in Angular's HttpClient
 
  getCurrentUser(){
    return this.httpClient.get(`${this.baseUrl}/current-user`);
  }
  
  public generateToken(loginData: any){
    return this.httpClient.post(`${this.baseUrl}/generate-token`,loginData);
  }
  public loginUser(token: any) {
    localStorage.setItem('token', token);
  }

  public isLoggedIn() {
    let tokenStorage = localStorage.getItem('token');
    if (tokenStorage == undefined || tokenStorage == '' || tokenStorage == null) {
      return false;
    } else {
      return true;
    }
  }

  public getToken() {
    return localStorage.getItem('token');
  }

  public setUser(user: any) {
    return localStorage.setItem('user', JSON.stringify(user));
  }
  public logOut() {
    localStorage.removeItem('token'); //remove the user from local storage to log out a user
    localStorage.removeItem('user');
    return true;
  }

  public getUser() {
    let userStorage = localStorage.getItem('user');
    if (userStorage != null) {
      return JSON.parse(userStorage);
    }
    else {
      this.logOut();
      return null;
    }
  }
  public getUserRole() {
    let role = this.getUser();
    return role.authorities[0].authority;
  }


}

