package com.Oreki.Music_Tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.Oreki.Music_Tracker.Models.Exercise;
import com.Oreki.Music_Tracker.Models.Student;
import com.Oreki.Music_Tracker.Models.Tracker;

@Service
public class StudentDao {
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private ExerciseRepository exerciseRepo;

    @Autowired
    private TrackerRepository trackerRepo;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        Streamable.of(studentRepo.findAll()).forEach(students::add);
        return students;
    }

    public void saveStudent(Student student){
        studentRepo.save(student);
    }

    public boolean deleteStudent(int id){

        // Checking if the exercise id exist in tracker table
        List<Tracker> tracker = new ArrayList<>();
        Streamable.of(trackerRepo.findAll()).filter(record -> record.getStudentID() == id).forEach(tracker::add);
        studentRepo.deleteById(id);
        if(!tracker.isEmpty()){
            tracker.forEach(record -> trackerRepo.delete(record));
            return true;
        }
        else{
            return false;
        }
        
        

    }

    public void updateStudent(Student student){
        studentRepo.save(student);

    }

    // For Exercise table

    public List<Exercise> getAllExercises(){
        List<Exercise> exercise = new ArrayList<>();
        Streamable.of(exerciseRepo.findAll()).forEach(exercise::add);
        return exercise;
    }

    public List<Exercise> getAllExerciseById(int id){
        List<Exercise> exercise = new ArrayList<>();
        Streamable.of(exerciseRepo.findAll()).filter(record-> record.getId()==id).forEach(exercise::add);
        return exercise;
    }

    public void saveExercise(Exercise exercise){
        exerciseRepo.save(exercise);
    }

    public boolean deleteExercise(int id){

        // Checking if the exercise id exist in tracker table
        List<Tracker> tracker = new ArrayList<>();
        Streamable.of(trackerRepo.findAll()).filter(record -> record.getExeID() == id).forEach(tracker::add);
        if(tracker.isEmpty()){
            exerciseRepo.deleteById(id);
            return true;
        }
        else{
            return false;
        }
        

    }
    
    public void updateExercise(Exercise exercise){
        exerciseRepo.save(exercise);

    }

    // For Tracker table

    public List<Tracker> getAllTrackers(){
        List<Tracker> trackers = new ArrayList<>();
        Streamable.of(trackerRepo.findAll()).forEach(trackers::add);
        return trackers;
    }

    public List<Tracker> getTrackerByStudentID(int studentID){
        List<Tracker> tracker = new ArrayList<>();
        Streamable.of(trackerRepo.findAll()).filter(record -> record.getStudentID() == studentID).forEach(tracker::add);
        return tracker;
    }

    public void saveTracker(Tracker tracker){
        trackerRepo.save(tracker);
    }

    public void deleteTracker(int id){
        trackerRepo.deleteById(id);
        

    }
    public void updateTracker(Tracker tracker){
        trackerRepo.save(tracker);

    }
}
