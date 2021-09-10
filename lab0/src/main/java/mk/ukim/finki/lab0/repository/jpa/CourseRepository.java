package mk.ukim.finki.lab0.repository.jpa;

import mk.ukim.finki.lab0.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findByOrderByNameAsc();
    List<Course> findAllByNameContainingOrDescriptionContainingOrTipContainingOrderByName(String name,String desc,String tip);
}
