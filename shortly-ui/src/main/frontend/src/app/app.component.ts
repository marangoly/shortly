import { Component } from '@angular/core';
import { AppService } from './app.service';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {

  constructor(public appService: AppService, private formBuilder: FormBuilder){}

  title = 'shortly';
  value = '';
  shortenedUrl = '';

  shortenUrl() {
    this.appService.shortenUrl(this.value).subscribe(
      (data) => {
        this.shortenedUrl = data.shortCode;
      }
    )
  }

}
