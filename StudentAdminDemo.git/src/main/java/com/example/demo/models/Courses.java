package com.example.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Courses {
    private String name;
    private Date enrollment;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // needed for input field on html pages (in order to serve the right format)
    private int etcs;
    private String description;

    public Courses(String name, Date enrollment, int etcs, String description) {
        this.name = name;
        this.enrollment = enrollment;
        this.etcs = etcs;
        this.description = description;
    }

    public String getName()                                     { return name; }
    public void setName(String name)                            { this.name = name; }
    public Date getEnrollment()                                 { return enrollment; }
    public void setEnrollment(Date enrollment)                  { this.enrollment = enrollment; }
    public int getEtcs()                                        { return etcs; }
    public void setEtcs(int etcs)                               { this.etcs = etcs; }
    public String getDescription()                              { return description; }
    public void setDescription(String description)              { this.description = description; }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", enrollment=" + enrollment +
                ", etcs=" + etcs +
                ", description='" + description + '\'' +
                '}';
    }
}
