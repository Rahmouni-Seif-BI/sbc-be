package com.example.IgniteSelfBudgetControlMultiUser.ABC.Exeptions;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException(String message) {
        super(message);
    }
}
