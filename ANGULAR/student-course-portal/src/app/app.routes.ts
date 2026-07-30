import { Routes } from '@angular/router';

import { Home } from './pages/home/home';
import { CourseListComponent } from './pages/course-list/course-list';
import { CourseDetail } from './pages/course-detail/course-detail';
import { StudentProfile } from './pages/student-profile/student-profile';
import { NotFound } from './pages/not-found/not-found';
import { CoursesLayoutComponent } from './pages/courses-layout/courses-layout';


export const routes: Routes = [

  {
    path: '',
    component: Home
  },

  {
    path: 'courses',
    component: CoursesLayoutComponent,

    children: [
      {
        path: '',
        component: CourseListComponent
      },

      {
        path: ':id',
        component: CourseDetail
      }
    ]
  },


  {
    path: 'profile',
    component: StudentProfile
  },


  {
    path: '**',
    component: NotFound
  }

];