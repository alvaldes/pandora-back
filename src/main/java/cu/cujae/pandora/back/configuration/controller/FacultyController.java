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

import cu.cujae.pandora.back.comms.dto.FacultyDTO;

import cu.cujae.pandora.back.comms.service.FacultyService;


@RestController
@RequestMapping("/config/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping()
    public ResponseEntity<FacultyDTO> insertCareer(@RequestBody FacultyDTO facultyDTO) {
        return new ResponseEntity<>(facultyService.save(facultyDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFaculty(@PathVariable("id") Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<FacultyDTO> updateFaculty(@RequestBody FacultyDTO facultyDTO) {
        return new ResponseEntity<>(facultyService.save(facultyDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<FacultyDTO>> getFaculties() {
        return new ResponseEntity<>(facultyService.getAllFaculties(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDTO> getFacultyById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(facultyService.getFacultyById(id), HttpStatus.OK);
    }

    @GetMapping("faculty_name/{facultyName}")
    public ResponseEntity<FacultyDTO> findByFacultyName(@PathVariable("facultyName") String facultyName) {
        return new ResponseEntity<>(facultyService.findByFacultyName(facultyName), HttpStatus.OK);
    }
    
    @GetMapping("exist_faculty_name/{facultyName}")
    public ResponseEntity<FacultyDTO> existsByFacultyName(@PathVariable("facultyName") String facultyName) {
        return new ResponseEntity<>(facultyService.findByFacultyName(facultyName), HttpStatus.OK);
    }

}