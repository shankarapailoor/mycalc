package org.shankara.Calc;

public class Main {
    public static void main(String[] args) {
        Calc c = new Calc();
        long cost = c.computeExpression(args[0]);
        System.out.println(cost);
    }
}