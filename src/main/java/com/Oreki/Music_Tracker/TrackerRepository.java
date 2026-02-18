package com.Oreki.Music_Tracker;

import org.springframework.data.repository.CrudRepository;

import com.Oreki.Music_Tracker.Models.Tracker;

public interface TrackerRepository extends CrudRepository<Tracker, Integer>{
    
}
