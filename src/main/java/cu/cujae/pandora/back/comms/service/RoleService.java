package cu.cujae.pandora.back.comms.service;

import cu.cujae.pandora.back.comms.dto.RoleDTO;
import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;
import cu.cujae.pandora.back.comms.repository.RoleRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public RoleDTO save(RoleDTO roleDTO) {
        return mapper.toRoleDto(roleRepository.save(mapper.toRole(roleDTO)));
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    public List<RoleDTO> findAll() {
        return mapper.toRoleDtoList(roleRepository.findAll());
    }

    public RoleDTO findById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isEmpty()) {
            throw new InvalidClientRequestException("Role not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toRoleDto(optionalRole.get());
    }

    public RoleDTO findByRoleName(String name) {
        Optional<Role> optionalRole = roleRepository.findByRoleName(name);
        if (optionalRole.isEmpty()) {
            throw new InvalidClientRequestException("Role not found with name: " + name, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toRoleDto(optionalRole.get());
    }
}
