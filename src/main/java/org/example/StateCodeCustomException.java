package org.example;

public class StateCodeCustomException  extends Exception {

    public enum ExceptionType {
        STATE_CODE_FILE_PROBLEM, STATE_CODE_INCORRECT_FILE_FORMAT, STATE_CODE_WRONG_DELIMITER_OR_WRONG_HEADER
    }

    public StateCodeCustomException.ExceptionType type;

    public StateCodeCustomException(String message, StateCodeCustomException.ExceptionType type) {
        super(message);
        this.type = type;
    }

    public StateCodeCustomException(String message, StateCodeCustomException.ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
