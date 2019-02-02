package shankara.calc;

import com.cyberpointllc.stac.calculator.*;
import edu.utexas.stac.Cost;


public class Calc {

    public String toEU(String expression) {
        String[] units = expression.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(units[0]);
        sb.append("'");
        sb.append(units[1]);
        sb.append("\"");
        sb.append(units[2]);
        sb.append("|16");
        return sb.toString();
    }
    public FitnessParams computeExpression(CalcType type, String expression) {
        CalculatorFormatter f;
        switch (type) {
            case DIGIT: f = new LargeNumeralFormatter();
                break;
            case ROMAN: f = new RomanNumeralFormatter();
                break;
            case RISERUN: f = new UnitFormatter();
                String[] riseRun = expression.split(",");
                if (riseRun.length != 2)
                    return null;
                expression = "((" + toEU(riseRun[0]) + "^ 2|16) + (" + toEU(riseRun[1]) + "^ 2|16))r 2|16";
                break;
            case SCREEN: f = new UnitFormatter();
                String[] screen = expression.split(",");
                if (screen.length != 3)
                    return null;
                expression = "(" +toEU(screen[0]) + " * " + toEU(screen[1]) + " * " + toEU(screen[2]) + ") / 144|16";
                break;
            case CIRCLE:
                String[] circle = expression.split(",");
                String op = circle[circle.length-1];
                if (op.equals(CalcType.Circumference)) {
                    f = new UnitFormatter();
                    expression = "2|16 * " + toEU(circle[0]) + " * " + CalcType.Pi;
                } else if (op.equals(CalcType.Area)) {
                    f = new SquareUnitFormatter();
                    expression = "(" + toEU(circle[0]) + "^2|16) * " + CalcType.Pi;
                } else if (op.equals(CalcType.SurfaceArea)) {
                    f = new SquareUnitFormatter();
                    expression = "4|16 * (" + toEU(circle[0]) + "^2|16) * " + CalcType.Pi;
                } else {
                    f = new VolumeUnitFormatter();
                    expression = "4|16 * (" + toEU(circle[0]) + "^3|16) * " + CalcType.Pi + " / 3|16";
                }
                break;
                default:
                    f = new RomanNumeralFormatter();
                    break;
        }
        Calculator calc = new Calculator(f);
        Cost.reset();
        try {
            System.out.println(calc.handleExpression(expression));
        } catch (Exception e){}
        FitnessParams params = new FitnessParams();
        params.cost = Cost.read();
        params.limits = calc.penaltyScores;
        return params;
    }
}
