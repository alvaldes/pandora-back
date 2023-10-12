package cu.cujae.pandora.back.comms.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.cujae.pandora.back.comms.dto.CareerDTO;
import cu.cujae.pandora.back.comms.entity.Career;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;
import cu.cujae.pandora.back.comms.repository.CareerRepository;


@Service
public class CareerService {

    @Autowired
    CareerRepository careerRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public CareerDTO save(CareerDTO careerDTO) {
        return mapper.toCareerDto(careerRepository.save(mapper.toCareer(careerDTO)));
    }

    public void deleteCareer(Long id) {
        careerRepository.deleteById(id);
    }

    public List<CareerDTO> getAllCareers() {
        return mapper.toCareerDtoList(careerRepository.findAll());
    }

    public CareerDTO getCareerById(Long id) {
        Optional<Career> optionalCareer = careerRepository.findById(id);
        if (optionalCareer.isEmpty()) {
            throw new InvalidClientRequestException("Career not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toCareerDto(optionalCareer.get());
    }

    public CareerDTO findByCareerName(String careerName) {
        Optional<Career> optionalCareer = careerRepository.findByCareerName(careerName);
        if (optionalCareer.isEmpty()) {
            throw new InvalidClientRequestException("Career not found with name: " + careerName, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toCareerDto(optionalCareer.get());
    }
    
    public Boolean existByCareerName(String careerName) {
        return careerRepository.existByCareerName(careerName);
    }
}