package shankara.calc;

public class Main {
    public static void main(String[] args) {
        Calc c = new Calc();
        long cost = c.computeExpression(Calc.CalcType.ROMAN, args[0]);
        System.out.println(cost);
    }
}