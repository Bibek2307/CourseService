package com.infosys.academyservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "InstructorService")
public interface InstructorServiceClient {
    @GetMapping("/instructors/{id}")
    Instructor getInstructorById(@PathVariable("id") int id);
}
