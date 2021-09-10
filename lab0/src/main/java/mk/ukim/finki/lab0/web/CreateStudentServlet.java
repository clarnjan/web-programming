package mk.ukim.finki.lab0.web;

import mk.ukim.finki.lab0.service.impl.StudentServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="createstudent",urlPatterns = "/createStudent")
public class CreateStudentServlet extends HttpServlet {

    private  final SpringTemplateEngine springTemplateEngine;
    private final StudentServiceImpl studentService;

    public CreateStudentServlet(SpringTemplateEngine springTemplateEngine, StudentServiceImpl studentService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp,req.getServletContext());
        this.springTemplateEngine.process("createStudent.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String name=req.getParameter("name");
        String pasword=req.getParameter("pasword");
        String surname=req.getParameter("surname");
        studentService.save(username,pasword,name,surname);
        resp.sendRedirect("/listStudents");
    }
}
