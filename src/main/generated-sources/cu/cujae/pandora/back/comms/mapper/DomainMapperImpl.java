package cu.cujae.pandora.back.comms.mapper;

import cu.cujae.pandora.back.comms.dto.RoleDTO;
import cu.cujae.pandora.back.comms.dto.UserDTO;
import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-01T00:36:14-0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Azul Systems, Inc.)"
)
@Component
public class DomainMapperImpl implements DomainMapper {

    @Override
    public List<Role> toRoleList(List<RoleDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( dto.size() );
        for ( RoleDTO roleDTO : dto ) {
            list.add( toRole( roleDTO ) );
        }

        return list;
    }

    @Override
    public List<RoleDTO> toRoleDtoList(List<Role> role) {
        if ( role == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( role.size() );
        for ( Role role1 : role ) {
            list.add( toRoleDto( role1 ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> toUserList(List<UserDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( dto.size() );
        for ( UserDTO userDTO : dto ) {
            list.add( toUser( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toUserDtoList(List<UserEntity> user) {
        if ( user == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( user.size() );
        for ( UserEntity userEntity : user ) {
            list.add( toUserDto( userEntity ) );
        }

        return list;
    }

    @Override
    public Role toRole(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( dto.getId() );
        role.setRoleName( dto.getRoleName() );

        return role;
    }

    @Override
    public RoleDTO toRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setRoleName( role.getRoleName() );

        return roleDTO;
    }

    @Override
    public UserEntity toUser(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( dto.getId() );
        userEntity.username( dto.getUsername() );
        userEntity.password( dto.getPassword() );
        userEntity.role( toRole( dto.getRole() ) );
        userEntity.email( dto.getEmail() );
        userEntity.ci( dto.getCi() );
        userEntity.name( dto.getName() );
        userEntity.lastname( dto.getLastname() );
        userEntity.position( dto.getPosition() );
        userEntity.status( dto.getStatus() );

        return userEntity.build();
    }

    @Override
    public UserDTO toUserDto(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setRole( toRoleDto( user.getRole() ) );
        userDTO.setEmail( user.getEmail() );
        userDTO.setCi( user.getCi() );
        userDTO.setName( user.getName() );
        userDTO.setLastname( user.getLastname() );
        userDTO.setPosition( user.getPosition() );
        userDTO.setStatus( user.getStatus() );

        return userDTO;
    }
}
