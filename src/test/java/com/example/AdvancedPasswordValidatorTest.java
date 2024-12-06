package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the AdvancedPasswordValidator class.
 */
class AdvancedPasswordValidatorTest {

    private final PasswordValidator validator = new AdvancedPasswordValidator();

    /**
     * Tests a valid password that meets all criteria.
     */
    @Test
    void testValidPassword() {
        assertTrue(validator.validate("Complex@12345!"));
    }

    /**
     * Tests a password that is too short.
     */
    @Test
    void testTooShortPassword() {
        assertFalse(validator.validate("Short1@"));
        assertEquals("Password must be at least 12 characters long.", 
                     validator.getValidationMessage("Short1@"));
    }

    /**
     * Tests a password that lacks a special character.
     */
    @Test
    void testMissingSpecialCharacter() {
        assertFalse(validator.validate("MissingSpecial1"));
        assertTrue(validator.getValidationMessage("MissingSpecial1")
                   .contains("Password must contain at least one special character"));
    }

    /**
     * Tests a password with repeated sequences of characters.
     */
    @Test
    void testRepeatedSequences() {
        assertFalse(validator.validate("Password123123!"));
        assertTrue(validator.getValidationMessage("Password123123!")
                   .contains("Password must not contain repeated sequences"));
    }

    /**
     * Tests a null password.
     */
    @Test
    void testNullPassword() {
        assertFalse(validator.validate(null));
        assertEquals("Password cannot be null.", validator.getValidationMessage(null));
    }
}
