package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    //inserts person with a given id
    int insertPerson(UUID id, Student student);

    //adds a person without an id
    default int insertPerson(Student student) {
        UUID id  = UUID.randomUUID();
        return insertPerson(id, student);
    }

    List<Student> selectAllPeople();

    Optional<Student> selectPersonById (UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Student student);
}
