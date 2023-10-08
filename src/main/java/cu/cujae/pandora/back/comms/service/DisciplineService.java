package cu.cujae.pandora.back.comms.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cu.cujae.pandora.back.comms.dto.DisciplineDTO;
import cu.cujae.pandora.back.comms.entity.Discipline;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;
import cu.cujae.pandora.back.comms.repository.DisciplineRepository;


@Service
public class DisciplineService {

    @Autowired
    DisciplineRepository disciplineRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public DisciplineDTO save(DisciplineDTO disciplineDTO) {
        return mapper.toDisciplineDto(disciplineRepository.save(mapper.toDiscipline(disciplineDTO)));
    }

    public void deleteDiscipline(Long id) {
        disciplineRepository.deleteById(id);
    }

    public List<DisciplineDTO> getAllDisciplines() {
        return mapper.toDisciplineDtoList(disciplineRepository.findAll());
    }

    public DisciplineDTO getDisciplineById(Long id) {
        Optional<Discipline> optionalDiscipline = disciplineRepository.findById(id);
        if (optionalDiscipline.isEmpty()) {
            throw new InvalidClientRequestException("Discipline not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toDisciplineDto(optionalDiscipline.get());
    }

    public DisciplineDTO findByDisciplineName(String disciplineName) {
        Optional<Discipline> optionalDiscipline = disciplineRepository.findByDisciplineName(disciplineName);
        if (optionalDiscipline.isEmpty()) {
            throw new InvalidClientRequestException("Discipline not found with name: " + disciplineName, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toDisciplineDto(optionalDiscipline.get());
    }

    public Boolean existByDisciplineName(String disciplineName) {
        return disciplineRepository.existByDisciplineName(disciplineName);
    }
}