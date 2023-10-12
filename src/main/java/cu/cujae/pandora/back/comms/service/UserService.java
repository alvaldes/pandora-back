package cu.cujae.pandora.back.comms.service;

import cu.cujae.pandora.back.comms.dto.UserDTO;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;
import cu.cujae.pandora.back.comms.repository.UserRepository;
import cu.cujae.pandora.back.comms.utils.CommsConstants;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public UserDTO save(UserDTO userDTO) {
        return mapper.toUserDto(userRepository.save(mapper.toUser(userDTO)));
    }

    public void deleteLdapUser(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        user.orElseThrow(() -> new InvalidClientRequestException("User not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode()))
                .setStatus(CommsConstants.USER_STATUS_DELETED);
        userRepository.save(user.get());
    }

    public List<UserDTO> getAllLdapUsers() {
        return mapper.toUserDtoList(userRepository.findAll());
    }

    public UserDTO getLdapUserById(Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new InvalidClientRequestException("User not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toUserDto(optionalUser.get());
    }

    public UserDTO findByUsername(String username) {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new InvalidClientRequestException("User not found with username: " + username, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toUserDto(optionalUser.get());
    }

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
