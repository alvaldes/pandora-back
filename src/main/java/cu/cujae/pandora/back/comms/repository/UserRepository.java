package cu.cujae.pandora.back.comms.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

/*@Repository
public interface UserRepository  extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}*/

@Repository
public class UserRepository {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate (dataSource);
	}
	
	//INSERT
		public UserEntity insertLdapUser(UserEntity u){
			String sql = "INSERT INTO ldap_user "
					+ "(ci, email, id_role, lastname, name, password, position, status, username)"
					+ "VALUES (?,?,?,?,?,?,?,?,?)" ;
			this.jdbcTemplate.update(sql,
				u.getCi(),
				u.getEmail(),
				u.getRole().getId(),
				u.getLastname(),
				u.getName(),
				u.getPassword(),
				u.getPosition(),
				u.getStatus(),
				u.getUsername());
			return u;
			
		}
		//DELETE
		public void deleteLdapUser (Long id) {
			String sql = "DELETE FROM ldap_user WHERE id_user = ?";
			this.jdbcTemplate.update(sql, id);
		}
		
		//UPDATE
		public UserEntity updateLdapUser (UserEntity u){
			String sql = "UPDATE ldap_user SET"
					+ "ci = ?"
					+ "email = ?"
					+ "id_role = ?"
					+ "lastname = ?"
					+ "name = ?"
					+ "password = ?"
					+ "position = ?"
					+ "status = ?"
					+ "username = ?"
					+ "WHERE id_user = ?" ;
			this.jdbcTemplate.update(sql,
					u.getCi(),
					u.getEmail(),
					u.getRole().getId(),
					u.getLastname(),
					u.getName(),
					u.getPassword(),
					u.getPosition(),
					u.getStatus(),
					u.getUsername());
			return u;
		}
		
		//LISTAR TODOS
		public List<UserEntity> getAllLdapUsers(){
			String sql = "SELECT * FROM ldap_user";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			
			List<UserEntity> result = new ArrayList<UserEntity>();
			for (Map<String, Object> row:rows) {
				UserEntity u = new UserEntity();
				u.setId((Long)row.get("id_user"));
				u.setCi((String)row.get("ci"));
				u.getRole().setId((Long)row.get("id_role"));
				u.setLastname((String)row.get("lastname"));
				u.setName((String)row.get("name"));
				u.setPassword((String)row.get("password"));
				u.setPosition((String)row.get("position"));
				u.setStatus((String)row.get("status"));
				u.setUsername((String)row.get("username"));
				result.add(u);
			}
			return result;
		}
		
		//DEVOLVER POR USERNAME
		public UserEntity findByUsername(String username){
			UserEntity u = jdbcTemplate.queryForObject("SELECT * FROM ldap_user WHERE username = ?", BeanPropertyRowMapper.newInstance(UserEntity.class), username);
			return u;
		}
		
		//DEVOLVER POR ID
		public UserEntity getLdapUserById(Long id){
			UserEntity u = jdbcTemplate.queryForObject("SELECT * FROM ldap_user WHERE id_user = ?", BeanPropertyRowMapper.newInstance(UserEntity.class), id);
			return u;
		}
		
		
		//EXISTE USER CON ESE NOMBRE
		public Boolean existsByUsername(String username) {
			boolean existe = false;
			UserEntity u = jdbcTemplate.queryForObject("SELECT * FROM ldap_user WHERE username = ?", BeanPropertyRowMapper.newInstance(UserEntity.class), username);
			if(u != null) {
				existe = true;
			}
			return existe;
		}
	}


