package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Override
    public List<Student> findAllStudentsByCourse(long courseId) {
        return null;
    }

    @Override
    public Course addStudentToCourse(Student student, long courseId) {
        return null;
    }
}
