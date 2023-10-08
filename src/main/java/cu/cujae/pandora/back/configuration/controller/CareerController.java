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

import cu.cujae.pandora.back.comms.dto.CareerDTO;
import cu.cujae.pandora.back.comms.service.CareerService;


@RestController
@RequestMapping("/config/career")
public class CareerController {
	 @Autowired
	    private CareerService careerService;

	    @PostMapping()
	    public ResponseEntity<CareerDTO> insertCareer(@RequestBody CareerDTO careerDTO) {
	        return new ResponseEntity<>(careerService.save(careerDTO), HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> deleteCareer(@PathVariable("id") Long id) {
	        careerService.deleteCareer(id);
	        return ResponseEntity.ok(HttpStatus.OK);
	    }

	    @PutMapping()
	    public ResponseEntity<CareerDTO> updateCareer(@RequestBody CareerDTO careerDTO) {
	        return new ResponseEntity<>(careerService.save(careerDTO), HttpStatus.OK);
	    }

	    @GetMapping()
	    public ResponseEntity<List<CareerDTO>> getCareers() {
	        return new ResponseEntity<>(careerService.getAllCareers(), HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CareerDTO> getCareerById(@PathVariable("id") Long id) {
	            return new ResponseEntity<>(careerService.getCareerById(id), HttpStatus.OK);
	    }

	    @GetMapping("career_name/{careerName}")
	    public ResponseEntity<CareerDTO> findByCareerName(@PathVariable("careerName") String careerName) {
	        return new ResponseEntity<>(careerService.findByCareerName(careerName), HttpStatus.OK);
	    }
	    
	    @GetMapping("exist_career_name/{careerName}")
	    public ResponseEntity<CareerDTO> existByCareerName(@PathVariable("careerName") String careerName) {
	        return new ResponseEntity<>(careerService.findByCareerName(careerName), HttpStatus.OK);
	    }

}
