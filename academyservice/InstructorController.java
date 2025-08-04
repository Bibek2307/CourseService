package com.infosys.academyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academy")
public class InstructorController {

    @Autowired
    private CourseServiceClient courseServiceClient;

    @Autowired
    private InstructorServiceClient instructorServiceClient;

    public InstructorController(InstructorServiceClient instructorServiceClient, CourseServiceClient courseServiceClient) {
        this.instructorServiceClient = instructorServiceClient;
        this.courseServiceClient = courseServiceClient;
    }

    @GetMapping("/instructor-details/{id}")
    public InstructorCourseResponse getInstructorDetails(@PathVariable("id") int id) {
        Instructor instructor = instructorServiceClient.getInstructorById(id);
        List<Course> courses=courseServiceClient.findCourseByInstructorId(id);
        return InstructorCourseResponse.builder()
                .id(instructor.getId())
                .name(instructor.getName())
                .courses(courses)
                .build();
    }
}
