package com.Oreki.Music_Tracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki.Music_Tracker.Models.Student;
import com.Oreki.Music_Tracker.StudentDao;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentDao studentDao;


    @GetMapping("/getAll")
    public List<Student> getStudents(){
        return studentDao.getAllStudents();
        
    }

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student){
        studentDao.saveStudent(student);
        
        
    }
    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student){
        studentDao.updateStudent(student);
        
        
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudentById(@RequestParam int id){
        if(studentDao.deleteStudent(id)){
            return new ResponseEntity<>("Student Deleted. All Records of Student in Tracker table also Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Student ID not found",HttpStatus.NOT_FOUND);
        }
    }

    
}

