package com.example.demo.api;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addPerson(@RequestBody Student student) {
        studentService.addPerson(student);
    }

    @GetMapping
    public List<Student> getAllPeople() {
        return studentService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Student getPersonById(@PathVariable("id") UUID id) {
        return studentService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        studentService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Student studentToUpdate) {
        studentService.updatePerson(id, studentToUpdate);
    }
}
