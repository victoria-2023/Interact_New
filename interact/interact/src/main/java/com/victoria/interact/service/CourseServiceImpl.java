package com.victoria.interact.service;

import com.victoria.interact.model.Course;
import com.victoria.interact.model.CourseDTO;
import com.victoria.interact.model.Response;
import com.victoria.interact.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Response createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        setCourseFields(course, courseDTO);
        course = courseRepository.save(course);
        return new Response("200", "Course Created Successfully", convertToDTO(course));

    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Not Found"));
        return convertToDTO(course);
    }

    @Override
    public Response updateCourse(long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Not Found"));
        setCourseFields(course, courseDTO);

        courseRepository.save(course);
        return new Response("200", "Course Updated Successfully", courseDTO);
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }
    private CourseDTO convertToDTO(Course course) {
        return new CourseDTO(course.getCode(), course.getDescription(), course.getSubject());
    }
    private void setCourseFields(Course course, CourseDTO courseDTO) {
        course.setSubject(courseDTO.getSubject());
        course.setLecturer(courseDTO.getLecturer());
        course.setDescription(courseDTO.getDescription());
    }
}
