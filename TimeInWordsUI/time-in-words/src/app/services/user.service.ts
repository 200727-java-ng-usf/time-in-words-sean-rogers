import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { TimeDTO } from '../models/timeDTO';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {

  }

  getAllEvents() {
    return this.http.get(`http://localhost:5000/entities`, {responseType:'json', observe:'response'});
  }

  addEvent(timeDTO: TimeDTO) {
    console.log(timeDTO.minutes + " " + timeDTO.hours);
    return this.http.post(`http://localhost:5000/entities`, timeDTO, {responseType:'json', observe:'response'});
  }



}
