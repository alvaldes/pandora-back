package cu.cujae.pandora.back.academic.controller;

import cu.cujae.pandora.back.academic.dto.CollaboratorDto;
import cu.cujae.pandora.back.academic.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic/collaborator")
public class CollaboratorController {
        @Autowired
        private CollaboratorService collaboratorService;

        @PostMapping()
        public ResponseEntity<CollaboratorDto> insertCollaborator(@RequestBody CollaboratorDto collaboratorDto) {
            return new ResponseEntity<>(collaboratorService.save(collaboratorDto), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteCollaborator(@PathVariable("id") Integer id) {
            collaboratorService.deleteCollaborator(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }

        @PutMapping()
        public ResponseEntity<CollaboratorDto> updateCollaboratorDto(@RequestBody CollaboratorDto collaboratorDto) {
            return new ResponseEntity<>(collaboratorService.save(collaboratorDto), HttpStatus.OK);
        }

        @GetMapping()
        public ResponseEntity<List<CollaboratorDto>> getCollaborators() {
            return new ResponseEntity<>(collaboratorService.getAllColaCollaborator(), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<CollaboratorDto> getCollaboratorById(@PathVariable("id") Integer id) {
            return new ResponseEntity<>(collaboratorService.getCollaboratorById(id), HttpStatus.OK);
        }

        @GetMapping("department_id/{id}")
        public ResponseEntity<List<CollaboratorDto>> getCollaboratorByDepartmentId(@PathVariable("id") int id) {
            return new ResponseEntity<>(collaboratorService.getCollaboratorByDepartment(id), HttpStatus.OK);
        }
    }
