package shankara.calc;

import com.cyberpointllc.stac.calculator.Calculator;
import com.cyberpointllc.stac.calculator.CalculatorFormatter;
import com.cyberpointllc.stac.calculator.LargeNumeralFormatter;
import com.cyberpointllc.stac.calculator.RomanNumeralFormatter;

import java.util.Map;
import edu.utexas.stac.Cost;

import shankara.fitnessparams.FitnessParams;



public class Calc {
    enum CalcType {
        DIGIT, ROMAN
    }
    public FitnessParams computeExpression(CalcType type, String expression) {
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
        FitnessParams params = new FitnessParams();
        params.cost = Cost.read();
        params.limits = calc.penaltyScores;
        return params;
    }
}
