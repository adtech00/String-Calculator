package com.adtech.stringcalculator;

import com.adtech.stringcalculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CalculatorTest {
    @Autowired
    private CalculatorService calculatorService;


    @Test
    public void returnZeroOnEmptyString(){
        //arrange

        //act
        int res = calculatorService.add("");

        //assert
        assertEquals(0, res);
    }

    @Test
    public void returnNumOnNumString(){
        //arrange

        //act
        int res = calculatorService.add("16");

        //assert
        assertEquals(16, res);
    }

}