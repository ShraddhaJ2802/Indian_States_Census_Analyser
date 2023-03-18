package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCode {

    public int loadIndianStateCode(String csvFilePath) throws StateCodeCustomException {
        try {
            if(csvFilePath.contains(".txt")) {
                throw new StateCodeCustomException("File must be in CSV Format", StateCodeCustomException.ExceptionType.STATE_CODE_INCORRECT_FILE_FORMAT);
            }
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndianStateCSVFile> csvToBeanBuilder = new CsvToBeanBuilder<IndianStateCSVFile>(reader);
            csvToBeanBuilder.withType(IndianStateCSVFile.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianStateCSVFile> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianStateCSVFile> stateCodesCSVIterator = csvToBean.iterator();
            int numberOfEntries = 0;
            while(stateCodesCSVIterator.hasNext()) {
                numberOfEntries++;
                IndianStateCSVFile censusData = stateCodesCSVIterator.next();
            }
            return numberOfEntries;
        }
        catch (IOException e) {
            throw new StateCodeCustomException(e.getMessage(), StateCodeCustomException.ExceptionType.STATE_CODE_FILE_PROBLEM);
        }
        catch(RuntimeException e) {
            throw new StateCodeCustomException("CSV File Must Have Comma As Delimiter Or Has Incorrect Header", StateCodeCustomException.ExceptionType.STATE_CODE_WRONG_DELIMITER_OR_WRONG_HEADER);
        }
    }
}
