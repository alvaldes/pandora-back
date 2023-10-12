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

import cu.cujae.pandora.back.comms.dto.DisciplineDTO;

import cu.cujae.pandora.back.comms.service.DisciplineService;


@RestController
@RequestMapping("/config/discipline")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @PostMapping()
    public ResponseEntity<DisciplineDTO> insertDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        return new ResponseEntity<>(disciplineService.save(disciplineDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDiscipline(@PathVariable("id") Long id) {
        disciplineService.deleteDiscipline(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<DisciplineDTO> updateDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        return new ResponseEntity<>(disciplineService.save(disciplineDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<DisciplineDTO>> getDisciplines() {
        return new ResponseEntity<>(disciplineService.getAllDisciplines(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDTO> getDisciplineById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(disciplineService.getDisciplineById(id), HttpStatus.OK);
    }

    @GetMapping("discipline_name/{disciplineName}")
    public ResponseEntity<DisciplineDTO> findByDiscipline(@PathVariable("disciplineName") String disciplineName) {
        return new ResponseEntity<>(disciplineService.findByDisciplineName(disciplineName), HttpStatus.OK);
    }
    
    @GetMapping("exist_discipline_name/{disciplineName}")
    public ResponseEntity<DisciplineDTO> existsByDisciplineName(@PathVariable("disciplineName") String disciplineName) {
        return new ResponseEntity<>(disciplineService.findByDisciplineName(disciplineName), HttpStatus.OK);
    }
}