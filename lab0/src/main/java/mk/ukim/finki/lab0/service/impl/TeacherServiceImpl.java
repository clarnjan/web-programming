package mk.ukim.finki.lab0.service.impl;

import mk.ukim.finki.lab0.model.Teacher;
import mk.ukim.finki.lab0.repository.impl.InMemoryTeacherRepository;
import mk.ukim.finki.lab0.repository.jpa.TeacherRepository;
import mk.ukim.finki.lab0.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
