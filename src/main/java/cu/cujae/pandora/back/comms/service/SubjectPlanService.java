package cu.cujae.pandora.back.comms.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cu.cujae.pandora.back.comms.dto.SubjectPlanDTO;
import cu.cujae.pandora.back.comms.entity.SubjectPlan;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;

import cu.cujae.pandora.back.comms.repository.SubjectPlanRepository;


@Service
public class SubjectPlanService {

    @Autowired
    SubjectPlanRepository subjectPlanRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public SubjectPlanDTO save(SubjectPlanDTO subjectPlanDTO) {
        return mapper.toSubjectPlanDto(subjectPlanRepository.save(mapper.toSubjectPlanDto(subjectPlanDTO)));
    }

    public void deletSubjectPlan(Long id) {
    	subjectPlanRepository.deleteById(id);
    }

    public List<SubjectPlanDTO> getAllSubjectsPlans() {
        return mapper.toSubjectPlanDtoList(subjectPlanRepository.findAll());
    }

    public SubjectPlanDTO getSubjectPlanRById(Long id) {
        Optional<SubjectPlan> optionalSubjectPlan = subjectPlanRepository.findById(id);
        if (optionalSubjectPlan.isEmpty()) {
            throw new InvalidClientRequestException("Subject Plan not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toSubjectPlanDto(optionalSubjectPlan.get());
    }

    public SubjectPlanDTO findBySubjectPlanName(String subjectPlanName) {
        Optional<SubjectPlan> optionalSubjectPlan = subjectPlanRepository.findBySubjectPlanName(subjectPlanName);
        if (optionalSubjectPlan.isEmpty()) {
            throw new InvalidClientRequestException("Subject Plan not found with name: " + subjectPlanName, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toSubjectPlanDto(optionalSubjectPlan.get());
    }
    
    public Boolean existsBySubjectPlanName(String subjectPlanName) {
        return subjectPlanRepository.existsBySubjectPlanName(subjectPlanName);
    }
}

