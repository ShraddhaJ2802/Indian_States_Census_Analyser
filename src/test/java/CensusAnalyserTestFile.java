import org.example.CensusAnalyser;
import org.example.CensusAnalyzerCustomException;
import org.example.StateCode;
import org.example.StateCodeCustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.CensusAnalyzerCustomException.ExceptionType.*;
import static org.example.StateCodeCustomException.ExceptionType.STATE_CODE_FILE_PROBLEM;

public class CensusAnalyserTestFile {


    private static final String WRONG_CSV_FILE_PATH = "State.csv";

    private static final String CSV_WITH_WRONG_DELIMITER = "C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\IncorrectDelimiterFile.csv";
    private static final String INCORRECT_FILE_FORMAT = "C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\StateCensusData.txt";
    private String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\StateCensusData.csv";

    private static final String CSV_WITH_INCORRECT_HEADER = "C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\WrongHeader.csv";

   private String INDIA_STATE_CODE_CSV ="C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\StateCode.csv";
   private static final String INCORRECT_STATE_CODE_FILE_FORMAT = "C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\StateCode.txt";

    private String WRONG_STATE_CODE_FILE ="state.txt";
    //TC 1.1
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusAnalyzerCustomException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assertions.assertEquals(29, count);

    }

    //TC2.1
    @Test
    public void givenIndiaStateCodeCSVFile_WhenCorrectPath_ShouldReturnsCorrectRecords() throws StateCodeCustomException {
        StateCode censusAnalyser = new StateCode();

        int numOfRecords = censusAnalyser.loadIndianStateCode(INDIA_STATE_CODE_CSV);
        Assertions.assertEquals(37,numOfRecords);
    }

    //TC1.2
    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowExceptionSadTest() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerCustomException exceptionRule = Assertions.assertThrows(CensusAnalyzerCustomException.class,()->{
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        });
        Assertions.assertEquals(CENSUS_FILE_PROBLEM, exceptionRule.type);

    }

    //TC2.2
    @Test
    public void givenIndiaStateData_WithWrongFile_ShouldThrowExceptionSadTest() {

        StateCode stateCode = new StateCode();
        StateCodeCustomException exceptionRule = Assertions.assertThrows(StateCodeCustomException.class,()->{
            stateCode.loadIndianStateCode(WRONG_STATE_CODE_FILE);
        });

        Assertions.assertEquals(STATE_CODE_FILE_PROBLEM, exceptionRule.type);
    }

    //TC 1.3
    @Test
    public void givenIndiaCensusData_WithWrongFileFormat_ShouldThrowExceptionSadTest() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerCustomException exceptionRule = Assertions.assertThrows(CensusAnalyzerCustomException.class,()->{
            censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
        });
        Assertions.assertEquals(CENSUS_INCORRECT_FILE_FORMAT, exceptionRule.type);
    }

    //TC 2.3
    @Test
    public void givenIndiaStateCodeData_WithWrongFileFormat_ShouldThrowExceptionSadTest() {

        StateCode stateCode = new StateCode();
        StateCodeCustomException exceptionRule = Assertions.assertThrows(StateCodeCustomException.class,()->{
            stateCode.loadIndianStateCode(INCORRECT_STATE_CODE_FILE_FORMAT);
        });

        Assertions.assertEquals(STATE_CODE_INCORRECT_FILE_FORMAT, exceptionRule.type);
    }
//TC 1.4
    @Test
    public void givenIndianCensusCSVFile_WhenCustomDelimiter_ShouldThrowException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerCustomException exceptionRule = Assertions.assertThrows(CensusAnalyzerCustomException.class,()->{
            censusAnalyser.loadIndiaCensusData(CSV_WITH_WRONG_DELIMITER);
        });
        Assertions.assertEquals(CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, exceptionRule.type);
    }

    @Test
    public void givenIndianCensusCSVFile_WhenIncorrectHeader_ShouldThrowExceptionSadTest() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerCustomException  exceptionRule = Assertions.assertThrows(CensusAnalyzerCustomException .class,()->{
            censusAnalyser.loadIndiaCensusData(CSV_WITH_INCORRECT_HEADER);
        });
        Assertions.assertEquals(CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, exceptionRule.type);
    }


}
