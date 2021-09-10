package mk.ukim.finki.lab1.web.controller;

import mk.ukim.finki.lab1.model.Course;
import mk.ukim.finki.lab1.model.Teacher;
import mk.ukim.finki.lab1.service.impl.CourseServiceImpl;
import mk.ukim.finki.lab1.service.impl.TeacherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseServiceImpl courseService;
    private final TeacherServiceImpl teacherService;

    public CourseController(CourseServiceImpl courseService, TeacherServiceImpl teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("list",courseService.sort());
        return "listCourses";
    }

    @GetMapping("/edit-form/{id}")
    public String editCourse(@PathVariable Long id, Model model){
        Course course = courseService.findById(id).get();
        if(course==null){
            return "redirect:/courses?error=no course found with id="+id;
        }
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("course",course);
        model.addAttribute("teacherList",teacherList);
        return "add-course";
    }

    @GetMapping("/add")
    public String addCourse(Model model){
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("teacherList",teacherList);
        return "add-course";
    }

    @PostMapping("/save")
    public String saveCourse(String courseId, String name, String description, Long teacherId){
        courseService.save(courseId, name, description, teacherId);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteById(id);
        return "redirect:/courses";
    }

    @PostMapping("/search")
    public String searchCourse(String search, Model model){
        List<Course> courses = courseService.search(search);
        model.addAttribute("list",courses);
        return "listCourses";
    }
}
