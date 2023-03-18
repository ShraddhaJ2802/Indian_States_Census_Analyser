package org.example;

public class IndianCensusMain {
    public static void main(String[] args) {

        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {

            censusAnalyser.loadIndiaCensusData("C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\StateCensusData.csv");
        } catch (CensusAnalyzerCustomException e) {
            e.printStackTrace();
        }

    }
}
