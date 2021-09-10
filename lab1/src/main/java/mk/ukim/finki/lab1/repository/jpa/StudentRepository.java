package mk.ukim.finki.lab1.repository.jpa;

import mk.ukim.finki.lab1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    Student findByUsername(String username);
    void deleteByUsername(String username);
}
