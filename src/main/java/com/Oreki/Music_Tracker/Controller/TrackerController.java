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

import com.Oreki.Music_Tracker.Models.Tracker;
import com.Oreki.Music_Tracker.StudentDao;

@RestController
@RequestMapping("/tracker")
public class TrackerController {
        
    @Autowired
    private StudentDao studentDao;


    @GetMapping("/getAll")
    public List<Tracker> getTrackers(){
        return studentDao.getAllTrackers();
        
    }
    @GetMapping("/getByStudent")
    public List<Tracker> getTrackerByStudent(@RequestParam int studentID){
        return studentDao.getTrackerByStudentID(studentID);
        
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTracker(@RequestBody Tracker tracker){
        boolean dupeCheck = studentDao.saveTracker(tracker);
        
        if(dupeCheck){
            return new ResponseEntity<>("Record added successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Record already exists",HttpStatus.NOT_FOUND);
        }
        

        
        
    }
    @PostMapping("/update")
    public void updateTracker(@RequestBody Tracker tracker){
        studentDao.updateTracker(tracker);
        
    }

    @DeleteMapping("/delete")
    public void deleteTrackerById(@RequestParam int id){
        studentDao.deleteTracker(id);
    }

}
