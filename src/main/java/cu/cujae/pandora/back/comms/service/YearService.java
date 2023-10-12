package cu.cujae.pandora.back.comms.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.cujae.pandora.back.comms.dto.YearDTO;
import cu.cujae.pandora.back.comms.entity.Year;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;
import cu.cujae.pandora.back.comms.repository.YearRepository;

@Service
public class YearService {
    @Autowired
    YearRepository yearRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public YearDTO save(YearDTO yearDTO) {
        return mapper.toYearDto(yearRepository.save(mapper.toYear(yearDTO)));
    }

    public void deleteYear(Long id) {
        yearRepository.deleteById(id);
    }

    public List<YearDTO> getAllYears() {
        return mapper.toYearDtoList(yearRepository.findAll());
    }

    public YearDTO getYearById(Long id) {
        Optional<Year> optionalYear = yearRepository.findById(id);
        if (optionalYear.isEmpty()) {
            throw new InvalidClientRequestException("Year not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toYearDto(optionalYear.get());
    }

    public YearDTO findByYearName(String yearName) {
        Optional<Year> optionalYear = yearRepository.findByYearName(yearName);
        if (optionalYear.isEmpty()) {
            throw new InvalidClientRequestException("User not found with username: " + yearName, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toYearDto(optionalYear.get());
    }

    public Boolean existByYearName(String yearName) {
        return yearRepository.existByYearName(yearName);
    }
}
