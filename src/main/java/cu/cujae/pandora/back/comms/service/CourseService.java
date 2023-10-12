package cu.cujae.pandora.back.comms.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.cujae.pandora.back.comms.dto.CourseDTO;
import cu.cujae.pandora.back.comms.entity.Course;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;
import cu.cujae.pandora.back.comms.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public CourseDTO save(CourseDTO courseDTO) {
        return mapper.toCourseDto(courseRepository.save(mapper.toCourse(courseDTO)));
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public List<CourseDTO> findAll() {
        return mapper.toCourseDtoList(courseRepository.findAll());
    }

    public CourseDTO findById(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isEmpty()) {
            throw new InvalidClientRequestException("Course not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toCourseDto(optionalCourse.get());
    }

    public CourseDTO findByCourseName(String name) {
        Optional<Course> optionalCourse = courseRepository.findByCourseName(name);
        if (optionalCourse.isEmpty()) {
            throw new InvalidClientRequestException("Course not found with name: " + name, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toCourseDto(optionalCourse.get());
    }
    
    public Boolean existsByCourseName(String course_name) {
        return courseRepository.existsByCourseName(course_name);
    }
}

