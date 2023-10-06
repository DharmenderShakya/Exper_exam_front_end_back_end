import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit{
  loginData = {
    userName: '',
    password: ''
  };


  snack: any;
  constructor(private router: Router,private loginService:LoginService) { }

ngOnInit(): void {
  
}

  getUser() {
    this.loginService.getCurrentUser().subscribe((data:any)=>{

    })
  }
  formSubmit() {
    console.log("this my name" + this.loginData.userName);
    if (this.loginData.userName.trim() == '' ||
      this.loginData.userName == null) {
      this.snack.open('Username is required !! ', '', {
        duration: 3000,
      });
      return;
    }

    if (this.loginData.password.trim() == '' ||
      this.loginData.password == null) {
      this.snack.open('Password is required !! ', '', {
        duration: 3000,
      });
      return;
    }
    

    this.loginService.generateToken(this.loginData).subscribe((data:any) => {
     
      this.loginService.loginUser(data.token);
      // this.loginService.getToken();
      // console.log(this.loginService.getToken());
      this.loginService.getCurrentUser().subscribe((user: any) => {
        this.loginService.setUser(user);
        console.log(user);
        //redirect ...ADMIN: admin-dashboard
        //redirect ...NORMAL:normal-dashboard
        if (this.loginService.getUserRole() == 'ADMIN') {
          //admin dashboard
          // window.location.href = '/admin';
          this.router.navigate(['/admin']);
          this.loginService.loginStatusSubject.next(true);
        } else if (this.loginService.getUserRole() == 'NORMAL') {
          //normal user dashbaord
          // window.location.href = '/user-dashboard';
          this.router.navigate(['/user']);
          this.loginService.loginStatusSubject.next(true);
        } else {
          this.loginService.logOut();
        }
      });
    }, (error) => {
      console.log('Error !');
      console.log(error);
      this.snack.open('Invalid Details !! Try again', '', {
        duration: 3000,
      });
    }
    );
  }
}
