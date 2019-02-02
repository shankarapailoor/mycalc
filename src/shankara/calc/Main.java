package shankara.calc;

public class Main {
    public static void main(String[] args) {
        Calc c = new Calc();
        c.calc4 = false;
        EnglishUnit rise = new EnglishUnit("0", "0", "1+0");
        c.CalculateRise(rise, rise);
        c.CalculateArea(rise);
        c.CalculateDigit("1+2");
        c.CalculateRoman("M+X");
        c.CalculateVolume(rise);
        c.calc4 = true;
        c.CalculateRise(rise, rise);
        c.CalculateArea(rise);
        c.CalculateDigit("1+2");
        c.CalculateRoman("M+X");
        c.CalculateVolume(rise);
    }
}