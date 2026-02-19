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

import com.Oreki.Music_Tracker.Models.Exercise;
import com.Oreki.Music_Tracker.StudentDao;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
        
    @Autowired
    private StudentDao studentDao;


    @GetMapping("/getAll")
    public List<Exercise> getExercises(){
        return studentDao.getAllExercises();
        
    }

    @GetMapping("/getById")
    public List<Exercise> getExerciseById(@RequestParam int id){
        return studentDao.getAllExerciseById(id);
        
    }
    

    @PostMapping("/save")
    public void saveExercise(@RequestBody Exercise exercise){
        studentDao.saveExercise(exercise);
        
        
    }
    @PostMapping("/update")
    public void updateStudent(@RequestBody Exercise exercise){
        studentDao.updateExercise(exercise);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteExerciseById(@RequestParam int id){
        if(studentDao.deleteExercise(id)){
            return new ResponseEntity<>("Exercise Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("This Exercise is IN USE in the [ Tracker ] Table, please delete those records to continue",HttpStatus.LOCKED);
        }
    }
    
}
