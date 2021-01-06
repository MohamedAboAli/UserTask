import { Component, OnInit } from '@angular/core';
import { ApiService } from "src/app/api.service";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
    updateResult: any;
    updateUserLikesURL: string;
    loginUser: any;
    users=[];
    getAllUsersURL: string;

  constructor(private api:ApiService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

    getAllUsers(){
    this.getAllUsersURL="http://localhost:9090/user/getAllusers";
    this.api.getAPI(this.getAllUsersURL).subscribe((data) => {
    this.users=data;
    this.loginUser=this.users[0];
    for(let i=0;i<this.users.length;i++){
      for(let j=0;j<this.loginUser["myLikes"].length;j++){
       if(this.users[i].name == this.loginUser["myLikes"][j] ){
         this.users[i].isFavorite = true;
         break;
       }else{
          this.users[i].isFavorite =false;
       }
      }
    }
    })
  }

updateUserLikes(likedUserName){
  this.updateUserLikesURL="http://localhost:9090/user/updateUser/"+this.loginUser["id"]+"/"+likedUserName;
    this.api.putAPI(this.updateUserLikesURL).subscribe((data) => {
      this.updateResult=data;
       this.getAllUsers();
    })
}

}
