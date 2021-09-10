package mk.ukim.finki.proba.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CoursesController {

    @GetMapping
    public String getCourses(){
        return "courses";
    }

    @GetMapping("/course/add")
    public String addCourse(){
        return "addCourse";
    }
}
