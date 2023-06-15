package cu.cujae.pandora.back.comms.repository;

import cu.cujae.pandora.back.comms.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;


/*
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findById(Long id);
    Optional<Role> findByRoleName(String role);
}
*/

@Repository
public class RoleRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate (dataSource);
	}
	
	//INSERT
	public Role insertLdapRole (Role r){
		String sql = "INSERT INTO ldap_role "
				+ "(name)"
				+ "VALUES (?)" ;
		this.jdbcTemplate.update(sql,
			r.getRoleName());
		return r;
		
	}
	
	//DELETE
	public void deleteLdapRole (Long id) {
		String sql = "DELETE FROM ldap_role WHERE ldap_role_id = ?";
		this.jdbcTemplate.update(sql, id);
	}
	
	//UPDATE
	public Role updateLdapRole (Role r){
		String sql = "UPDATE ldap_role SET"
				+ "name = ?"
				+ "WHERE ldap_role_id = ?" ;
		this.jdbcTemplate.update(sql,
			r.getRoleName(), r.getId());
		return r;
	}
	
	//LISTAR TODOS
	public List<Role> getAllLdapRoles(){
		String sql = "SELECT * FROM ldap_role";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		List<Role> result = new ArrayList<Role>();
		for (Map<String, Object> row:rows) {
			Role r = new Role();
			r.setId((Long)row.get("ldap_role_id"));
			r.setRoleName((String)row.get("name"));
			result.add(r);
		}
		return result;
	}
	
	//DEVOLVER POR NAME
	public Role findByRoleName(String name){
		Role r = jdbcTemplate.queryForObject("SELECT * FROM ldap_role WHERE name = ?", BeanPropertyRowMapper.newInstance(Role.class), name);
		return r;
	}
	
	//DEVOLVER POR ID
	public Role getLdapRoleById(Long id){
		Role r = jdbcTemplate.queryForObject("SELECT * FROM ldap_role WHERE ldap_role_id = ?", BeanPropertyRowMapper.newInstance(Role.class), id);
		return r;
	}
}
