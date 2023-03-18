import org.example.CensusAnalyser;
import org.example.CensusAnalyzerCustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.CensusAnalyzerCustomException.ExceptionType.CENSUS_FILE_PROBLEM;
import static org.example.CensusAnalyzerCustomException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT;

public class CensusAnalyserTestFile {


    private static final String WRONG_CSV_FILE_PATH = "State.csv";
    private static final String INCORRECT_FILE_FORMAT = "C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\StateCensusData.txt";
    private String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\StateCensusData.csv";

    //TC 1.1
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusAnalyzerCustomException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assertions.assertEquals(29, count);

    }
    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowExceptionSadTest() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerCustomException exceptionRule = Assertions.assertThrows(CensusAnalyzerCustomException.class,()->{
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        });
        Assertions.assertEquals(CENSUS_FILE_PROBLEM, exceptionRule.type);

    }
    @Test
    public void givenIndiaCensusData_WithWrongFileFormat_ShouldThrowExceptionSadTest() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerCustomException exceptionRule = Assertions.assertThrows(CensusAnalyzerCustomException.class,()->{
            censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
        });
        Assertions.assertEquals(CENSUS_INCORRECT_FILE_FORMAT, exceptionRule.type);
    }
}
