package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;

import java.util.List;

public interface CourseService {
    List<Student> findAllStudentsByCourse(long courseId);

    Course addStudentToCourse(Student student, long courseId);
}
