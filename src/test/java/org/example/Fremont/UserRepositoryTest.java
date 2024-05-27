package org.example.Fremont;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private PasswordEncoder passwordEncoder;

	@InjectMocks
	private UserRepository userRepository;

	private final String USERNAME = "testUser";
	private final String SQL = "SELECT * FROM User WHERE username = ?";

	@BeforeEach
	void setUp() {
		// Any setup code if needed
	}

	@Test
	void testFindByUsername() {
		User expectedUser = new User();
		// Set up expectedUser with necessary properties

		when(jdbcTemplate.queryForObject(eq(SQL), any(Object[].class), any(RowMapper.class)))
				.thenReturn(expectedUser);

		User actualUser = userRepository.findByUsername(USERNAME);

		assertNotNull(actualUser);
		assertEquals(expectedUser, actualUser);

		verify(jdbcTemplate, times(1)).queryForObject(eq(SQL), any(Object[].class), any(RowMapper.class));
	}
}
