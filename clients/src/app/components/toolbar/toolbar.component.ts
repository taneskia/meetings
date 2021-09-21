import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styles: [`
      .example-spacer {
        flex: 1 1 auto;
      }
      mat-toolbar{
        margin: 2px;
      }
  `]
})
export class ToolbarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
