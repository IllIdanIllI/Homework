import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task1 {
    public static void main(String[] args) {
        Task1 main = new Task1();
        main.userInput();
    }

    private int enterNumber() {
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
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private void userInput() {
        System.out.println("Enter the first number: ");
        int numberOne = enterNumber();
        System.out.println("Enter the second number: ");
        int numberTwo = enterNumber();
        System.out.println("Enter the third number: ");
        int numberThree = enterNumber();
        comparison(numberOne, numberTwo, numberThree);
    }

    private void comparison(int numberOne, int numberTwo, int numberThree) {

        if (numberOne == numberTwo && numberThree == numberTwo) {
            System.out.println("All numbers are the same");
        } else if (numberOne != numberTwo && numberThree != numberTwo && numberOne != numberThree) {
            System.out.println("All numbers arent the same");
        } else {
            System.out.println("Some numbers are the same");
        }
    }
}
