import { Injectable } from '@angular/core';
import { Course } from '../models/course';


@Injectable({
  providedIn: 'root'
})
export class CourseService {


  private courses: Course[] = [

    {
      id: 1,
      code: "ANG101",
      name: "Angular",
      credits: 4,
      gradeStatus: "Available"
    },

    {
      id: 2,
      code: "JAVA101",
      name: "Java Spring Boot",
      credits: 5,
      gradeStatus: "Available"
    },

    {
      id: 3,
      code: "REACT101",
      name: "React",
      credits: 3,
      gradeStatus: "Available"
    }

  ];


  constructor(){}



  getCourses(): Course[] {

    return this.courses;

  }



  getCourseById(id:number): Course | undefined {

    return this.courses.find(
      course => course.id === id
    );

  }


}