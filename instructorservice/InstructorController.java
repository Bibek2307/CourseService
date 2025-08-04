package com.infosys.instructorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @GetMapping("{id}")
    public Optional<Instructor> getInstructorById(@PathVariable int id) {
        return instructorService.getInstructorById(id);
    }
}
