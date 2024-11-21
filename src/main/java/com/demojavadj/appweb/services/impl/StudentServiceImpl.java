package com.demojavadj.appweb.services.impl;

import com.demojavadj.appweb.models.Student;
import com.demojavadj.appweb.repository.StudentRepository;
import com.demojavadj.appweb.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll(); // select * from student
    }

    @Override
    public void addStudent(Student student) {
        Optional<Student> studentOne = studentRepository.findById(student.getId());
        if (studentOne.isPresent()){
            throw new RuntimeException("Ya Existe el estudiante con  id: " + student.getId());
        }
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> studentOne = studentRepository.findById(id);
        Student studentObj = studentOne.orElse(null);
        if (studentOne.isPresent()){
            studentObj = studentOne.get();
        } else {
            throw new RuntimeException("Estudiante no Existe el estudiante con id: " + id);
        }

        return studentObj;
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> studentOne = studentRepository.findById(id);
        if (studentOne.isPresent()){
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("El Estudiante no Existe con id: " + id);
        }
    }
}
