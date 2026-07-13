package in.strikes.crudSpringbootDemo.controller;


import in.strikes.crudSpringbootDemo.entity.Student;
import in.strikes.crudSpringbootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //This class handles HTTP requests and returns data (usually JSON) to the client
@RequestMapping("/api/students") //maps url to contoller or method
public class StudentController {



    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //api/students -- end point
    //create student

   @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
       Student createdStudent=studentService.createStudent(student);
       return ResponseEntity.status(201).body(createdStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student studentResp=studentService.getStudent(id);
        if(studentResp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentResp);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        // Implementation for getting all students

        List<Student> studentList = studentService.getAllStudents();
        if(studentList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentList);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentReq) {
        Student studentResp=studentService.updateStudent(id,studentReq);
        if(studentResp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Boolean isDeleted = studentService.deleteStudent(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }
    @PatchMapping ("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id) {
        Boolean isDeleted = studentService.deleteStudentSoftly(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }
    }


