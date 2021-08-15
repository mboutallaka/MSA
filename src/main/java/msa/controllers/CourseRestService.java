package msa.controllers;

import msa.dao.CourseRepository;
import msa.entities.Course;
import msa.exceptions.CourseIntrouvableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CourseRestService {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value ="/listCourse")
    public List<Course> listCourse(){
        return courseRepository.findAll();
    }

    @GetMapping(value ="/listCourse/{id}")
    public Course listCourse(@PathVariable(name ="id") Long id) throws CourseIntrouvableException {

        Course course= courseRepository.findById(id).get();
        if (course == null) throw new CourseIntrouvableException("the course with  " + id + "doesn't exist");
        return course ;
    }
    @PutMapping(value ="/listCourse/{id}")
    public Course update(@PathVariable(name ="id") Long id ,@RequestBody Course course){
        course.setId(id);
        return courseRepository.save(course);
    }
    @PostMapping(value ="/listCourse")
    public Course save(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @DeleteMapping (value ="/listCourse/{id}")
    public void delete(@PathVariable(name ="id") Long id ){
        courseRepository.deleteById(id);
    }
}
