package com.example.demo.repositories;

import com.example.demo.models.Course;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class InMemoryCourseRepositoryImpl implements ICourseRepository {
    private List<Course> inMemoryDatabase;

    public InMemoryCourseRepositoryImpl(){
        this.inMemoryDatabase = new ArrayList<Course>(
                Arrays.asList(
                        new Course(20201,"Software development",new Date(040520),25, "Programming language: Java, HTML, CSS, MySQL"),
                        new Course(20202,"Software Design",new Date(040520),25,"Designing in UML patterns"),
                        new Course(20203,"IT in Organisations",new Date(040520),25,"Learn about IT in organisations"),
                        new Course(20204,"Technology",new Date(040520),25,"Learn about technology on a higher level")
                )
        );
    }

    @Override
    public boolean create(Course course) {
        return false;
    }

    @Override
    public Course read(int id) {
        for(Course course : inMemoryDatabase){
            if(course.getCourseID() == id){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> readAll() {
        return inMemoryDatabase;
    }

    @Override
    public boolean update(Course course) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
