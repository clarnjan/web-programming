package mk.finki.ukim.wp.lab.repository.impl;

import mk.finki.ukim.wp.lab.model.Course;
import mk.finki.ukim.wp.lab.model.Student;
import mk.finki.ukim.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCourseRepository {
    public static List<Course> courses;

    public InMemoryCourseRepository() {
//        List<Student> students = new ArrayList<>();
//        Course co1 = new Course("Veb programiranje", "Nogu jak predmet", students);
//        Course co2 = new Course("Napredno programiranje", "jak predmet", students);
//        Course co3 = new Course("Napreden veb dizajn", "predmet", students);
//        Course co4 = new Course("Programiranje na video igri i specijalni efekti", "Nogu jak predmet", students);
//        Course co5 = new Course("Implementacija na sistemi so otvoren kod", "jak predmet", students);
//        courses = new ArrayList<>();
//        co1.setType(Type.SUMMER);
//        co2.setType(Type.SUMMER);
//        co3.setType(Type.WINTER);
//        co4.setType(Type.MANDATORY);
//        co5.setType(Type.ELECTIVE);
//        courses.add(co1);
//        courses.add(co2);
//        courses.add(co3);
//        courses.add(co4);
//        courses.add(co5);
    }

    public List<Course> findAllCourses() {
        return courses;
    }

    public Course findById(long courseId) {
        Optional<Course> course = courses.stream().filter(x-> x.getCourseId().equals(courseId)).findAny();
        if(course.isPresent())
            return  course.get();
        return null;
    }

    public List<Student> findAllStudentsByCourse(long courseId) {
        return findById(courseId).getStudents();
    }

    public Course addStudentToCourse(Student student, Course course) {
        List<Student> students = findAllStudentsByCourse(course.getCourseId());
        students.add(student);
        course.setStudents(students);
        return course;
    }

    public void save(String name, String description, Teacher teacher) {
        Optional<Course> optionalCourse = courses.stream().filter(x->x.getName().equals(name)).findAny();
        Course course=null;
        if(optionalCourse.isPresent()) {
            course = optionalCourse.get();
            course.setTeacher(teacher);
            course.setName(name);
            course.setDescription(description);
        }
        else {
//            course = new Course(name, description, new ArrayList<>());
//            course.setTeacher(teacher);
//            courses.add(course);
        }
    }
}
