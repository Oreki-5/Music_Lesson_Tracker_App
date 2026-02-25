package com.Oreki.Music_Tracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
    
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/exercise")
    public String exercise(){
        return "exerciseUploader";
    }
    @RequestMapping("/lessons")
    public String lesson(){
        return "LessonAssigner";
    }
    @RequestMapping("/list")
    public String list(){
        return "exerciseList";
    }
}
