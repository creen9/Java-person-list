import { Component, OnInit } from '@angular/core';
import { Person } from '../person.model';
import { ContactService } from '../person.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addcontact',
  templateUrl: './addcontact.component.html',
  styleUrls: ['./addcontact.component.css']
})
export class AddcontactComponent implements OnInit {

  model: Person;
  error = "";

  constructor(private service: ContactService,
  private router: Router) { }

  ngOnInit() {
    this.model = new Person();
  }

  onSubmit() {
    this.service.addContact(this.model).subscribe(
      (response) => { this.router.navigate(['/']); },
    error => this.error = "Error: Data is incorrect.");
  }

}
