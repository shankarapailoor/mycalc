package shankara.calc;
import shankara.fitnessparams.FitnessParams;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Calc c = new Calc();
        FitnessParams params = c.computeExpression(CalcType.CIRCLE, args[0]);
        System.out.println(params.cost);
        for (Map.Entry<String, Double> entry : params.limits.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}