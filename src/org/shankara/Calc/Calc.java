package org.shankara.Calc;

import com.cyberpointllc.stac.calculator.Calculator;
import com.cyberpointllc.stac.calculator.LargeNumeralFormatter;
import edu.utexas.stac.Cost;

public class Calc {
        public long computeExpression(String expression) {
            System.out.println("Expression: " + expression);
            LargeNumeralFormatter formatter = new LargeNumeralFormatter();
            Calculator calc = new Calculator(formatter);
            Cost.reset();
            try {
                calc.handleExpression(expression);
            } catch (Exception e){}
            return Cost.read();
        }
}
