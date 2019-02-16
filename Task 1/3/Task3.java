import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task3 {
    public static void main(String[] args) {
        Task3 obj = new Task3();
        obj.counting();

    }

    private int enterRadius() {
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

    private void counting() {
        System.out.println("Enter the first, larger, radius:");
        int R1 = enterRadius();
        System.out.println("Enter the second, smaller, radius:");
        int R2 = enterRadius();
        if (R1 > R2) {
            System.out.println("Square: " + square(R1, R2));
        } else {
            System.out.println("Does not match the requirement");
        }
    }

    private double square(int R1, int R2) {
        double bigSquare = Math.pow(R1, 2) * Math.PI;
        double smallSquare = Math.pow(R2, 2) * Math.PI;
        return bigSquare - smallSquare;
    }
}