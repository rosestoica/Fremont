//package org.example.Fremont;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Repository
//public class UserRepository {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//
//
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	public User findByUsername(String username) {
//		String sql = "SELECT * FROM User WHERE username = ?";
//		return jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
//	}
//
//	public void save(User user) {
//		String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
//		String sql = "INSERT INTO User (username, password, nume, prenume, varsta, sex, tara, oras, role, o_poza) " +
//				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		jdbcTemplate.update(sql, user.getUsername(), hashedPassword, user.getNume(), user.getPrenume(),
//				user.getVarsta(), user.getSex(), user.getTara(), user.getOras(), user.getRole(), user.getOPoza());
//	}
//
//	private static class UserRowMapper implements RowMapper<User> {
//		@Override
//		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//			User user = new User();
//			user.setUsername(rs.getString("username"));
//			user.setPassword(rs.getString("password"));
//			user.setNume(rs.getString("nume"));
//			user.setPrenume(rs.getString("prenume"));
//			user.setVarsta(rs.getInt("varsta"));
//			user.setSex(rs.getString("sex"));
//			user.setTara(rs.getString("tara"));
//			user.setOras(rs.getString("oras"));
//			user.setRole(rs.getInt("role"));
//			user.setOPoza(rs.getBytes("o_poza"));
//			return user;
//		}
//	}
//}
package org.example.Fremont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findByUsername(String username) {
		//String sql = "SELECT * FROM User WHERE username = ?";
		//return jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
		if(username.equals("user1"))
			return new User();
		else
			return null;
	}

	public void save(User user) {
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		String sql = "INSERT INTO User (username, password, nume, prenume, varsta, sex, tara, oras, role, o_poza) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getUsername(), hashedPassword, user.getNume(), user.getPrenume(),
				user.getVarsta(), user.getSex(), user.getTara(), user.getOras(), user.getRole(), user.getOPoza());
	}

	private static class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setNume(rs.getString("nume"));
			user.setPrenume(rs.getString("prenume"));
			user.setVarsta(rs.getInt("varsta"));
			user.setSex(rs.getString("sex"));
			user.setTara(rs.getString("tara"));
			user.setOras(rs.getString("oras"));
			user.setRole(rs.getInt("role"));
			user.setOPoza(rs.getBytes("o_poza"));
			return user;
		}
	}
}
