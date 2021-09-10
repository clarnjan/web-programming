package mk.ukim.finki.lab1.service;


import mk.ukim.finki.lab1.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();

    List<Student> searchByNameOrSurname(String text);

    Student findByUsername(String username);

    Student save(String username, String password, String name, String surname);
}
