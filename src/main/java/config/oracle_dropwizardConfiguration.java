package config;

import io.dropwizard.Configuration;

public class oracle_dropwizardConfiguration extends Configuration {

    private int inputNumber;

    public int getInputNumber(){
        return inputNumber;
    };

    public void setInputNumber(int inputNumber){
        this.inputNumber = inputNumber;
    };
}
