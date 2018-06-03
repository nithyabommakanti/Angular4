
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private http:HttpClient) { }
  
    onClick(data){
      alert(data.user_name);
    
    this.http.post("test/rest/myresource/login1",{
      user_name : data.user_name,
      password : data.password,
      }
    ).subscribe(
    (res: any)=>{
      console.log(res);
       if(res == "yes")
      
      alert("Hi! :)");
    else
      alert("Cannot login!!");
    },
      err=>{
        console.log(err);
        alert("Bye :(");
      }
      );
     }

  ngOnInit() {
  }
}