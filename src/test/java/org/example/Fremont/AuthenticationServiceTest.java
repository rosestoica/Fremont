package org.example.Fremont;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticationService authenticationService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setUsername("testUser");
        testUser.setPassword("encodedPassword");
    }

    @Test
    void testAuthenticateSuccess() {
        String rawPassword = "rawPassword";

        // Mock the user repository to return the test user
        when(userRepository.findByUsername("testUser")).thenReturn(testUser);

        // Mock the password encoder to return true for the password match
        when(passwordEncoder.matches(rawPassword, testUser.getPassword())).thenReturn(true);

        // Call the method to test
        boolean result = authenticationService.authenticate("testUser", rawPassword);

        // Assert the result
        assertTrue(result);
    }

    @Test
    void testAuthenticateFailureDueToWrongPassword() {
        String rawPassword = "wrongPassword";

        // Mock the user repository to return the test user
        when(userRepository.findByUsername("testUser")).thenReturn(testUser);

        // Mock the password encoder to return false for the password match
        when(passwordEncoder.matches(rawPassword, testUser.getPassword())).thenReturn(false);

        // Call the method to test
        boolean result = authenticationService.authenticate("testUser", rawPassword);

        // Assert the result
        assertFalse(result);
    }

    @Test
    void testAuthenticateFailureDueToUserNotFound() {
        String rawPassword = "rawPassword";

        // Mock the user repository to return null
        when(userRepository.findByUsername("testUser")).thenReturn(null);

        // Call the method to test
        boolean result = authenticationService.authenticate("testUser", rawPassword);

        // Assert the result
        assertFalse(result);
    }
}
