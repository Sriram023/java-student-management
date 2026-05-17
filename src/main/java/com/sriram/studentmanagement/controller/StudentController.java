package com.sriram.studentmanagement.controller;

import com.sriram.studentmanagement.entity.Student;
import com.sriram.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", repository.findAll());
        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        repository.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}