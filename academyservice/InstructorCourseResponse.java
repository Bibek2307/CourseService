package com.infosys.academyservice;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstructorCourseResponse {
    private int id;
    private String name;
    List<Course> courses;
}
