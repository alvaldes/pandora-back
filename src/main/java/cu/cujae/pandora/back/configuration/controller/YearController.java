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

import cu.cujae.pandora.back.comms.dto.YearDTO;
import cu.cujae.pandora.back.comms.service.YearService;

@RestController
@RequestMapping("/config/year")
public class YearController {
	 @Autowired
	    private YearService yearService;

	    @PostMapping()
	    public ResponseEntity<YearDTO> insertYear(@RequestBody YearDTO yearDTO) {
	        return new ResponseEntity<>(yearService.save(yearDTO), HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> deleteYear(@PathVariable("id") Long id) {
	        yearService.deleteYear(id);
	        return ResponseEntity.ok(HttpStatus.OK);
	    }

	    @PutMapping()
	    public ResponseEntity<YearDTO> updateYear(@RequestBody YearDTO yearDTO) {
	        return new ResponseEntity<>(yearService.save(yearDTO), HttpStatus.OK);
	    }

	    @GetMapping()
	    public ResponseEntity<List<YearDTO>> getYears() {
	        return new ResponseEntity<>(yearService.getAllYears(), HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<YearDTO> getYearById(@PathVariable("id") Long id) {
	            return new ResponseEntity<>(yearService.getYearById(id), HttpStatus.OK);
	    }

	    @GetMapping("year_name/{yearName}")
	    public ResponseEntity<YearDTO> findByYearName(@PathVariable("yearName") String yearName) {
	        return new ResponseEntity<>(yearService.findByYearName(yearName), HttpStatus.OK);
	    }
	    
	    @GetMapping("exist_year_name/{yearName}")
	    public ResponseEntity<YearDTO> existByYearName(@PathVariable("yearName") String yearName) {
	        return new ResponseEntity<>(yearService.findByYearName(yearName), HttpStatus.OK);
	    }

}
