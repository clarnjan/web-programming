package mk.ukim.finki.lab1.repository.jpa;

import mk.ukim.finki.lab1.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    void deleteByName(String name);
    List<Course> findByOrderByNameAsc();
    Course findByCourseId(Long courseId);
    List<Course> findByNameStartingWithOrderByName(String search);
    List<Course> findAllByNameContainingOrDescriptionContainingOrderByName(String name,String description);
//    List<Course> findAllByNameOrDescriptionOrderByName(String search);
}
