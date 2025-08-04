package com.infosys.academyservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CourseService")
public interface CourseServiceClient {

    @GetMapping("/courses/{id}")
    List<Course> findCourseByInstructorId(@PathVariable("id") int id);

}
