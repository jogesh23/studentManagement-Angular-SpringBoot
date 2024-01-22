import { Component } from '@angular/core';
import { Student } from 'src/Student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent {

    constructor(private studentService:StudentService, private router:Router){}
     student:Student = new Student();
    submitted = false;

    onSubmit(){
      this.submitted=true;
      this.save();
    }

    save(){
      this.studentService.createStudent(this.student).subscribe(data => {
        console.log(data)
        this.student = new Student();
        this.router.navigate(['/students']);
      },
       error => console.log(error));
    }
}
