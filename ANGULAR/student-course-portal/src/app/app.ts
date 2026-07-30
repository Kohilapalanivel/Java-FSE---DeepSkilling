import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { Header } from './components/header/header';
import { Home } from './pages/home/home';
import { CourseListComponent } from './pages/course-list/course-list';import { CourseSummaryWidget } from './components/course-summary-widget/course-summary-widget';
import { EnrollmentForm } from './pages/enrollment-form/enrollment-form';
import { ReactiveEnrollmentForm } from './pages/reactive-enrollment-form/reactive-enrollment-form';
import { Notification } from './components/notification/notification';
import { StudentProfile } from './pages/student-profile/student-profile';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    Header,
    Home,
CourseListComponent,
    CourseSummaryWidget,
    EnrollmentForm,
    ReactiveEnrollmentForm,
    Notification,
    StudentProfile
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  title = 'student-course-portal';

}