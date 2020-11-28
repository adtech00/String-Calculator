package com.adtech.stringcalculator.service;

import com.adtech.stringcalculator.model.constants.CalculatorConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CalculatorService {

    @Autowired
    private CalculatorConstants calculatorConstants;

    public int add(String numbers){
        if(numbers.trim().isEmpty()){
            return 0;
        }else{
            if (containsItemFromArray(numbers, calculatorConstants.DELIMITERS)){
                StringBuilder cleanedNums=new StringBuilder();
                for (String del:calculatorConstants.DELIMITERS) {
                    numbers=numbers.replaceAll(del,";");
                }

                //todo:remove after result conf
                String [] finalNumStr=numbers.split(";");
                int[] intArr=Arrays.asList(finalNumStr).stream().mapToInt(Integer::parseInt).toArray();
                int sum = Arrays.stream(intArr).sum();
                return sum;
            }else {
                return toInt(numbers);
            }
        }
    }

    public static boolean containsItemFromArray(String inputString, String[] items) {
        return Arrays.stream(items).anyMatch(inputString::contains);
    }

    private int toInt(String str){
        return Integer.parseInt(str);
    }
}
