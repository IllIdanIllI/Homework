import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task1 {
    public static void main(String[] args) {
        Task1 main = new Task1();
        main.userInput();
    }

    private int enterNumber() {
        int number = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            number = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
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
