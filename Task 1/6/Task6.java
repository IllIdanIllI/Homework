import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int number = enterNumber();
        revers(number);
    }

    private static void revers(int number) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(number));
        String reversNumber = stringBuilder.reverse().toString();
        System.out.println("Was: " + number
                + "\nBecome: " + reversNumber);

    }

    private int enterNumber() {
        int number = 0;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine();
            while (!isValidInput(input)) {
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
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
