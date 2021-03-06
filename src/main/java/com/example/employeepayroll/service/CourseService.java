package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface CourseService {

    public List<CourseDTO> getEmployeeCourses();

    ResponseEntity<?> saveCourses(int id, List<CourseDTO> courseList);

    ResponseEntity<?> updateCourse(String existingCourse, String replacementCourse);
}
