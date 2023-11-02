package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("studentDao")
public class StudentDataAccessService implements StudentDao {
    private static List<Student> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Student student) {
        DB.add(new Student(id, student.getName()));
        return 0;
    }

    @Override
    public List<Student> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Student> selectPersonById(UUID id) {
        return DB.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Student> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Student update) {
        return selectPersonById(id)
                .map(student -> {
                    int indexOfPersonToUpdate = DB.indexOf(student);
                    if (indexOfPersonToUpdate >=0) {
                        DB.set(indexOfPersonToUpdate, new Student(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
