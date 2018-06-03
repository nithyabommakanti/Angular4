import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private http:HttpClient) { }
  
    onClick(data){
      alert(data.user_name);
    
    this.http.post("test/rest/myresource/register1",{
      user_name : data.user_name,
      password : data.password,
	  email: data.email,
      }
    ).subscribe(
    (res: any)=>{
      console.log(res);
	  if(res == "yes")
      
      alert("Hi! :)");
	  else
		  alert("Bye :(");
    },
      err=>{
        console.log(err);
      }
      );
     }

  ngOnInit() {
  }
}