import java.util.Scanner;

public class Main {

    public static final double ABSOLUTE_ZERO = -273.15;
    public static final String POSITIVE_ANS = "Y";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String ans = "Y";
        while (ans.equalsIgnoreCase(POSITIVE_ANS)) {
            System.out.println("Type your celsius temperature");
            double celsiusValue = console.nextDouble();
            if (celsiusValue > ABSOLUTE_ZERO) {
                System.out.println("Temperature now " + celsiusValue);
                System.out.println("Kelvin temperature = " +
                        new KelvinConverter().getConvertedValue(celsiusValue));
                System.out.println("Fahrenheit temperature = " +
                        new FahrenheitConverter().getConvertedValue(celsiusValue));
            }
            else {
                System.out.println("Temperature cannot be lower than absolute zero");
            }
            System.out.println("Want to continue using the converter? Type Y to continue or smth else to cancel");
            ans = console.next();
        }

    }
}