package mk.ukim.finki.lab0.repository.jpa;

import mk.ukim.finki.lab0.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {



}
