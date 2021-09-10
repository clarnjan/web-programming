package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements CourseService {
    private List<Course> courses;

    public CourseRepository() {
        Student st1 = new Student("Damjan", "D@mj4n", "Damjan", "Anakiev");
        Student st2 = new Student("Riste", "R!sT3", "Riste", "Stojanov");
        Student st3 = new Student("Kostadin", "K0stad!n", "Kostadin", "Mishev");
        Student st4 = new Student("Dimitar", "D!mit4r", "Dimitar", "Trajanov");
        Student st5 = new Student("Monika", "M0n!ka", "Monika", "Simjanoska");
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        Course co1 = new Course((long) 0, "Veb programiranje", "Nogu jak predmet", students);
        students.remove(st2);
        Course co2 = new Course((long) 1, "Napredno programiranje", "jak predmet", students);
        students.remove(st3);
        students.add(st5);
        Course co3 = new Course((long) 2, "Napreden veb dizajn", "predmet", students);
        students.remove(st1);
        students.remove(st4);
        students.add(st3);
        Course co4 = new Course((long) 3, "Programiranje na video igri i specijalni efekti", "Nogu jak predmet", students);
        students.add(st1);
        students.add(st2);
        students.add(st4);
        Course co5 = new Course((long) 4, "Implementacija na sistemi so otvoren kod", "jak predmet", students);
        courses = new ArrayList<>();
        courses.add(co1);
        courses.add(co2);
        courses.add(co3);
        courses.add(co4);
        courses.add(co5);
    }

    public List<Course> findAllCourses() {
        return courses;
    }

    public Course findById(long courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId))
                return course;
        }
        return null;
    }

    @Override
    public List<Student> findAllStudentsByCourse(long courseId) {
        return findById(courseId).getStudents();
    }

    @Override
    public Course addStudentToCourse(Student student, long courseId) {
        List<Student> students = findAllStudentsByCourse(courseId);
        students.add(student);
        Course course = findById(courseId);
        course.setStudents(students);
        return course;
    }
}
