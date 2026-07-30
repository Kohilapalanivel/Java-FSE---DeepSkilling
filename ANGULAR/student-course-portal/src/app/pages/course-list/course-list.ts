import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { CourseService } from '../../services/course';


@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent {


  courses:any[] = [];


  constructor(
    private courseService: CourseService,
    private router: Router
  ){}



  ngOnInit(){

    this.courses = this.courseService.getCourses();

  }



  viewCourse(id:number){

    this.router.navigate(
      ['/courses', id]
    );

  }


}