import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContactService } from '../person.service';
import { Person } from '../person.model';


@Component({
  selector: 'app-editcontact',
  templateUrl: './editcontact.component.html',
  styleUrls: ['./editcontact.component.css']
})
export class EditcontactComponent implements OnInit {
  contact: Person;
  id;
  error = "";

  constructor(private service: ContactService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get("id");

    this.service.getContact(this.id).subscribe(data => this.contact = data);
  }

  onSubmit() {
    this.service.editContact(this.id, this.contact).subscribe(
      (response) => { this.router.navigate(['/']); },
      error => this.error = "Error: Data is incorrect.");
  }

}
