import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
  AbstractControl,
  ValidationErrors,
  FormArray,
  FormControl,
  AsyncValidatorFn
} from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentForm implements OnInit {

  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {

    this.enrollForm = this.fb.group({

      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],

      studentEmail: this.fb.control(
        '',
        [Validators.required, Validators.email],
        [this.simulateEmailCheck()]
      ),

      courseId: [
        '',
        [
          Validators.required,
          this.noCourseCode
        ]
      ],

      preferredSemester: [
        'Odd',
        Validators.required
      ],

      agreeToTerms: [
        false,
        Validators.requiredTrue
      ],

      additionalCourses: this.fb.array([])

    });

  }

  onSubmit(): void {

    console.log("Form Value :", this.enrollForm.value);

    // value excludes disabled controls
    console.log("Raw Value :", this.enrollForm.getRawValue());

  }

  // Custom Validator
  noCourseCode(control: AbstractControl): ValidationErrors | null {

    const value = control.value;

    if (value && value.toString().startsWith('XX')) {
      return { noCourseCode: true };
    }

    return null;

  }

  // Async Validator
  simulateEmailCheck(): AsyncValidatorFn {

    return (control: AbstractControl) => {

      return new Promise<ValidationErrors | null>((resolve) => {

        setTimeout(() => {

          if (control.value && control.value.includes('test@')) {
            resolve({ emailTaken: true });
          } else {
            resolve(null);
          }

        }, 800);

      });

    };

  }

  // Getter keeps template clean
  get additionalCourses(): FormArray {

    return this.enrollForm.get('additionalCourses') as FormArray;

  }

  addCourse(): void {

    this.additionalCourses.push(
      new FormControl('', Validators.required)
    );

  }

  removeCourse(index: number): void {

    this.additionalCourses.removeAt(index);

  }

}