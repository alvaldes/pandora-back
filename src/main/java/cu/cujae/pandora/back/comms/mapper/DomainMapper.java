package cu.cujae.pandora.back.comms.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cu.cujae.pandora.back.academic.dto.CollaboratorDto;
import cu.cujae.pandora.back.academic.entity.Collaborator;
import cu.cujae.pandora.back.comms.dto.CareerDTO;
import cu.cujae.pandora.back.comms.dto.CourseDTO;
import cu.cujae.pandora.back.comms.dto.DepartmentDTO;
import cu.cujae.pandora.back.comms.dto.DisciplineDTO;
import cu.cujae.pandora.back.comms.dto.FacultyDTO;
import cu.cujae.pandora.back.comms.dto.PersonDTO;
import cu.cujae.pandora.back.comms.dto.RoleDTO;
import cu.cujae.pandora.back.comms.dto.SemesterDTO;
import cu.cujae.pandora.back.comms.dto.SubjectPlanDTO;
import cu.cujae.pandora.back.comms.dto.UserDTO;
import cu.cujae.pandora.back.comms.dto.YearDTO;
import cu.cujae.pandora.back.comms.entity.Career;
import cu.cujae.pandora.back.comms.entity.Course;
import cu.cujae.pandora.back.comms.entity.Department;
import cu.cujae.pandora.back.comms.entity.Discipline;
import cu.cujae.pandora.back.comms.entity.Faculty;
import cu.cujae.pandora.back.comms.entity.Person;
import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.entity.Semester;
import cu.cujae.pandora.back.comms.entity.SubjectPlan;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.entity.Year;

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
    List<Semester> toSemesterList(List<SemesterDTO> dto);
    List<SemesterDTO> toSemesterDtoList(List<Semester> semester);
    List<Faculty> toFacultyList(List<FacultyDTO> dto);
    List<FacultyDTO> toFacultyDtoList(List<Faculty> semester);
    List<Department> toDepartmentList(List<DepartmentDTO> dto);
    List<DepartmentDTO> toDepartmentDtoList(List<Department> department);
    List<Career> toCareerList(List<CareerDTO> dto);
    List<CareerDTO> toCareerDtoList(List<Career> career);
    List<Discipline> toDisciplineList(List<DisciplineDTO> dto);
    List<DisciplineDTO> toDisciplineDtoList(List<Discipline> discipline);
    List<Person> toPersonList(List<PersonDTO> dto);
    List<PersonDTO> toPersonDtoList(List<Person> person);
    List<SubjectPlan> toSubjectPlanList(List<SubjectPlan> dto);
    List<SubjectPlanDTO> toSubjectPlanDtoList(List<SubjectPlan> subjectPlan);



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
    Semester toSemesterDto(SemesterDTO dto);
    SemesterDTO toSemesterDto(Semester semester);
    Faculty toFaculty(FacultyDTO dto);
    FacultyDTO toFacultyDto(Faculty faculty);
    Department toDepartment(DepartmentDTO dto);
    DepartmentDTO toDepartmentDto(Department department);
    Career toCareer(CareerDTO dto);
    CareerDTO toCareerDto(Career career);
    Discipline toDiscipline(DisciplineDTO dto);
    DisciplineDTO toDisciplineDto(Discipline discipline);
    Person toPerson(PersonDTO dto);
    PersonDTO toPersonDto(Person person);
    SubjectPlan toSubjectPlanDto(SubjectPlanDTO dto);
    SubjectPlanDTO toSubjectPlanDto(SubjectPlan subjectPlan);
}
