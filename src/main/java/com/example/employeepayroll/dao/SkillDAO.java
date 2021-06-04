package com.example.employeepayroll.dao;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SkillDAO extends JpaRepository<Skill,Integer> {

//find by skill name and display only 1st and last name
    List<Employee> findBySkill(String skill);

}
