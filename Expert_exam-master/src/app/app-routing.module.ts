import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/LoginComponent';
import { AdminDeshboardComponent } from './admin-deshboard/admin-deshboard.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { CategoriesComponent } from './categories/categories.component';
import { AddCategoriesComponent } from './add-categories/add-categories.component';
import { QuizzesComponent } from './quizzes/quizzes.component';
import { AddQuizesComponent } from './add-quizes/add-quizes.component';
import { UpdatequizzeComponent } from './updatequizze/updatequizze.component';
import { ViewquizequestionComponent } from './viewquizequestion/viewquizequestion.component';
import { UserDeshboardComponent } from './user-deshboard/user-deshboard.component';
import { LoadQuizzeComponent } from './load-quizze/load-quizze.component';
import { InstructionComponent } from './instruction/instruction.component';
import { StartComponent } from './start/start.component';
import { AuthGuard } from './user-guard.guard';
import { WelcomeComponent } from './welcome/welcome.component';
import { AdminAuth } from './admin-gaurd.guard';

const routes: Routes = [
  {path:'login',component:LoginComponent },
  // { path: '', redirectTo: '/login', pathMatch: 'full' },
  {
    path:'',component:LoginComponent,pathMatch:'full'
  },
  {
    path:'register',component:RegisterComponent,pathMatch:'full'
  },
  {
    path:'admin',component:AdminDeshboardComponent,canActivate:[AdminAuth],children:[
      {
        path:'home',component:HomeComponent
      },
      {
        path:'',component:HomeComponent,pathMatch:'full'
      },
      {
        path:'profil',component:ProfileComponent
      },
      {
        path:'category',component:CategoriesComponent
      },
      {
        path:'addCategory',component:AddCategoriesComponent
      },
      {
        path:'quizze',component:QuizzesComponent
      },
      {
        path:'addquizze',component:AddQuizesComponent
      },
      {
        path:'updatequizze',component:UpdatequizzeComponent
      },
      {
        path:'viewquestion',component:ViewquizequestionComponent
      },
      {
        path:'add-question',component:AddQuizesComponent
      }
    ],
  },
  {
    path:'user',
    component:UserDeshboardComponent,
    canActivate:[AuthGuard], 
    children:[
      {
        path:'cat',component:LoadQuizzeComponent
      },
      {
        path:'instruction',component:InstructionComponent
      },
      {
        path:'start',
        component:StartComponent
      }
    ]
  },
  {
    path:'**' ,component:WelcomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
