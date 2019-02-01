package shankara.calc4;

import com.cyberpointllc.stac.calculator.CalculatorFormatter;
import com.cyberpointllc.stac.calculator.LargeNumeralFormatter;
import com.cyberpointllc.stac.calculator.RomanNumeralFormatter;
import com.cyberpointllc.stac.calculator.Calculator;
//import edu.utexas.stac.Cost;


public class Calc4 {
    enum CalcType {
        DIGIT, ROMAN
    }

    public long computeExpression(CalcType type, String expression) {
        CalculatorFormatter f;
        switch (type) {
            case DIGIT: f = new LargeNumeralFormatter();
                break;
            case ROMAN: f = new RomanNumeralFormatter();
                break;
            default:
                f = new RomanNumeralFormatter();
                break;
        }
        Calculator calc = new Calculator(f);
        //Cost.reset();
        try {
            calc.handleExpression(expression);
        } catch (Exception e){}
        //return Cost.read();
        return 0;
    }

}
