package shankara.calc;

import com.cyberpointllc.stac.arithmetizer.*;
import com.cyberpointllc.stac.calculator.*;
import edu.utexas.stac.Cost;


public class Calc {
    public static boolean calc4;

    public FitnessParams CalculateDigit(String expression) {
        if (calc4)
            return runCalc4(new BigNumberFormatter(), expression);
        return runCalc(new LargeNumeralFormatter(), expression);
    }

    public FitnessParams CalculateRoman(String expression) {
        if (calc4)
            return runCalc4(new com.cyberpointllc.stac.arithmetizer.RomanNumeralFormatter(), expression);
        return runCalc(new com.cyberpointllc.stac.calculator.RomanNumeralFormatter(), expression);
    }

    public FitnessParams CalculateRise(EnglishUnit rise, EnglishUnit run) {
        String expression = "((" + rise.toString() + "^ 2|16) + (" + run.toString() + "^ 2|16))r 2|16";
        if (calc4)
            return runCalc4(new ImperialFormatter(), expression);
        return runCalc(new UnitFormatter(), expression);
    }

    public FitnessParams CalculateCircumference(EnglishUnit radius) {
        String expression = "2|16 * " + radius.toString() + " * " + EnglishUnit.PI;
        if (calc4)
            return runCalc4(new ImperialFormatter(), expression);
        return runCalc(new UnitFormatter(), expression);
    }

    public FitnessParams CalculateArea(EnglishUnit radius) {
        String expression = "(" + radius.toString() + "^2|16) * " + EnglishUnit.PI;
        if (calc4)
            return runCalc4(new com.cyberpointllc.stac.arithmetizer.SquareUnitFormatter(), expression);
        return runCalc(new com.cyberpointllc.stac.calculator.SquareUnitFormatter(), expression);
    }

    public FitnessParams CalculateSurfaceArea(EnglishUnit radius) {
        String expression = "4|16 * (" + radius.toString() + "^2|16) * " + EnglishUnit.PI;
        if (calc4)
            return runCalc4(new com.cyberpointllc.stac.arithmetizer.SquareUnitFormatter(), expression);
        return runCalc(new com.cyberpointllc.stac.calculator.SquareUnitFormatter(), expression);
    }

    public FitnessParams CalculateVolume(EnglishUnit radius) {
        String expression = "4|16 * (" + radius.toString() + "^3|16) * " + EnglishUnit.PI + " / 3|16";
        if (calc4)
            return runCalc4(new com.cyberpointllc.stac.arithmetizer.VolumeUnitFormatter(), expression);
        return runCalc(new com.cyberpointllc.stac.calculator.VolumeUnitFormatter(), expression);
    }

    private FitnessParams runCalc4(ArithmetizerFormatter f, String expression) {
        Arithmetizer a = new Arithmetizer(f);
        Cost.reset();
        try {
            System.out.println(a.processClause(expression));
        } catch (Exception e){}
        FitnessParams params = new FitnessParams();
        params.cost = Cost.read();
        params.limits = a.penaltyScores;
        return params;
    }

    private FitnessParams runCalc(CalculatorFormatter f, String expression) {
        Calculator c = new Calculator(f);
        Cost.reset();
        try {
            System.out.println(c.handleExpression(expression));
        } catch (Exception e){}
        FitnessParams params = new FitnessParams();
        params.cost = Cost.read();
        params.limits = c.penaltyScores;
        return params;
    }
}
