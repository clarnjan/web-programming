package mk.ukim.finki.lab1.web;

import mk.ukim.finki.lab1.model.Course;
import mk.ukim.finki.lab1.model.Grade;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentEnrollmentSummary", urlPatterns ="/studentEnrollmentSummary")
public class StudentEnrollmentSummary extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final CourseServiceImpl courseService;

    public StudentEnrollmentSummary(SpringTemplateEngine springTemplateEngine, CourseServiceImpl courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = courseService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp,req.getServletContext());
        String username= req.getParameter("username");
        Long courseId=Long.parseLong((String) req.getSession().getAttribute("courseId"));
        Course course = courseService.addStudentInCourse(username,courseId);
        List<Student> students = courseService.listStudentsByCourse(courseId);
        List<Grade> grades = courseService.getStudentGrades(courseId);

        context.setVariable("course",course);
        context.setVariable("studenti",students);
        context.setVariable("grades",grades);
        this.springTemplateEngine.process("studentsInCourse.html",context,resp.getWriter());
    }
}
