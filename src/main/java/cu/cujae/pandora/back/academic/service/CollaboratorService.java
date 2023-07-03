package cu.cujae.pandora.back.academic.service;

import cu.cujae.pandora.back.academic.dto.CollaboratorDto;
import cu.cujae.pandora.back.academic.repository.CollaboratorRepository;
import cu.cujae.pandora.back.academic.entity.Collaborator;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollaboratorService {
    @Autowired
    CollaboratorRepository collaboratorRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public CollaboratorDto save(CollaboratorDto CollaboratorDto) {
        return mapper.toCollaboratorDto(collaboratorRepository.save(mapper.toCollaborator(CollaboratorDto)));
    }

    public void deleteCollaborator(Integer id) {
        collaboratorRepository.deleteById(id);
    }

    public List<CollaboratorDto> getAllColaCollaborator() {
        return mapper.toCollaboratorDtoList(collaboratorRepository.findAll());
    }

    public CollaboratorDto getCollaboratorById(Integer id) {
        Optional<Collaborator> optionalUser = collaboratorRepository.findByIdCollaborator(id);
        if (optionalUser.isEmpty()) {
            throw new InvalidClientRequestException("Collaborator not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toCollaboratorDto(optionalUser.get());
    }

    public List<CollaboratorDto> getCollaboratorByDepartment(Integer departmentId) {
        List<Collaborator> optionalCollaborator = collaboratorRepository.findAllByIdDepartment(departmentId);
        if (optionalCollaborator.isEmpty()) {
            throw new InvalidClientRequestException("Collaborator not found with department id: " + departmentId, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toCollaboratorDtoList(optionalCollaborator);
    }
}
