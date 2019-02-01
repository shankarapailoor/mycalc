package shankara.calc;

public class Main {
    public static void main(String[] args) {
        Calc c = new Calc();
        String cost = c.computeExpression(Calc.CalcType.DIGIT, args[0]);
        System.out.println(cost);
    }
}