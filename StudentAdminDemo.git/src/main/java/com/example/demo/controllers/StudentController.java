package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.repositories.InMemoryStudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private IStudentRepository studentRepository;

    public StudentController()
    {
        studentRepository = new InMemoryStudentRepositoryImpl();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

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

    @GetMapping("/student")
    public String studentHomePage(Model model){
        model.addAttribute("students", studentRepository.readAll());
        return "/studentPage/studentHomePage";
    }

    @GetMapping("/student/create-student")
    public String createStudent(){
        return "/studentPage/createStudent";
    }

    @GetMapping("/courseOverview")
    public String readCourses(){
        return "/coursePage/courseOverview";
    }

    @GetMapping("/coursePage/createCourse")
    public String createCourse(){
        return "/coursePage/createCourses";
    }

    @GetMapping("/about-us")
    public String readAboutUs(){
        return "/aboutUsPage/aboutUsPage";
    }
}