package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.Student;
import com.example.demo.repositories.ICourseRepository;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.repositories.InMemoryCourseRepositoryImpl;
import com.example.demo.repositories.InMemoryStudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private IStudentRepository studentRepository;
    private ICourseRepository courseRepository;

    public StudentController()
    {
        studentRepository = new InMemoryStudentRepositoryImpl();
        courseRepository = new InMemoryCourseRepositoryImpl();
    }

    //Home controller page
    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    //Student controller page

    //Very simple prototype of GET-request with parameter
    //https://www.baeldung.com/spring-request-param
    //TODO Direct to detailed view of student
    @GetMapping("/student-detail")
    @ResponseBody
    public String getStudentByParameter(@RequestParam int id) {
        Student stud = studentRepository.read(id);
        return "ID " + stud.getId() + "\nName " + stud.getFirstName() + " " + stud.getLastName() +
                "Enrollment date " + stud.getEnrollmentDate() + "\nCPR " + stud.getCpr();
    }

    @GetMapping("/studentOverview")
    public String studentHomePage(Model model){
        model.addAttribute("students", studentRepository.readAll());
        return "/studentPage/studentOverview";
    }

    @GetMapping("/createStudent")
    public String createStudent()
    {
        return "/studentPage/createStudent";
    }

    //Course controller pages
    @GetMapping
    @ResponseBody
    public String getCourseByParameter(@RequestParam int id){
        Course course = courseRepository.read(id);
        return "ID " + course.getCourseID() + "\nCourse name" + course.getCourseName() + "" +
                course.getCourseName() + "Enrollment date" + course.getEnrollment() + "\nETC " + course.getEtcs();
    }

    @GetMapping("/courseOverview")
    public String readCourses(Model model)
    {
        model.addAttribute("Courses", studentRepository.readAll());
        return "/coursePage/courseOverview";
    }

    @GetMapping("/createCourse")
    public String createCourse()
    {
        return "/coursePage/createCourse";
    }


    //About us controller page
    @GetMapping("/about-us")
    public String readAboutUs()
    {
        return "/aboutUsPage/aboutUsPage";
    }
}