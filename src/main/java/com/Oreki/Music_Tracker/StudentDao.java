package com.Oreki.Music_Tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class StudentDao {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(students::add);
        return students;
    }

    public void save(Student student){
        repository.save(student);
    }

    public void delete(Student student){
        repository.delete(student);

    }
}
