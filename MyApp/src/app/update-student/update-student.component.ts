import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'src/Student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  id: number;
  student: Student;
  submitted=false;

  constructor(private route: ActivatedRoute,private router: Router,
    private studentService: StudentService) { }

  ngOnInit(): void {
    this.student = new Student();
    this.id = this.route.snapshot.params['id'];
    //calling the service getStudent method by passing the id and subscribing
    this.studentService.getStudent(this.id)
    .subscribe(data => {
    console.log(data)
    this.student = data;
    }, error => console.log(error));
  }

  updateStudent() {

    //calling the service update student method by passing id, student property and subscribing
    this.studentService.updateStudent(this.id, this.student)
    .subscribe(data => {
    console.log(data);
    this.student = new Student();
    this.gotoList();
    }, error => console.log(error));
    
    }

    onSubmit() {
      this.updateStudent();
      }

      gotoList() {
        this.router.navigate(['/students']);
        }
}
