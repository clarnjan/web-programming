package mk.ukim.finki.lab0.service;

import mk.ukim.finki.lab0.model.Course;
import mk.ukim.finki.lab0.model.Grade;
import mk.ukim.finki.lab0.model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> listAll();
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);


    Optional<Course> findById(Long id);

    void save(String courseId, String name, String description, Long teacherId);

    List<Grade> getStudentGrades(Long courseId);
}
