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

import cu.cujae.pandora.back.comms.dto.DepartmentDTO;
import cu.cujae.pandora.back.comms.service.DepartmentService;

@RestController
@RequestMapping("/config/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity<DepartmentDTO> insertDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.save(departmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.save(departmentDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentDTO>> getSemester() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @GetMapping("department_name/{departmentName}")
    public ResponseEntity<DepartmentDTO> findByDepartment(@PathVariable("departmentName") String departmentName) {
        return new ResponseEntity<>(departmentService.findByDepartmentName(departmentName), HttpStatus.OK);
    }
    
    @GetMapping("exist_department_name/{departmentName}")
    public ResponseEntity<DepartmentDTO> existsByDepartmentName(@PathVariable("departmentName") String departmentName) {
        return new ResponseEntity<>(departmentService.findByDepartmentName(departmentName), HttpStatus.OK);
    }

}