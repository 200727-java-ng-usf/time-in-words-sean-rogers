import { Component, OnInit } from '@angular/core';
import { TimeDTO } from '../models/timeDTO';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  events;

  inputHour: number;
  inputMinute: number;

  constructor(private userService: UserService) {



  }

  ngOnInit(): void {

  }

  getAllEvents() {
    
    this.userService.getAllEvents().subscribe(
      resp => {
        this.events = resp.body;
        console.log(this.events);
      },
      err => {
        console.log('status: ' + err.status);
        console.log(err.error.error);
        console.log('message: ' + err.error.message);
      }
    )
    
  }

  addEvent() {

    console.log("in UserComponent.addEvent()")

    const timeDTO = new TimeDTO();

    timeDTO.hours = this.inputHour;
    timeDTO.minutes = this.inputMinute;

    this.userService.addEvent(timeDTO).subscribe(
      resp => {
        console.log("event added successfully");
      },
      err => {
        console.log('status: ' + err.status);
        console.log(err.error.error);
        console.log('message: ' + err.error.message);
      }
    )
  }

  logButtonFunction() {
    console.log(this.inputHour);
    console.log(this.inputMinute);
  }

}
