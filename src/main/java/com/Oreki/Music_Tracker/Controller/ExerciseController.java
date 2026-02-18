package com.Oreki.Music_Tracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Oreki.Music_Tracker.StudentDao;
import com.Oreki.Music_Tracker.Models.Student;

public class ExerciseController {
        
    @Autowired
    private StudentDao studentDao;


    @GetMapping("/students/getAll")
    public List<Student> getStudents(){
        return studentDao.getAllStudents();
        
    }

    @PostMapping("/students/save")
    public void saveStudent(@RequestBody Student student){
        studentDao.saveStudent(student);
        
        
    }
    @PostMapping("/students/update")
    public void updateStudent(@RequestBody Student student){
        studentDao.updateStudent(student);
        
        
    }
}
