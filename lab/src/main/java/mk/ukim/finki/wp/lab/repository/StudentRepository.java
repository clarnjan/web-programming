package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements StudentService {

    List<Student> students = new ArrayList<>();

    public StudentRepository() {
        Student st1 = new Student("Damjan", "D@mj4n", "Damjan", "Anakiev");
        Student st2 = new Student("Riste", "R!sT3", "Riste", "Stojanov");
        Student st3 = new Student("Kostadin", "K0stad!n", "Kostadin", "Mishev");
        Student st4 = new Student("Dimitar", "D!mit4r", "Dimitar", "Trajanov");
        Student st5 = new Student("Monika", "M0n!ka", "Monika", "Simjanoska");
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
    }

    @Override
    public List<Student> findAllStudents() {
        return students;
    }

    @Override
    public List<Student> findAllByNameOrSurname(String text) {
        List<Student> studentsWithText = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(text) || student.getSurname().contains(text))
                studentsWithText.add(student);
        }
        return studentsWithText;
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        Student student = new Student(username, password, name, surname);
        students.add(student);
        return student;
    }
}
