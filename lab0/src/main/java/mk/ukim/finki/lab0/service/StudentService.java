package mk.ukim.finki.lab0.service;

import mk.ukim.finki.lab0.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();
    List<Student> searchByNameOrSurname(String text);
    Student findByUserName(String username);
    Student save(String username, String password, String name, String surname);

}
