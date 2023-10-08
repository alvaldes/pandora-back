package cu.cujae.pandora.back.comms.mapper;

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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-26T17:10:52+0200",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.1 (Oracle Corporation)"
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
    public List<Collaborator> toCollaboratorList(List<CollaboratorDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Collaborator> list = new ArrayList<Collaborator>( dto.size() );
        for ( CollaboratorDto collaboratorDto : dto ) {
            list.add( toCollaborator( collaboratorDto ) );
        }

        return list;
    }

    @Override
    public List<CollaboratorDto> toCollaboratorDtoList(List<Collaborator> collaborator) {
        if ( collaborator == null ) {
            return null;
        }

        List<CollaboratorDto> list = new ArrayList<CollaboratorDto>( collaborator.size() );
        for ( Collaborator collaborator1 : collaborator ) {
            list.add( toCollaboratorDto( collaborator1 ) );
        }

        return list;
    }

    @Override
    public List<Year> toYearList(List<YearDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Year> list = new ArrayList<Year>( dto.size() );
        for ( YearDTO yearDTO : dto ) {
            list.add( toYear( yearDTO ) );
        }

        return list;
    }

    @Override
    public List<YearDTO> toYearDtoList(List<Year> year) {
        if ( year == null ) {
            return null;
        }

        List<YearDTO> list = new ArrayList<YearDTO>( year.size() );
        for ( Year year1 : year ) {
            list.add( toYearDto( year1 ) );
        }

        return list;
    }

    @Override
    public List<Course> toCourseList(List<CourseDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Course> list = new ArrayList<Course>( dto.size() );
        for ( CourseDTO courseDTO : dto ) {
            list.add( toCourse( courseDTO ) );
        }

        return list;
    }

    @Override
    public List<CourseDTO> toCourseDtoList(List<Course> course) {
        if ( course == null ) {
            return null;
        }

        List<CourseDTO> list = new ArrayList<CourseDTO>( course.size() );
        for ( Course course1 : course ) {
            list.add( toCourseDto( course1 ) );
        }

        return list;
    }

    @Override
    public List<Semester> toSemesterList(List<SemesterDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Semester> list = new ArrayList<Semester>( dto.size() );
        for ( SemesterDTO semesterDTO : dto ) {
            list.add( toSemesterDto( semesterDTO ) );
        }

        return list;
    }

    @Override
    public List<SemesterDTO> toSemesterDtoList(List<Semester> semester) {
        if ( semester == null ) {
            return null;
        }

        List<SemesterDTO> list = new ArrayList<SemesterDTO>( semester.size() );
        for ( Semester semester1 : semester ) {
            list.add( toSemesterDto( semester1 ) );
        }

        return list;
    }

    @Override
    public List<Faculty> toFacultyList(List<FacultyDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Faculty> list = new ArrayList<Faculty>( dto.size() );
        for ( FacultyDTO facultyDTO : dto ) {
            list.add( toFaculty( facultyDTO ) );
        }

        return list;
    }

    @Override
    public List<FacultyDTO> toFacultyDtoList(List<Faculty> semester) {
        if ( semester == null ) {
            return null;
        }

        List<FacultyDTO> list = new ArrayList<FacultyDTO>( semester.size() );
        for ( Faculty faculty : semester ) {
            list.add( toFacultyDto( faculty ) );
        }

        return list;
    }

    @Override
    public List<Department> toDepartmentList(List<DepartmentDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Department> list = new ArrayList<Department>( dto.size() );
        for ( DepartmentDTO departmentDTO : dto ) {
            list.add( toDepartment( departmentDTO ) );
        }

        return list;
    }

    @Override
    public List<DepartmentDTO> toDepartmentDtoList(List<Department> department) {
        if ( department == null ) {
            return null;
        }

        List<DepartmentDTO> list = new ArrayList<DepartmentDTO>( department.size() );
        for ( Department department1 : department ) {
            list.add( toDepartmentDto( department1 ) );
        }

        return list;
    }

    @Override
    public List<Career> toCareerList(List<CareerDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Career> list = new ArrayList<Career>( dto.size() );
        for ( CareerDTO careerDTO : dto ) {
            list.add( toCareer( careerDTO ) );
        }

        return list;
    }

    @Override
    public List<CareerDTO> toCareerDtoList(List<Career> career) {
        if ( career == null ) {
            return null;
        }

        List<CareerDTO> list = new ArrayList<CareerDTO>( career.size() );
        for ( Career career1 : career ) {
            list.add( toCareerDto( career1 ) );
        }

        return list;
    }

    @Override
    public List<Discipline> toDisciplineList(List<DisciplineDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Discipline> list = new ArrayList<Discipline>( dto.size() );
        for ( DisciplineDTO disciplineDTO : dto ) {
            list.add( toDiscipline( disciplineDTO ) );
        }

        return list;
    }

    @Override
    public List<DisciplineDTO> toDisciplineDtoList(List<Discipline> discipline) {
        if ( discipline == null ) {
            return null;
        }

        List<DisciplineDTO> list = new ArrayList<DisciplineDTO>( discipline.size() );
        for ( Discipline discipline1 : discipline ) {
            list.add( toDisciplineDto( discipline1 ) );
        }

        return list;
    }

    @Override
    public List<Person> toPersonList(List<PersonDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( dto.size() );
        for ( PersonDTO personDTO : dto ) {
            list.add( toPerson( personDTO ) );
        }

        return list;
    }

    @Override
    public List<PersonDTO> toPersonDtoList(List<Person> person) {
        if ( person == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( person.size() );
        for ( Person person1 : person ) {
            list.add( toPersonDto( person1 ) );
        }

        return list;
    }

    @Override
    public List<SubjectPlan> toSubjectPlanList(List<SubjectPlan> dto) {
        if ( dto == null ) {
            return null;
        }

        List<SubjectPlan> list = new ArrayList<SubjectPlan>( dto.size() );
        for ( SubjectPlan subjectPlan : dto ) {
            list.add( subjectPlan );
        }

        return list;
    }

    @Override
    public List<SubjectPlanDTO> toSubjectPlanDtoList(List<SubjectPlan> subjectPlan) {
        if ( subjectPlan == null ) {
            return null;
        }

        List<SubjectPlanDTO> list = new ArrayList<SubjectPlanDTO>( subjectPlan.size() );
        for ( SubjectPlan subjectPlan1 : subjectPlan ) {
            list.add( toSubjectPlanDto( subjectPlan1 ) );
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

        userEntity.ci( dto.getCi() );
        userEntity.email( dto.getEmail() );
        userEntity.id( dto.getId() );
        userEntity.lastname( dto.getLastname() );
        userEntity.name( dto.getName() );
        userEntity.password( dto.getPassword() );
        userEntity.position( dto.getPosition() );
        userEntity.role( toRole( dto.getRole() ) );
        userEntity.status( dto.getStatus() );
        userEntity.username( dto.getUsername() );

        return userEntity.build();
    }

    @Override
    public UserDTO toUserDto(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setCi( user.getCi() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setId( user.getId() );
        userDTO.setLastname( user.getLastname() );
        userDTO.setName( user.getName() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setPosition( user.getPosition() );
        userDTO.setRole( toRoleDto( user.getRole() ) );
        userDTO.setStatus( user.getStatus() );
        userDTO.setUsername( user.getUsername() );

        return userDTO;
    }

    @Override
    public Collaborator toCollaborator(CollaboratorDto dto) {
        if ( dto == null ) {
            return null;
        }

        Collaborator collaborator = new Collaborator();

        collaborator.setCreatedBy( dto.getCreatedBy() );
        collaborator.setCreatedOn( dto.getCreatedOn() );
        collaborator.setIdCollaborator( dto.getIdCollaborator() );
        collaborator.setIdDepartment( dto.getIdDepartment() );
        collaborator.setIdPerson( dto.getIdPerson() );
        collaborator.setModifiedBy( dto.getModifiedBy() );
        collaborator.setModifiedOn( dto.getModifiedOn() );

        return collaborator;
    }

    @Override
    public CollaboratorDto toCollaboratorDto(Collaborator collaborator) {
        if ( collaborator == null ) {
            return null;
        }

        CollaboratorDto collaboratorDto = new CollaboratorDto();

        collaboratorDto.setCreatedBy( collaborator.getCreatedBy() );
        collaboratorDto.setCreatedOn( collaborator.getCreatedOn() );
        collaboratorDto.setIdCollaborator( collaborator.getIdCollaborator() );
        collaboratorDto.setIdDepartment( collaborator.getIdDepartment() );
        collaboratorDto.setIdPerson( collaborator.getIdPerson() );
        collaboratorDto.setModifiedBy( collaborator.getModifiedBy() );
        collaboratorDto.setModifiedOn( collaborator.getModifiedOn() );

        return collaboratorDto;
    }

    @Override
    public Year toYear(YearDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Year year = new Year();

        year.setId( dto.getId() );
        year.setSubjectsPlans( toSubjectPlanList( dto.getSubjectsPlans() ) );
        year.setYearName( dto.getYearName() );

        return year;
    }

    @Override
    public YearDTO toYearDto(Year year) {
        if ( year == null ) {
            return null;
        }

        YearDTO yearDTO = new YearDTO();

        yearDTO.setId( year.getId() );
        yearDTO.setSubjectsPlans( toSubjectPlanList( year.getSubjectsPlans() ) );
        yearDTO.setYearName( year.getYearName() );

        return yearDTO;
    }

    @Override
    public Course toCourse(CourseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Course course = new Course();

        course.setActive( dto.isActive() );
        course.setBeginDate( dto.getBeginDate() );
        course.setCourseName( dto.getCourseName() );
        course.setEndDate( dto.getEndDate() );
        course.setId( dto.getId() );
        course.setSubjectsPlans( subjectPlanDTOListToSubjectPlanList( dto.getSubjectsPlans() ) );

        return course;
    }

    @Override
    public CourseDTO toCourseDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setActive( course.isActive() );
        courseDTO.setBeginDate( course.getBeginDate() );
        courseDTO.setCourseName( course.getCourseName() );
        courseDTO.setEndDate( course.getEndDate() );
        courseDTO.setId( course.getId() );
        courseDTO.setSubjectsPlans( toSubjectPlanDtoList( course.getSubjectsPlans() ) );

        return courseDTO;
    }

    @Override
    public Semester toSemesterDto(SemesterDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Semester semester = new Semester();

        semester.setId( dto.getId() );
        semester.setSemesterName( dto.getSemesterName() );
        semester.setSubjectsPlans( subjectPlanDTOListToSubjectPlanList( dto.getSubjectsPlans() ) );

        return semester;
    }

    @Override
    public SemesterDTO toSemesterDto(Semester semester) {
        if ( semester == null ) {
            return null;
        }

        SemesterDTO semesterDTO = new SemesterDTO();

        semesterDTO.setId( semester.getId() );
        semesterDTO.setSemesterName( semester.getSemesterName() );
        semesterDTO.setSubjectsPlans( toSubjectPlanDtoList( semester.getSubjectsPlans() ) );

        return semesterDTO;
    }

    @Override
    public Faculty toFaculty(FacultyDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Faculty faculty = new Faculty();

        faculty.setCareers( toCareerList( dto.getCareers() ) );
        faculty.setDepartments( toDepartmentList( dto.getDepartments() ) );
        faculty.setFacultyName( dto.getFacultyName() );
        faculty.setId( dto.getId() );

        return faculty;
    }

    @Override
    public FacultyDTO toFacultyDto(Faculty faculty) {
        if ( faculty == null ) {
            return null;
        }

        FacultyDTO facultyDTO = new FacultyDTO();

        facultyDTO.setCareers( toCareerDtoList( faculty.getCareers() ) );
        facultyDTO.setDepartments( toDepartmentDtoList( faculty.getDepartments() ) );
        facultyDTO.setFacultyName( faculty.getFacultyName() );
        facultyDTO.setId( faculty.getId() );

        return facultyDTO;
    }

    @Override
    public Department toDepartment(DepartmentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Department department = new Department();

        department.setDepartmentName( dto.getDepartmentName() );
        department.setDisciplines( toDisciplineList( dto.getDisciplines() ) );
        department.setFaculty( toFaculty( dto.getFaculty() ) );
        department.setId( dto.getId() );
        department.setIdRh( dto.getIdRh() );
        department.setPersons( toPersonList( dto.getPersons() ) );

        return department;
    }

    @Override
    public DepartmentDTO toDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setDepartmentName( department.getDepartmentName() );
        departmentDTO.setDisciplines( toDisciplineDtoList( department.getDisciplines() ) );
        departmentDTO.setFaculty( toFacultyDto( department.getFaculty() ) );
        departmentDTO.setId( department.getId() );
        departmentDTO.setIdRh( department.getIdRh() );
        departmentDTO.setPersons( toPersonDtoList( department.getPersons() ) );

        return departmentDTO;
    }

    @Override
    public Career toCareer(CareerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Career career = new Career();

        career.setCareerName( dto.getCareerName() );
        career.setDisciplines( toDisciplineList( dto.getDisciplines() ) );
        career.setFaculty( toFaculty( dto.getFaculty() ) );
        career.setId( dto.getId() );
        career.setPersons( toPersonList( dto.getPersons() ) );

        return career;
    }

    @Override
    public CareerDTO toCareerDto(Career career) {
        if ( career == null ) {
            return null;
        }

        CareerDTO careerDTO = new CareerDTO();

        careerDTO.setCareerName( career.getCareerName() );
        careerDTO.setDisciplines( toDisciplineDtoList( career.getDisciplines() ) );
        careerDTO.setFaculty( toFacultyDto( career.getFaculty() ) );
        careerDTO.setId( career.getId() );
        careerDTO.setPersons( toPersonDtoList( career.getPersons() ) );

        return careerDTO;
    }

    @Override
    public Discipline toDiscipline(DisciplineDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Discipline discipline = new Discipline();

        discipline.setCareer( dto.getCareer() );
        discipline.setCreatedBy( dto.getCreatedBy() );
        discipline.setCreatedOn( dto.getCreatedOn() );
        discipline.setDepartment( dto.getDepartment() );
        discipline.setDisciplineName( dto.getDisciplineName() );
        discipline.setId( dto.getId() );
        discipline.setIdDisciplineSigenu( dto.getIdDisciplineSigenu() );
        discipline.setModifiedBy( dto.getModifiedBy() );
        discipline.setModifiedOn( dto.getModifiedOn() );
        discipline.setPersons( toPersonList( dto.getPersons() ) );
        discipline.setSubjectsPlans( subjectPlanDTOListToSubjectPlanList( dto.getSubjectsPlans() ) );

        return discipline;
    }

    @Override
    public DisciplineDTO toDisciplineDto(Discipline discipline) {
        if ( discipline == null ) {
            return null;
        }

        DisciplineDTO disciplineDTO = new DisciplineDTO();

        disciplineDTO.setCareer( discipline.getCareer() );
        disciplineDTO.setCreatedBy( discipline.getCreatedBy() );
        disciplineDTO.setCreatedOn( discipline.getCreatedOn() );
        disciplineDTO.setDepartment( discipline.getDepartment() );
        disciplineDTO.setDisciplineName( discipline.getDisciplineName() );
        disciplineDTO.setId( discipline.getId() );
        disciplineDTO.setIdDisciplineSigenu( discipline.getIdDisciplineSigenu() );
        disciplineDTO.setModifiedBy( discipline.getModifiedBy() );
        disciplineDTO.setModifiedOn( discipline.getModifiedOn() );
        disciplineDTO.setPersons( toPersonDtoList( discipline.getPersons() ) );
        disciplineDTO.setSubjectsPlans( toSubjectPlanDtoList( discipline.getSubjectsPlans() ) );

        return disciplineDTO;
    }

    @Override
    public Person toPerson(PersonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Person person = new Person();

        person.setAreaDirectory( dto.getAreaDirectory() );
        person.setCareer( dto.getCareer() );
        person.setCi( dto.getCi() );
        person.setCientificCategory( dto.getCientificCategory() );
        person.setCreatedBy( dto.getCreatedBy() );
        person.setCreatedOn( dto.getCreatedOn() );
        person.setDepartment( dto.getDepartment() );
        person.setDisabled( dto.getDisabled() );
        person.setDiscipline( dto.getDiscipline() );
        person.setExistInSource( dto.getExistInSource() );
        person.setFaculty( dto.getFaculty() );
        person.setHoursCollaborator( dto.getHoursCollaborator() );
        person.setHoursPosition( dto.getHoursPosition() );
        person.setId( dto.getId() );
        person.setModifiedBy( dto.getModifiedBy() );
        person.setModifiedOn( dto.getModifiedOn() );
        person.setPersonName( dto.getPersonName() );
        person.setResponsability( dto.getResponsability() );
        person.setSubjectPlan( dto.getSubjectPlan() );
        person.setTeachingCategory( dto.getTeachingCategory() );
        person.setTotalHoursPlan( dto.getTotalHoursPlan() );
        person.setUserCondition( dto.getUserCondition() );

        return person;
    }

    @Override
    public PersonDTO toPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setAreaDirectory( person.getAreaDirectory() );
        personDTO.setCareer( person.getCareer() );
        personDTO.setCi( person.getCi() );
        personDTO.setCientificCategory( person.getCientificCategory() );
        personDTO.setCreatedBy( person.getCreatedBy() );
        personDTO.setCreatedOn( person.getCreatedOn() );
        personDTO.setDepartment( person.getDepartment() );
        personDTO.setDisabled( person.getDisabled() );
        personDTO.setDiscipline( person.getDiscipline() );
        personDTO.setExistInSource( person.getExistInSource() );
        personDTO.setFaculty( person.getFaculty() );
        personDTO.setHoursCollaborator( person.getHoursCollaborator() );
        personDTO.setHoursPosition( person.getHoursPosition() );
        personDTO.setId( person.getId() );
        personDTO.setModifiedBy( person.getModifiedBy() );
        personDTO.setModifiedOn( person.getModifiedOn() );
        personDTO.setPersonName( person.getPersonName() );
        personDTO.setResponsability( person.getResponsability() );
        personDTO.setSubjectPlan( person.getSubjectPlan() );
        personDTO.setTeachingCategory( person.getTeachingCategory() );
        personDTO.setTotalHoursPlan( person.getTotalHoursPlan() );
        personDTO.setUserCondition( person.getUserCondition() );

        return personDTO;
    }

    @Override
    public SubjectPlan toSubjectPlanDto(SubjectPlanDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SubjectPlan subjectPlan = new SubjectPlan();

        subjectPlan.setCantEvalParciales( dto.getCantEvalParciales() );
        subjectPlan.setCantPl( dto.getCantPl() );
        subjectPlan.setCreatedBy( dto.getCreatedBy() );
        subjectPlan.setCreatedOn( dto.getCreatedOn() );
        subjectPlan.setDiscipline( dto.getDiscipline() );
        subjectPlan.setExamenFinal( dto.isExamenFinal() );
        subjectPlan.setId( dto.getId() );
        subjectPlan.setIdSubjectSigenu( dto.getIdSubjectSigenu() );
        subjectPlan.setId_department( dto.getId_department() );
        subjectPlan.setModifiedBy( dto.getModifiedBy() );
        subjectPlan.setModifiedOn( dto.getModifiedOn() );
        subjectPlan.setOnline( dto.isOnline() );
        List<Person> list = dto.getPersons();
        if ( list != null ) {
            subjectPlan.setPersons( new ArrayList<Person>( list ) );
        }
        subjectPlan.setSemester( dto.getSemester() );
        subjectPlan.setSubjectPlanName( dto.getSubjectPlanName() );
        subjectPlan.setTotalHorasPlan( dto.getTotalHorasPlan() );
        subjectPlan.setYear( dto.getYear() );

        return subjectPlan;
    }

    @Override
    public SubjectPlanDTO toSubjectPlanDto(SubjectPlan subjectPlan) {
        if ( subjectPlan == null ) {
            return null;
        }

        SubjectPlanDTO subjectPlanDTO = new SubjectPlanDTO();

        subjectPlanDTO.setCantEvalParciales( subjectPlan.getCantEvalParciales() );
        subjectPlanDTO.setCantPl( subjectPlan.getCantPl() );
        subjectPlanDTO.setCreatedBy( subjectPlan.getCreatedBy() );
        subjectPlanDTO.setCreatedOn( subjectPlan.getCreatedOn() );
        subjectPlanDTO.setDiscipline( subjectPlan.getDiscipline() );
        subjectPlanDTO.setExamenFinal( subjectPlan.isExamenFinal() );
        subjectPlanDTO.setId( subjectPlan.getId() );
        subjectPlanDTO.setIdSubjectSigenu( subjectPlan.getIdSubjectSigenu() );
        subjectPlanDTO.setId_department( subjectPlan.getId_department() );
        subjectPlanDTO.setModifiedBy( subjectPlan.getModifiedBy() );
        subjectPlanDTO.setModifiedOn( subjectPlan.getModifiedOn() );
        subjectPlanDTO.setOnline( subjectPlan.isOnline() );
        List<Person> list = subjectPlan.getPersons();
        if ( list != null ) {
            subjectPlanDTO.setPersons( new ArrayList<Person>( list ) );
        }
        subjectPlanDTO.setSemester( subjectPlan.getSemester() );
        subjectPlanDTO.setSubjectPlanName( subjectPlan.getSubjectPlanName() );
        subjectPlanDTO.setTotalHorasPlan( subjectPlan.getTotalHorasPlan() );
        subjectPlanDTO.setYear( subjectPlan.getYear() );

        return subjectPlanDTO;
    }

    protected List<SubjectPlan> subjectPlanDTOListToSubjectPlanList(List<SubjectPlanDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectPlan> list1 = new ArrayList<SubjectPlan>( list.size() );
        for ( SubjectPlanDTO subjectPlanDTO : list ) {
            list1.add( toSubjectPlanDto( subjectPlanDTO ) );
        }

        return list1;
    }
}
