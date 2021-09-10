package mk.finki.ukim.wp.lab.repository.impl;

import mk.finki.ukim.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryTeacherRepository {
    private static List<Teacher> teacherList;

    public InMemoryTeacherRepository() {
//        teacherList=new ArrayList<>();
//        Teacher t0=new Teacher(0l,"Riste","Stojanov");
//        Teacher t1=new Teacher(1l,"Kostadin","Mishev");
//        Teacher t2=new Teacher(2l,"Ana","Todorovska");
//        Teacher t3=new Teacher(3l,"Dimitar","Trajanov");
//        Teacher t4=new Teacher(4l,"Ivan","Chorbev");
//        teacherList.add(t0);
//        teacherList.add(t1);
//        teacherList.add(t2);
//        teacherList.add(t3);
//        teacherList.add(t4);
    }

    public List<Teacher> findAll(){
        return teacherList;
    }
}
