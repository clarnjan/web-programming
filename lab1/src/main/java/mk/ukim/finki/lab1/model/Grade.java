package mk.ukim.finki.lab1.model;

import javax.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Character grade;
    @OneToOne
    private Student student;
    @OneToOne
    private Course course;

    public Grade(Character grade, Student student, Course course) {
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    public Grade() {
    }

    public String getUsername() {
        return student.getUsername();
    }

    public Character getGrade() {
        return grade;
    }
}
