package cu.cujae.pandora.back.comms.mapper;

import cu.cujae.pandora.back.academic.dto.CollaboratorDto;
import cu.cujae.pandora.back.comms.dto.CourseDTO;
import cu.cujae.pandora.back.comms.dto.RoleDTO;
import cu.cujae.pandora.back.comms.dto.UserDTO;
import cu.cujae.pandora.back.comms.dto.YearDTO;
import cu.cujae.pandora.back.academic.entity.Collaborator;
import cu.cujae.pandora.back.comms.entity.Course;
import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.entity.Year;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomainMapper {
    DomainMapper INSTANCE = Mappers.getMapper(DomainMapper.class);

    //list
    List<Role> toRoleList(List<RoleDTO> dto);
    List<RoleDTO> toRoleDtoList(List<Role> role);
    List<UserEntity> toUserList(List<UserDTO> dto);
    List<UserDTO> toUserDtoList(List<UserEntity> user);
    List<Collaborator> toCollaboratorList(List<CollaboratorDto> dto);
    List<CollaboratorDto> toCollaboratorDtoList(List<Collaborator> collaborator);
    List<Year> toYearList(List<YearDTO> dto);
    List<YearDTO> toYearDtoList(List<Year> year);
    List<Course> toCourseList(List<CourseDTO> dto);
    List<CourseDTO> toCourseDtoList(List<Course> course);


    //entity
    Role toRole(RoleDTO dto);
    RoleDTO toRoleDto(Role role);
    UserEntity toUser(UserDTO dto);
    UserDTO toUserDto(UserEntity user);
    Collaborator toCollaborator(CollaboratorDto dto);
    CollaboratorDto toCollaboratorDto(Collaborator collaborator);
    Year toYear(YearDTO dto);
    YearDTO toYearDto(Year year);
    Course toCourse(CourseDTO dto);
    CourseDTO toCourseDto(Course course);
}
