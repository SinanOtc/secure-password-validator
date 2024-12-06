package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Advanced implementation of the PasswordValidator interface.
 * 
 * This validator ensures passwords meet the following criteria:
 * <ul>
 *   <li>At least 12 characters in length</li>
 *   <li>Contains at least one uppercase letter</li>
 *   <li>Contains at least one lowercase letter</li>
 *   <li>Contains at least one digit</li>
 *   <li>Contains at least one special character (@#$%^&+=!)</li>
 *   <li>Does not contain spaces</li>
 *   <li>Does not have repeated sequences of 3 or more characters</li>
 * </ul>
 */
public class AdvancedPasswordValidator implements PasswordValidator {

    // Regular expression patterns for password validation
    private static final Pattern LENGTH_PATTERN = Pattern.compile("^.{12,}$");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
    private static final Pattern DIGIT_PATTERN = Pattern.compile(".*\\d.*");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile(".*[@#$%^&+=!].*");
    private static final Pattern NO_SPACES_PATTERN = Pattern.compile(".*\\s.*");
    private static final Pattern NO_REPEATED_SEQUENCE_PATTERN = Pattern.compile(".*(.{3,})\\1.*");

    /**
     * Validates the given password based on the predefined criteria.
     *
     * @param password the password to validate
     * @return true if the password meets all criteria, false otherwise
     */
    @Override
    public boolean validate(String password) {
        if (password == null) return false;

        return LENGTH_PATTERN.matcher(password).matches() &&
               UPPERCASE_PATTERN.matcher(password).matches() &&
               LOWERCASE_PATTERN.matcher(password).matches() &&
               DIGIT_PATTERN.matcher(password).matches() &&
               SPECIAL_CHAR_PATTERN.matcher(password).matches() &&
               !NO_SPACES_PATTERN.matcher(password).matches() &&
               !NO_REPEATED_SEQUENCE_PATTERN.matcher(password).matches();
    }

    /**
     * Provides a detailed validation message for the given password.
     *
     * @param password the password to validate
     * @return a validation message explaining why the password is invalid, or an empty string if valid
     */
    @Override
    public String getValidationMessage(String password) {
        if (password == null) {
            return "Password cannot be null.";
        }

        List<String> errors = new ArrayList<>();
        if (!LENGTH_PATTERN.matcher(password).matches()) {
            errors.add("Password must be at least 12 characters long.");
        }
        if (!UPPERCASE_PATTERN.matcher(password).matches()) {
            errors.add("Password must contain at least one uppercase letter.");
        }
        if (!LOWERCASE_PATTERN.matcher(password).matches()) {
            errors.add("Password must contain at least one lowercase letter.");
        }
        if (!DIGIT_PATTERN.matcher(password).matches()) {
            errors.add("Password must contain at least one digit.");
        }
        if (!SPECIAL_CHAR_PATTERN.matcher(password).matches()) {
            errors.add("Password must contain at least one special character (@#$%^&+=!).");
        }
        if (NO_SPACES_PATTERN.matcher(password).matches()) {
            errors.add("Password must not contain spaces.");
        }
        if (NO_REPEATED_SEQUENCE_PATTERN.matcher(password).matches()) {
            errors.add("Password must not contain repeated sequences of 3 or more characters.");
        }

        return String.join(" ", errors);
    }
}
