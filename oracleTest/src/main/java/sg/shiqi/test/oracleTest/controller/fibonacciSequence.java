package sg.shiqi.test.oracleTest.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fibonacci")
public class fibonacciSequence {
	
	@GetMapping("/{input}")
	public String printResult(@PathVariable("input") Integer input){
		List<BigInteger> fibonacci = getResult(input);
		List<BigInteger> sorted = getSorted(fibonacci);
		
		return "fibonacci: " + fibonacci +"\n sorted: " + sorted;
	}
	
	public List<BigInteger> getResult(Integer input){
		int maxNumber = input;
		BigInteger previousNumber = new BigInteger("0");
		BigInteger nextNumber = new BigInteger("1");
		
		ArrayList<BigInteger> resultIntegers = new ArrayList<>();
		
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
		
		ArrayList<BigInteger> resultEven = new ArrayList<>();
		for(BigInteger i : result) {
			if (!i.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
				continue;
			}
			resultEven.add(i);
		}
		ArrayList<BigInteger> resultOdd = new ArrayList<>();
		for(BigInteger i : result) {
			if (i.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
				continue;
			}
			resultOdd.add(i);
		}

		ArrayList<BigInteger> sortedResult = new ArrayList<>(); 
		Collections.sort(resultEven, Collections.reverseOrder());
		Collections.sort(resultOdd, Collections.reverseOrder());
		sortedResult.addAll(resultEven);
		sortedResult.addAll(resultOdd);
		
		return sortedResult;
	}
}
