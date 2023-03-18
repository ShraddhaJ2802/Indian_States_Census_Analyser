package org.example;

public class CensusAnalyzerCustomException extends Throwable{

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM, CENSUS_INCORRECT_FILE_FORMAT, CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER
    }

    public ExceptionType type;

    public CensusAnalyzerCustomException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

   public CensusAnalyzerCustomException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
