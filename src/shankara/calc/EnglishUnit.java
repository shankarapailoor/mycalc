package shankara.calc;

public class EnglishUnit {
    public String feet;
    public String inches;
    public String sixteenths;
    public static String PI = "355|16 / 113|16";

    public EnglishUnit(String feet, String inches, String sixteenths) {
        this.feet = feet;
        this.inches = inches;
        this.sixteenths = sixteenths;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.feet);
        sb.append("'");
        sb.append(this.inches);
        sb.append("\"");
        sb.append(this.sixteenths);
        sb.append("|16");
        return sb.toString();
    }
}
