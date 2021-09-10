package mk.ukim.finki.lab1.web;


import mk.ukim.finki.lab1.model.Student;
import mk.ukim.finki.lab1.service.impl.CourseServiceImpl;
import mk.ukim.finki.lab1.service.impl.StudentServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListStudentServlet", urlPatterns = "/addStudent")
public class ListStudentServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final StudentServiceImpl studentService;
    private final CourseServiceImpl courseService;

    public ListStudentServlet(SpringTemplateEngine springTemplateEngine, StudentServiceImpl studentService, CourseServiceImpl courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp,req.getServletContext());
        String courseId= (String) req.getSession().getAttribute("courseId");
        context.setVariable("courseId",courseId);
        List<Student> studentList=studentService.listAll();
        List<Student> students = courseService.listStudentsByCourse(Long.valueOf(courseId));
        for(int i=0;i<studentList.size();i++){
            if(students.contains(studentList.get(i))){
                studentList.remove(i);
                i--;
            }
        }
        context.setVariable("studenti",studentList);
        this.springTemplateEngine.process("listStudents.html",context,resp.getWriter());
    }
}
