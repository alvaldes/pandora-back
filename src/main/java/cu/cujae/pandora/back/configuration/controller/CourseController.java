package cu.cujae.pandora.back.configuration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.cujae.pandora.back.comms.dto.CourseDTO;

import cu.cujae.pandora.back.comms.service.CourseService;

@RestController
@RequestMapping("/config/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping()
    public ResponseEntity<CourseDTO> insertCourse(@RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.save(courseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") Long id) {
        courseService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.save(courseDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CourseDTO>> getCourses() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @GetMapping("course_name/{courseName}")
    public ResponseEntity<CourseDTO> findByCourseName(@PathVariable("courseName") String courseName) {
        return new ResponseEntity<>(courseService.findByCourseName(courseName), HttpStatus.OK);
    }
    
    @GetMapping("exist_course_name/{courseName}")
    public ResponseEntity<CourseDTO> existByCourseName(@PathVariable("courseName") String courseName) {
        return new ResponseEntity<>(courseService.findByCourseName(courseName), HttpStatus.OK);
    }

}