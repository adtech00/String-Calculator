package com.adtech.stringcalculator;

import com.adtech.stringcalculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SpringBootTest
public class CalculatorTest {
    @Autowired
    private CalculatorService calculatorService;


    @Test
    public void returnZeroOnEmptyString() throws Exception {
        //arrange

        //act
        int res = calculatorService.add("");

        //assert
        assertEquals(0, res);
    }

    @Test
    public void returnNumOnNumString() throws Exception {
        //arrange

        //act
        int res = calculatorService.add("16");

        //assert
        assertEquals(16, res);
    }

    @Test
    public void commaSeparatedSum() throws Exception {
        int res = calculatorService.add("11,2");
        assertEquals(13,res);
    }

    @Test
    public void sumMultipleNums() throws Exception {
        int res = calculatorService.add("11,2,7,80");
        assertEquals(100,res);
    }

    @Test
    public void newLinesValidDelimiter() throws Exception {
        int res = calculatorService.add("11,2\n7,80");
        assertEquals(100,res);
    }

    @Test
    public void supportDiffDelimiter() throws Exception {
        int res = calculatorService.add("//;\n1;2");
        assertEquals(3,res);
    }

    @Test
    public void unSupportedNeg(){
        try{
            int res = calculatorService.add("-1,2,-4");
            fail("Exception Expected.");
        }catch (Exception e){
            assertEquals("Negative Nums Not Allowed: [-1, -4]", e.getMessage());
        }
    }

    @Test
    public void bigNumHasNoVal() throws Exception {
        int res = calculatorService.add("2,1001");
        assertEquals(2,res);
    }

    @Test
    public void delimiterAnyLength() throws Exception {
        int res = calculatorService.add("//[***]\\n1***2***3");
        assertEquals(6,res);
    }

    @Test
    public void multipleDelimiter() throws Exception {
        int res = calculatorService.add("//[*][%]\\n1*2%3");
        assertEquals(6,res);
    }
}
