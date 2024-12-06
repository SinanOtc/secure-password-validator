package com.example;

/**
 * Interface for validating passwords.
 */
public interface PasswordValidator {

    /**
     * Validates a password based on predefined criteria.
     *
     * @param password the password to validate
     * @return true if the password meets all criteria, false otherwise
     */
    boolean validate(String password);

    /**
     * Provides a validation message for an invalid password.
     *
     * @param password the password to validate
     * @return a detailed validation message explaining why the password is invalid
     */
    String getValidationMessage(String password);
}
