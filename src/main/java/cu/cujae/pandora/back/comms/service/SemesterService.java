package cu.cujae.pandora.back.comms.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.cujae.pandora.back.comms.dto.SemesterDTO;
import cu.cujae.pandora.back.comms.entity.Semester;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;

import cu.cujae.pandora.back.comms.repository.SemesterRepository;


@Service
public class SemesterService {

    @Autowired
    SemesterRepository semesterRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public SemesterDTO save(SemesterDTO semesterDTO) {
        return mapper.toSemesterDto(semesterRepository.save(mapper.toSemesterDto(semesterDTO)));
    }

    public void deleteSemester(Long id) {
        semesterRepository.deleteById(id);
    }

    public List<SemesterDTO> getAllSemesters() {
        return mapper.toSemesterDtoList(semesterRepository.findAll());
    }

    public SemesterDTO getSemesterById(Long id) {
        Optional<Semester> optionalSemester = semesterRepository.findById(id);
        if (optionalSemester.isEmpty()) {
            throw new InvalidClientRequestException("Semester not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toSemesterDto(optionalSemester.get());
    }

    public SemesterDTO findBySemesterName(String semesterName) {
        Optional<Semester> optionalSemester = semesterRepository.findBySemesterName(semesterName);
        if (optionalSemester.isEmpty()) {
            throw new InvalidClientRequestException("Semester not found with name: " + semesterName, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toSemesterDto(optionalSemester.get());
    }
    
    public Boolean existBySemesterName(String semesterName) {
        return semesterRepository.existBySemesterName(semesterName);
    }
}

