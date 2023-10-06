import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-sidebar',
  templateUrl: './admin-sidebar.component.html',
  styleUrls: ['./admin-sidebar.component.css']
})
export class AdminSidebarComponent {
  list=[
    {
      number:'1',
      name:'Home',
      icon:'fa-solid fa-house',
      link:'home' 
    },
    {
      number:'2',
      name:'Profile',
      icon:'fa-solid fa-user',
      link:'profil'
    },
    {
      number:'3',
      name:'Category',
      icon:'fa-solid fa-list-ul',
      link:'category'
    },
    {
      number:'4',
      name:'Add Category',
      icon:'fa-solid fa-circle-plus',
      link:'addCategory'
    },
    {
      number:'5',
      name:'Quizzes',
      icon:'fa-solid fa-circle-question',
      link:'quizze'
    },
    {
      number:'6',
      name:'Add Quize',
      icon:'fa fa-plus-square',
      link:'addquizze'
    },
    {
      number:'7',
      name:'Logout',
      icon:'fa-solid fa-arrow-right-from-bracket'
    }
  ]
  constructor(){}
  ngOnInit():void{}
}
