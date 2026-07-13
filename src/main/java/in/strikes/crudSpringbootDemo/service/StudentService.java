package in.strikes.crudSpringbootDemo.service;

import in.strikes.crudSpringbootDemo.entity.Student;
import in.strikes.crudSpringbootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        // System.out.println("Inside StudentService");
        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq);
        // System.out.println("Exiting StudentService");
        return studentResp;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedFalse(id);
        if (studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findByDeletedFalse();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {

        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedFalse(id);

        if (existingStudent.isEmpty()) {
            return null;
        }

        Student student = existingStudent.get();

        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setRollNo(studentReq.getRollNo());
        student.setAge(studentReq.getAge());
        student.setSubject(studentReq.getSubject());
        student.setDeleted(false);
        return studentRepository.save(student);
    }
    public Boolean deleteStudent(Long id) {
        Boolean isStudent=studentRepository.existsById(id);
       if(!isStudent){
           return false;
       }
       studentRepository.deleteById(id);
       return true;
    }
    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedFalse(id);
        if (existingStudent.isEmpty()) {
            return false;
        }
        Student studentTosSave = existingStudent.get();
        studentTosSave.setDeleted(true);
        studentRepository.save(studentTosSave);
        return true;

    }
}
    //end point is student
    //end point is student

