package mk.ukim.finki.lab1.service;


import mk.ukim.finki.lab1.model.Course;
import mk.ukim.finki.lab1.model.Grade;
import mk.ukim.finki.lab1.model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> listAll();

    List<Student> listStudentsByCourse(Long courseId);

    Course addStudentInCourse(String username, Long courseId);

    Optional<Course> findById(Long id);

    void save(String courseId, String name, String description, Long teacherId);

    void deleteById(Long id);

    List<Course> search(String search);

    List<Grade> getStudentGrades(Long courseId);
}
