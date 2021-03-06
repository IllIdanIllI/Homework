import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Enter your number: ");
        String number = enterNumber();
        check(number);

    }

    private static void check(String number) {
        String[] temp = number.split("");
        int countUp = 0, countDown = 0;
        for (int i = 1; i < temp.length; i++) {
            if (Integer.parseInt(temp[i - 1]) < Integer.parseInt(temp[i])) {
                countUp++;
            } else if (Integer.parseInt(temp[i - 1]) > Integer.parseInt(temp[i])) {
                countDown++;
            }
        }
        if (countUp == temp.length - 1) {
            System.out.println("Increase");
        } else if (countDown == temp.length - 1) {
            System.out.println("Decrease");
        } else {
            System.out.println("There's no sequence we need");
        }
    }

    private static String enterNumber() {
        String number = "";
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine();
            while(!isValidInput(input)) {
                System.out.println("!!!Please, enter correct number from 0 to 9!!!");
                input = br.readLine();
            }
            number = input;
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
