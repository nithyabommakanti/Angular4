import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private http : HttpClient) { }
data
  ngOnInit() {
  }
onClick(){
  this.http.get("test/rest/myresource/getdetails").subscribe(res => this.data = res);
  console.log(this.data);
}
  }