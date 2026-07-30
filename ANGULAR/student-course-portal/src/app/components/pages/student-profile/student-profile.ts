import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EnrollmentService } from '../../services/enrollment';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css'
})
export class StudentProfile {

  name = 'Kohila P';
  department = 'AI & Data Science';
  year = 'III Year';
  email = 'kohila@example.com';

  constructor(public enrollmentService: EnrollmentService) {}

}