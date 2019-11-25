import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Person } from "./person.model";
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ContactService {
  rootURL = "http://localhost:8080";

  constructor(private http: HttpClient) { }

 // Http Options
 httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }  

  getContacts() {
    return this.http.get<Person[]>('http://localhost:8080/api/');
  }

  getContact(id) {
    return this.http.get<Person>(this.rootURL + "/api/" + id);
  }

  addContact(contact: Person) {
    return this.http.post<Person>(this.rootURL + "/api/", contact);
  }

  editContact(id, contact: Person) {
    return this.http.put(this.rootURL + "/api/" + id, contact);
  }

  deleteContact(id) {
    return this.http.delete(this.rootURL + "/api/" + id);
  }
}
