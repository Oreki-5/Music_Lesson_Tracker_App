package com.Oreki.Music_Tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Streamable.of(studentRepo.findAll()).forEach(students::add);
        return students;
    }

    public String saveStudent(Student student) {
        List<Student> dupes = new ArrayList<>();
        Streamable.of(studentRepo.findAll()).filter(record -> record.getUsername().equals(student.getUsername()))
                .forEach(dupes::add);

        if (dupes.isEmpty()) {
            if (Pattern.matches("^(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{0,29}$", student.getUsername())) {
                studentRepo.save(student);
                return "ok";
            }
            return "pattern_fail";

        } else {
            return "duplicate";
        }

    }

    public boolean deleteStudent(int id) {

        // Checking if the exercise id exist in tracker table
        List<Tracker> tracker = new ArrayList<>();
        Streamable.of(trackerRepo.findAll()).filter(record -> record.getStudentID() == id).forEach(tracker::add);
        studentRepo.deleteById(id);
        if (!tracker.isEmpty()) {
            tracker.forEach(record -> trackerRepo.delete(record));
            return true;
        } else {
            return false;
        }

    }

    public void updateStudent(Student student) {
        studentRepo.save(student);

    }

    // For Exercise table

    public List<Exercise> getAllExercises() {
        List<Exercise> exercise = new ArrayList<>();
        Streamable.of(exerciseRepo.findAll()).forEach(exercise::add);
        return exercise;
    }

    public List<Exercise> getAllExerciseById(int id) {
        List<Exercise> exercise = new ArrayList<>();
        Streamable.of(exerciseRepo.findAll()).filter(record -> record.getId() == id).forEach(exercise::add);
        return exercise;
    }

    public boolean saveExercise(Exercise exercise) {
        List<Exercise> dupes = new ArrayList<>();
        Streamable.of(exerciseRepo.findAll()).filter(record -> record.getTitle().equals(exercise.getTitle()))
                .forEach(dupes::add);

        if (dupes.isEmpty()) {

            exerciseRepo.save(exercise);
            return true;
        } else {
            return false;
        }

    }

    public boolean deleteExercise(int id) {

        // Checking if the exercise id exist in tracker table
        List<Tracker> tracker = new ArrayList<>();
        Streamable.of(trackerRepo.findAll()).filter(record -> record.getExeID() == id).forEach(tracker::add);
        if (tracker.isEmpty()) {
            exerciseRepo.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    public void updateExercise(Exercise exercise) {
        exerciseRepo.save(exercise);

    }

    // For Tracker table

    public List<Tracker> getAllTrackers() {
        List<Tracker> trackers = new ArrayList<>();
        Streamable.of(trackerRepo.findAll()).forEach(trackers::add);
        return trackers;
    }

    public List<Tracker> getTrackerByStudentID(int studentID) {
        List<Tracker> tracker = new ArrayList<>();
        Streamable.of(trackerRepo.findAll()).filter(record -> record.getStudentID() == studentID).forEach(tracker::add);
        return tracker;
    }

    public boolean saveTracker(Tracker tracker) {
        List<Tracker> dupes = new ArrayList<>();
        Streamable.of(trackerRepo.findAll()).filter(
                record -> record.getStudentID() == (tracker.getStudentID()) && record.getExeID() == tracker.getExeID())
                .forEach(dupes::add);

        if (dupes.isEmpty()) {

            trackerRepo.save(tracker);
            return true;
        } else {
            return false;
        }

    }

    public void deleteTracker(int id) {
        trackerRepo.deleteById(id);

    }

    public void updateTracker(Tracker tracker) {
        trackerRepo.save(tracker);

    }
}
