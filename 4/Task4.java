import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            number = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }
}
