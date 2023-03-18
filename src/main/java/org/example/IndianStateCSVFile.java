package org.example;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCSVFile {

    @CsvBindByName(column = "State")
    public String state;

    @CsvBindByName(column = "TIN")
    public String TIN;

    @CsvBindByName(column = "stateCode")
    public String stateCode;


    @Override
    public String toString() {
        return "IndiaStateCSV{" +
                ", state='" + state + '\'' +
                ", TIN=" + TIN +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
