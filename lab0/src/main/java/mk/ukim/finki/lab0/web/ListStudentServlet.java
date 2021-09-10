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
import java.io.PrintWriter;

@WebServlet(name="ListStudentServlet",urlPatterns = "/listStudents")
public class ListStudentServlet extends HttpServlet {

    private final StudentServiceImpl studentService;
    private  final SpringTemplateEngine springTemplateEngine;

    public ListStudentServlet(StudentServiceImpl studentService, SpringTemplateEngine springTemplateEngine) {
        this.studentService = studentService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp,req.getServletContext());
        String courseId= (String) req.getSession().getAttribute("courseId");
        context.setVariable("lista",studentService.listAll());
        context.setVariable("courseId",courseId);
        this.springTemplateEngine.process("listStudents.html",context,resp.getWriter());
    }


}
