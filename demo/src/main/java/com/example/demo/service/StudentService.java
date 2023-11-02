package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    //Reference to PersonDao
    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("studentDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addPerson(Student student) {
        return studentDao.insertPerson(student);
    }

    public List<Student> getAllPeople() {
        return studentDao.selectAllPeople();
    }

    public Optional<Student> getPersonById(UUID id) {
        return studentDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return studentDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Student newStudent) {
        return studentDao.updatePersonById(id, newStudent);
    }
}
