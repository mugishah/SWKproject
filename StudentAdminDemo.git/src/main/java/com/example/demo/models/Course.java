package com.example.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {
    private int courseID;
    private String courseName;
    private Date enrollment;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // needed for input field on html pages (in order to serve the right format)
    private int etcs;
    private String description;

    public Course(int courseID, String name, Date enrollment, int etcs, String description) {
        this.courseID = courseID;
        this.courseName = name;
        this.enrollment = enrollment;
        this.etcs = etcs;
        this.description = description;
    }

    public Course()                                             {}
    public int getCourseID()                                    { return courseID; }
    public void setCourseID(int courseID)                       {this.courseID = courseID; }
    public String getCourseName()                                     { return courseName; }
    public void setCourseName(String courseName)                            { this.courseName = courseName; }
    public Date getEnrollment()                                 { return enrollment; }
    public void setEnrollment(Date enrollment)                  { this.enrollment = enrollment; }
    public int getEtcs()                                        { return etcs; }
    public void setEtcs(int etcs)                               { this.etcs = etcs; }
    public String getDescription()                              { return description; }
    public void setDescription(String description)              { this.description = description; }

    @Override
    public String toString() {
        return "Courses{" +
                "courseID='" + courseID + '\'' +
                "name='" + courseName + '\'' +
                ", enrollment=" + enrollment +
                ", etcs=" + etcs +
                ", description='" + description + '\'' +
                '}';
    }

}
