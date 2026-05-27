package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
        new Student(1, "Ravi Teja", "CSE", 85.5),
        new Student(2, "Anjali",   "ECE", 90.0),
        new Student(3, "Kiran",    "MBA", 78.3),
        new Student(4, "Priya",    "CSE", 92.1),
        new Student(5, "Arjun",    "EEE", 88.7)
    ));

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // GET student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream()
            .filter(s -> s.getId() == id)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Student not found: " + id));
    }

    // POST add new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.removeIf(s -> s.getId() == id);
        return "Student " + id + " deleted";
    }
}