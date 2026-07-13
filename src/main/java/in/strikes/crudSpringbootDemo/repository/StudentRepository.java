package in.strikes.crudSpringbootDemo.repository;

import in.strikes.crudSpringbootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



    public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIdAndDeletedFalse(Long id);

    List<Student> findByDeletedFalse();


    // Additional custom query methods can be defined here if needed

}
