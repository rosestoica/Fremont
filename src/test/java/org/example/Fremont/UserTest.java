package org.example.Fremont;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User();

        // Test username
        user.setUsername("testUser");
        assertEquals("testUser", user.getUsername());

        // Test password
        user.setPassword("password");
        assertEquals("password", user.getPassword());

        // Test nume
        user.setNume("Doe");
        assertEquals("Doe", user.getNume());

        // Test prenume
        user.setPrenume("John");
        assertEquals("John", user.getPrenume());

        // Test varsta
        user.setVarsta(30);
        assertEquals(30, user.getVarsta());

        // Test sex
        user.setSex("Male");
        assertEquals("Male", user.getSex());

        // Test tara
        user.setTara("USA");
        assertEquals("USA", user.getTara());

        // Test oras
        user.setOras("New York");
        assertEquals("New York", user.getOras());

        // Test role
        user.setRole(1);
        assertEquals(1, user.getRole());

        // Test oPoza
        byte[] picture = new byte[]{1, 2, 3};
        user.setOPoza(picture);
        assertArrayEquals(picture, user.getOPoza());
    }
}
