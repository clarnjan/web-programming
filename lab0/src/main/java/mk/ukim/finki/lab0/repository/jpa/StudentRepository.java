package mk.ukim.finki.lab0.repository.jpa;

import mk.ukim.finki.lab0.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    Student findByUsername(String username);
    void deleteByUsername(String username);


}
