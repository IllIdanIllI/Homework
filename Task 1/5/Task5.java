import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        int number = enterNumber();
        System.out.println("The arithmetic mean: "+arithmeticAverage(number)
                +"\nThe geometric mean: "+geometricAverage(number));
    }

    private static double arithmeticAverage(int number) {
        String[] temp = String.valueOf(number).split("");
        int sum = 0;
        for (String s : temp) {
            sum += Integer.parseInt(s);
        }
        return (double) sum / temp.length;
    }

    private static double geometricAverage(int number) {
        String[] temp = String.valueOf(number).split("");
        int multiplication = 1;
        for (String s : temp) {
            multiplication*=Integer.parseInt(s);
        }
        return Math.pow(multiplication,((double)1/temp.length));
    }
    private static int enterNumber() {
        int number = 0;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine();
            while(!isValidInput(input)) {
                System.out.println("!!!Please, enter correct number from 0 to 9!!!");
                input = br.readLine();
            }
            number = Integer.parseInt(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }
    private static boolean isValidInput(String input) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
