package mk.ukim.finki.lab1.repository.jpa;

import mk.ukim.finki.lab1.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Long> {
    Optional<Grade> findByStudent_UsernameAndCourse_CourseId(String username, Long courseId);
    void deleteAllByCourse_CourseId(Long id);
}
