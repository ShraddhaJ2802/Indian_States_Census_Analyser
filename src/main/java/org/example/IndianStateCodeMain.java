package org.example;

public class IndianStateCodeMain {
    public static void main(String[] args) {

        StateCode stateCode = new StateCode();
        try{

            stateCode.loadIndianStateCode("C:\\Users\\Icon\\IdeaProjects\\Indian_States_Census_Analyser\\src\\main\\resources\\StateCode.csv");

        }
        catch (StateCodeCustomException e) {
            e.printStackTrace();
        }

    }
}
