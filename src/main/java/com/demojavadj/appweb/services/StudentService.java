package com.demojavadj.appweb.services;

import com.demojavadj.appweb.models.Student;

import java.util.AbstractList;
import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    void addStudent(Student student);
    Student getStudent(Long id);
    void deleteStudent(Long id);
}
