package com.Oreki.Music_Tracker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Oreki.Music_Tracker.Models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{
    
}
