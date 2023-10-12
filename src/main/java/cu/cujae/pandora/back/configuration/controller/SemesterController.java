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

import cu.cujae.pandora.back.comms.dto.SemesterDTO;
import cu.cujae.pandora.back.comms.service.SemesterService;

@RestController
@RequestMapping("/config/semester")
public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @PostMapping()
    public ResponseEntity<SemesterDTO> insertSemester(@RequestBody SemesterDTO semesterDTO) {
        return new ResponseEntity<>(semesterService.save(semesterDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSemester(@PathVariable("id") Long id) {
        semesterService.deleteSemester(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<SemesterDTO> updateSemester(@RequestBody SemesterDTO semesterDTO) {
        return new ResponseEntity<>(semesterService.save(semesterDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<SemesterDTO>> getSemesters() {
        return new ResponseEntity<>(semesterService.getAllSemesters(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemesterDTO> getSemesterById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(semesterService.getSemesterById(id), HttpStatus.OK);
    }

    @GetMapping("semester_name/{semesterName}")
    public ResponseEntity<SemesterDTO> findBySemester(@PathVariable("semesterName") String semesterName) {
        return new ResponseEntity<>(semesterService.findBySemesterName(semesterName), HttpStatus.OK);
    }
    
    @GetMapping("exist_semester_name/{semesterName}")
    public ResponseEntity<SemesterDTO> existsBySemesterName(@PathVariable("semesterName") String semesterName) {
        return new ResponseEntity<>(semesterService.findBySemesterName(semesterName), HttpStatus.OK);
    }

}