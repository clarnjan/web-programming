package mk.ukim.finki.lab0.web.controller;


import mk.ukim.finki.lab0.model.Course;
import mk.ukim.finki.lab0.model.Teacher;
import mk.ukim.finki.lab0.service.impl.CourseServiceImpl;
import mk.ukim.finki.lab0.service.impl.TeacherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getCoursesPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Course> courseArrayList = courseService.sort();
        model.addAttribute("list", courseArrayList);
        return "listCourses";
    }

    @GetMapping("/edit-form/{id}")
    public String editCourse(@PathVariable Long id, Model model) {
        Course course = courseService.findById(id).get();
        if (course == null) {
            return "redirect:/courses?error=no course found with id=" + id;
        }
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("course", course);
        model.addAttribute("teacherList", teacherList);
        return "add-course";
    }

    @GetMapping("/add")
    public String addCourse(Model model) {
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("teacherList", teacherList);
        return "add-course";
    }

    @PostMapping("/save")
    public String saveCourse(String courseId,String name, String description, Long teacherId) {
        courseService.save(courseId,name, description, teacherId);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
          courseService.deleteById(id);
//        Course course = courseService.listAll().stream().filter(x -> x.getCourseId().equals(id)).findFirst().get();
//        courseService.listAll().remove(course);
        return "redirect:/courses";
    }

    @PostMapping("/search")
    public String searchCourse(String search, Model model) {
        List<Course> courseList=courseService.search(search);
//        List<Course> courseList=courseService.listAll().stream().filter(x->x.getTip().toString().toLowerCase().contains(search))
//                .sorted(Comparator.comparing(y->y.getName().toLowerCase())).collect(Collectors.toList());
                model.addAttribute("list",courseList);
        return "listCourses";
    }

}
