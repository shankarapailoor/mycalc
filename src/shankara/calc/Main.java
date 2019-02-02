package shankara.calc;
import shankara.calc4.Calc4Type;
import shankara.fitnessparams.FitnessParams;
import shankara.calc4.Calc4;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Calc c = new Calc();
        FitnessParams params = c.computeExpression(Calc.CalcType.CIRCLE, args[0]);
        System.out.println(params.cost);
        for (Map.Entry<String, Double> entry : params.limits.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}