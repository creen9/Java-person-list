import { Component, OnInit } from '@angular/core';
import { ContactService } from '../person.service';
import { Person } from '../person.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {
  contacts: Person[];
  preparedId: number;

  constructor(private service: ContactService,
    private router: Router) { }

  ngOnInit() {
    this.service.getContacts().subscribe(data => this.contacts = data);
  }

  prepare(id) {
    this.preparedId = id;
  }

  delete(id) {
    this.service.deleteContact(id).subscribe(response => window.location.reload());
  }
}
