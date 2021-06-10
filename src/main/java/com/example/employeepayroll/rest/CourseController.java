package com.example.employeepayroll.rest;

import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses",method = RequestMethod.GET)
    public List<CourseDTO> getCourses(){
        return courseService.getEmployeeCourses();
    }

    @RequestMapping(value = "/saveCourse/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> saveCourse(@PathVariable int id,@RequestBody CourseDTO courseDTO){

        return courseService.saveCourse(id,courseDTO);
    }



}
