import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { CourseService } from '../../services/course';


@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './course-detail.html',
  styleUrl: './course-detail.css'
})
export class CourseDetail {


  course:any;


  constructor(
    private route: ActivatedRoute,
    private courseService: CourseService
  ){}


  ngOnInit(){

    const id = Number(
      this.route.snapshot.paramMap.get('id')
    );


    this.course = this.courseService.getCourseById(id);

  }

}