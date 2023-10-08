package cu.cujae.pandora.back.comms.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cu.cujae.pandora.back.comms.dto.FacultyDTO;
import cu.cujae.pandora.back.comms.entity.Faculty;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;

import cu.cujae.pandora.back.comms.repository.FacultyRepository;


@Service
public class FacultyService {

    @Autowired
    FacultyRepository facultyRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public FacultyDTO save(FacultyDTO facultyDTO) {
        return mapper.toFacultyDto(facultyRepository.save(mapper.toFaculty(facultyDTO)));
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public List<FacultyDTO> getAllFaculties() {
        return mapper.toFacultyDtoList(facultyRepository.findAll());
    }

    public FacultyDTO getFacultyById(Long id) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isEmpty()) {
            throw new InvalidClientRequestException("Faculty not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toFacultyDto(optionalFaculty.get());
    }

    public FacultyDTO findByFacultyName(String facultyName) {
        Optional<Faculty> optionalFaculty = facultyRepository.findByFacultyName(facultyName);
        if (optionalFaculty.isEmpty()) {
            throw new InvalidClientRequestException("Faculty not found with name: " + facultyName, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toFacultyDto(optionalFaculty.get());
    }
    
    public Boolean existByFacultyName(String facultyName) {
        return facultyRepository.existByFacultyName(facultyName);
    }
}
