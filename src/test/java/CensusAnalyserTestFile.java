import org.example.CensusAnalyser;
import org.example.CensusAnalyzerCustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CensusAnalyserTestFile {
    private String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\StateCensusData.csv";

    //TC 1.1
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusAnalyzerCustomException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assertions.assertEquals(29, count);

    }
}
