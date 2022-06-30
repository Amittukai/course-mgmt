package com.course.management.controllers;

import com.course.management.controllers.base.BaseController;
import com.course.management.dtos.CourseDto;
import com.course.management.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    CourseService courseService;

    @GetMapping()
    public ResponseEntity getAllCourse(){
        return sendSuccessApiResponse(courseService.getAllCourse());
    }

    @GetMapping("{courseCode}/module")
    public ResponseEntity getAllModuleOfACourse(@PathVariable String courseCode){
        return sendSuccessApiResponse(courseService.getAllModuleByCourse(courseCode));
    }

    @PostMapping()
    public ResponseEntity addCourse(@RequestBody CourseDto courseDto){
        return sendSuccessApiResponse(courseService.addCourse(courseDto));
    }

    @DeleteMapping
    public ResponseEntity deleteCourse(@RequestParam String code) {
        return sendSuccessApiResponse(courseService.deleteCourse(code));
    }

}
