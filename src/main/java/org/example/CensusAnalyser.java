package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {

    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyzerCustomException {

        if(!csvFilePath.contains(".txt")){

            try {

                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
                CsvToBeanBuilder<IndianCensusAnalyserCSVFile> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                csvToBeanBuilder.withType(IndianCensusAnalyserCSVFile.class);
                csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                CsvToBean<IndianCensusAnalyserCSVFile> csvToBean = csvToBeanBuilder.build();
                Iterator<IndianCensusAnalyserCSVFile> censusCSVIterator = csvToBean.iterator();

                int namOfEateries = 0;
                while (censusCSVIterator.hasNext()) {
                    namOfEateries++;
                    IndianCensusAnalyserCSVFile censusData = censusCSVIterator.next();
                }
                return namOfEateries;
            } catch (IOException e) {
                throw new CensusAnalyzerCustomException(e.getMessage(), CensusAnalyzerCustomException.ExceptionType.CENSUS_FILE_PROBLEM);
            } catch(RuntimeException e) {
                throw new CensusAnalyzerCustomException("CSV File Must Have Comma As Delimiter Has Incorrect Header", CensusAnalyzerCustomException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER);
            }

        }
        else {
            throw new CensusAnalyzerCustomException("File Not Supported", CensusAnalyzerCustomException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
        }
    }

}
