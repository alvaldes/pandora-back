package cu.cujae.pandora.back.comms.service;

import cu.cujae.pandora.back.comms.dto.DepartmentDTO;
import cu.cujae.pandora.back.comms.entity.Department;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;
import cu.cujae.pandora.back.comms.repository.DepartmentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
   DepartmentRepository departmentRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        return mapper.toDepartmentDto(departmentRepository.save(mapper.toDepartment(departmentDTO)));
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public List<DepartmentDTO> getAllDepartments() {
        return mapper.toDepartmentDtoList(departmentRepository.findAll());
    }

    public DepartmentDTO getDepartmentById(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isEmpty()) {
            throw new InvalidClientRequestException("Department not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toDepartmentDto(optionalDepartment.get());
    }

    public DepartmentDTO findByDepartmentName(String departmentName) {
        Optional<Department> optionalDepartment = departmentRepository.findByDepartmentName(departmentName);
        if (optionalDepartment.isEmpty()) {
            throw new InvalidClientRequestException("Department not found with name: " + departmentName, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toDepartmentDto(optionalDepartment.get());
    }

    public Boolean existsByDepartmentName(String departmentName) {
        return departmentRepository.existsByDepartmentName(departmentName);
    }
}
