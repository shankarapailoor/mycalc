package shankara.calc4;

import com.cyberpointllc.stac.arithmetizer.Arithmetizer;
import com.cyberpointllc.stac.arithmetizer.ArithmetizerFormatter;
import com.cyberpointllc.stac.arithmetizer.BigNumberFormatter;
import com.cyberpointllc.stac.arithmetizer.RomanNumeralFormatter;

import java.util.Map;
import edu.utexas.stac.Cost;
import shankara.fitnessparams.FitnessParams;


public class Calc4 {
    enum CalcType {
        DIGIT, ROMAN
    }
    public FitnessParams computeExpression(CalcType type, String expression) {
        ArithmetizerFormatter f;
        switch (type) {
            case DIGIT: f = new BigNumberFormatter();
                break;
            case ROMAN: f = new RomanNumeralFormatter();
                break;
            default:
                f = new RomanNumeralFormatter();
                break;
        }
        Arithmetizer calc = new Arithmetizer(f);
        //Cost.reset();
        try {
            calc.processClause(expression);
        } catch (Exception e){}
        FitnessParams params = new FitnessParams();
        params.cost = Cost.read();
        params.limits = calc.penaltyScores;
        return params;
    }
}
