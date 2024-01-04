package com.victoria.interact.service;

import com.victoria.interact.model.CourseDTO;
import com.victoria.interact.model.Response;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {
    Response createCourse(CourseDTO courseDTO);
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(long id);
    Response updateCourse(long id, CourseDTO courseDTO);
    void deleteCourse(long id);

}
