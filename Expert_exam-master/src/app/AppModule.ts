import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/LoginComponent';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { CategoriesComponent } from './categories/categories.component';
import { AddCategoriesComponent } from './add-categories/add-categories.component';
import { QuizzesComponent } from './quizzes/quizzes.component';
import { AddQuizesComponent } from './add-quizes/add-quizes.component';
import { LogoutComponent } from './logout/logout.component';
import { AdminSidebarComponent } from './admin-sidebar/admin-sidebar.component';
import { UserSidebarComponent } from './user-sidebar/user-sidebar.component';
import { InstructionComponent } from './instruction/instruction.component';
import { LoadQuizzeComponent } from './load-quizze/load-quizze.component';
import { StartComponent } from './start/start.component';
import { UserDeshboardComponent } from './user-deshboard/user-deshboard.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { NavbarComponent } from './navbar/navbar.component';
import { QuizeInstructionComponent } from './quize-instruction/quize-instruction.component';
import { AdminDeshboardComponent } from './admin-deshboard/admin-deshboard.component';
import { UpdatequizzeComponent } from './updatequizze/updatequizze.component';
import { ViewquizequestionComponent } from './viewquizequestion/viewquizequestion.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { authInterceptorProviders } from './auth.intercepter';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    CategoriesComponent,
    AddCategoriesComponent,
    QuizzesComponent,
    AddQuizesComponent,
    LogoutComponent,
    AdminSidebarComponent,
    UserSidebarComponent,
    InstructionComponent,
    LoadQuizzeComponent,
    StartComponent,
    UserDeshboardComponent,
    WelcomeComponent,
    NavbarComponent,
    QuizeInstructionComponent,
    AdminDeshboardComponent,
    UpdatequizzeComponent,
    ViewquizequestionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers:[authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
