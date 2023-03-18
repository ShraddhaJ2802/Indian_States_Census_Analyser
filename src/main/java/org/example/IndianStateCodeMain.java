package org.example;

public class IndianStateCodeMain {
    public static void main(String[] args) {

        StateCode stateCode = new StateCode();
        try{

            stateCode.loadIndianStateCode("C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\main\\resources\\StateCode.csv");

        }
        catch (StateCodeCustomException e) {
            e.printStackTrace();
        }

    }
}
