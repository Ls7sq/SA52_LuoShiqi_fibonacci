package api;

import java.util.List;

public class oracle_dropwizard {

    private String printResult;

    public oracle_dropwizard(){

    }
    public oracle_dropwizard(String printResult){
        this.printResult = printResult;
    }

    public String getPrintResult(){
        return printResult;
    }
}
