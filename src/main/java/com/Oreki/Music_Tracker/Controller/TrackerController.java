package com.Oreki.Music_Tracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Oreki.Music_Tracker.StudentDao;
import com.Oreki.Music_Tracker.Models.Exercise;
import com.Oreki.Music_Tracker.Models.Tracker;

public class TrackerController {
        
    @Autowired
    private StudentDao studentDao;


    @GetMapping("/tracker/getAll")
    public List<Exercise> getExercises(){
        return studentDao.getAllExercises();
        
    }
    @GetMapping("/tracker/getByStudent")
    public List<Tracker> getTrackerByStudent(@RequestParam int studentID){
        return studentDao.getTrackerByStudentID(studentID);
        
    }

    @PostMapping("/exercise/save")
    public void saveExercise(@RequestBody Exercise exercise){
        studentDao.saveExercise(exercise);
        
        
    }
    @PostMapping("/exercise/update")
    public void updateExercise(@RequestBody Exercise exercise){
        studentDao.updateExercise(exercise);
        
        
    }
}
