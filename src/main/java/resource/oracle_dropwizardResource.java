package resource;

import api.oracle_dropwizard;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class oracle_dropwizardResource {

    private int inputNumber;

    public oracle_dropwizardResource(int inputNumber){
        this.inputNumber = inputNumber;
    }

    public String printResult(Integer input){
        List<BigInteger> fibonacci = getResult(input);
        List<BigInteger> sorted = getSorted(fibonacci);

        return "fibonacci: " + fibonacci +" sorted: " + sorted;
    }

    public List<BigInteger> getResult(Integer input){
        int maxNumber = input;
        BigInteger previousNumber = new BigInteger("0");
        BigInteger nextNumber = new BigInteger("1");

        ArrayList<BigInteger> resultIntegers = new ArrayList<BigInteger>();

        int i = 1;
        while(i <= maxNumber) {
            resultIntegers.add(previousNumber);
            BigInteger sum = previousNumber.add(nextNumber);
            previousNumber = nextNumber;
            nextNumber = sum;
            i++;
        }
        return resultIntegers;
    }

    public List<BigInteger> getSorted(List<BigInteger> result){

        ArrayList<BigInteger> resultEven = new ArrayList<BigInteger>();
        for(BigInteger i : result) {
            if (!i.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                continue;
            }
            resultEven.add(i);
        }
        ArrayList<BigInteger> resultOdd = new ArrayList<BigInteger>();
        for(BigInteger i : result) {
            if (i.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                continue;
            }
            resultOdd.add(i);
        }

        ArrayList<BigInteger> sortedResult = new ArrayList<BigInteger>();
        Collections.sort(resultEven, Collections.reverseOrder());
        Collections.sort(resultOdd, Collections.reverseOrder());
        sortedResult.addAll(resultEven);
        sortedResult.addAll(resultOdd);

        return sortedResult;
    }
    @GET
    public oracle_dropwizard getFinalResult(@QueryParam("elements") Integer elements){
        return new oracle_dropwizard(printResult(elements));
    }

}
