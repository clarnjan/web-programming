package mk.ukim.finki.lab1.service.impl;


import mk.ukim.finki.lab1.model.Course;
import mk.ukim.finki.lab1.model.Grade;
import mk.ukim.finki.lab1.model.Student;
import mk.ukim.finki.lab1.model.Teacher;
import mk.ukim.finki.lab1.repository.jpa.CourseRepository;
import mk.ukim.finki.lab1.repository.jpa.GradeRepository;
import mk.ukim.finki.lab1.repository.jpa.StudentRepository;
import mk.ukim.finki.lab1.repository.jpa.TeacherRepository;
import mk.ukim.finki.lab1.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final GradeRepository gradeRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, GradeRepository gradeRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student=studentRepository.findByUsername(username);
        try {
            Course course = courseRepository.findById(courseId).get();
            List<Student> students = course.getStudents();
            students.add(student);
            course.setStudents(students);
            courseRepository.save(course);
            gradeRepository.save(new Grade('6',student,course));
            return course;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Student> listStudentsByCourse(Long courseId){
        Course course = courseRepository.findByCourseId(courseId);
        return course.getStudents();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void save(String courseId, String name, String description, Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if(!teacher.isEmpty()){
            if(!courseId.equals("")){
                courseRepository.deleteById(Long.parseLong(courseId));
            }
            courseRepository.save(new Course(name,description,teacher.get()));
        }
    }

    public List<Course> sort() {
        return courseRepository.findByOrderByNameAsc();
    }

    public void deleteById(Long id) {
//        gradeRepository.deleteAllByCourse_CourseId(id);
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> search(String search) {
        return courseRepository.findAllByNameContainingOrDescriptionContainingOrderByName(search,search);
    }

    @Override
    public List<Grade> getStudentGrades(Long courseId) {
       List<Student> students = listStudentsByCourse(courseId);
       List<Grade> grades=new ArrayList<>();
       for(int i=0;i<students.size();i++){
            Grade grade = gradeRepository.findByStudent_UsernameAndCourse_CourseId(students.get(i).getUsername(),courseId).get();
            grades.add(grade);
       }
       return grades;
    }
}
