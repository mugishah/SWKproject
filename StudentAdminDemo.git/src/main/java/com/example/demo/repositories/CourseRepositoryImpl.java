package com.example.demo.repositories;

import com.example.demo.models.Course;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements ICourseRepository{
    private Connection conn;

    public CourseRepositoryImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Course course) {
        return false;
    }

    @Override
    public Course read(int id) {
        Course courseToReturn = new Course();
        try {
            PreparedStatement getSingleCourse = conn.prepareStatement("SELECT * FROM Course WHERE course_id=?");
            ResultSet rs = getSingleCourse.executeQuery();
            while(rs.next()){
                courseToReturn = new Course();
                courseToReturn.setCourseID(rs.getInt(1));
                courseToReturn.setCourseName(rs.getString(2));
                courseToReturn.setEnrollment(rs.getDate(3));
                courseToReturn.setDescription(rs.getString(4));
                courseToReturn.setEtcs(rs.getInt(5));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return courseToReturn;
    }

    @Override
    public List<Course> readAll() {
        List<Course> allCourses = new ArrayList<Course>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM courses");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Course tempCourse = new Course();
                tempCourse.setCourseID(rs.getInt(1));
                tempCourse.setCourseName(rs.getString(2));
                tempCourse.setEnrollment(rs.getDate(3));
                tempCourse.setDescription(rs.getString(4));
                tempCourse.setEtcs(rs.getInt(5));
                allCourses.add(tempCourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCourses;
    }

    @Override
    public boolean update(Course course) {
        return false;
    }

    @Override
    public boolean delete(int courseID) {
        return false;
    }
}
