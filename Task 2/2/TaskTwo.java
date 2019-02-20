import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskTwo {
    private final static int TEN = 10;
    private final static int ZERO = 0;
    private static int length;
    private static String divider = "1 ";
    private static BufferedReader br;

    public static void main(String[] args) {
        try {
            System.out.println("Enter two figures\nFirst:");
            int firstFigure = enterNumber();
            System.out.println("Second:");
            int secondFigure = enterNumber();
            show(firstFigure, secondFigure);
        } catch (IOException e) {
            System.err.print(e);
        } finally {
            closeStream();
        }
    }

    private static void show(int firstFigure, int secondFigure) {
        System.out.println("Max figure is " + isMaxFigure(firstFigure));
        System.out.println(isPalindrome(firstFigure));
        System.out.println(isSimpleNum(firstFigure));
        showSimpleDivider(firstFigure);
        System.out.println("Simple dividers: " + divider);
        System.out.println("NOD: " + findNOD(firstFigure, secondFigure));
        System.out.println("NOK: " + findNOK(firstFigure, secondFigure));
        System.out.println("Different figures: " + countDiffFigure(firstFigure));
    }

    private static void closeStream() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.print(e);
        }
    }

    private static int enterNumber() throws IOException {
        int number;
        String input;
        br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        while (!isValidInput(input)) {
            System.out.println("!!!Please, enter correct number from 0 to 9!!!");
            input = br.readLine();
        }
        number = Integer.parseInt(input);

        return number;
    }

    private static boolean isValidInput(String input) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static int isMaxFigure(int number) { // 1 paragraph
        int length = 0;
        int temp;
        int max = 0;
        while (number != ZERO) {
            temp = number % TEN;
            number = number / TEN;
            if (max < temp) {
                max = temp;
            }
            length++;
        }
        TaskTwo.length = length;
        return max;
    }

    private static String isPalindrome(int number) { //2 paragraph
        int reversNumber = reverse(number);
        if (reversNumber == number) {
            return "Palindrome";
        } else {
            return "Isn't palindrome";
        }

    }

    private static int reverse(int number) { // 2 paragraph
        int reverseNum = 0;
        int i = 1;
        while (number != 0) {
            reverseNum += (number % TEN) * (int) (Math.pow(TEN, length - i));
            number = number / TEN;
            i++;
        }
        return reverseNum;
    }
    private static String isSimpleNum(int number) { // 3 paragraph
        int i = 2;
        do {
            if (number % i != 0) {
                i++;
            } else {
                return "Complicate";
            }
        } while (i != number);
        return "Simple";
    }

    private static String isSimpleDivider(int number) { // 4 paragraph
        int i = 2;
        while (i != number) {
            if (number % i != 0) {
                i++;

            } else {
                return "";
            }
        }
        return String.valueOf(i);
    }

    private static void showSimpleDivider(int number) { // 4 paragraph
        boolean is = isSimpleNum(number).equals("Complicate");
        if (is) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    divider = divider + isSimpleDivider(i) + " ";
                }
            }
        } else {
            divider += number;
        }
    }



    private static int findNOD(int numberOne, int numberTwo) { // 5 paragraph
        int minNumber = Math.min(numberOne, numberTwo);
        int maxDivider = 0;
        for (int i = 1; i <= minNumber; i++) {
            if (numberOne % i == 0 && numberTwo % i == 0) {
                maxDivider = i;
            }
        }
        return maxDivider;
    }

    private static int findNOK(int numberOne, int numberTwo) { // 5 paragraph
        int maxNumber = Math.max(numberOne, numberTwo);
        int mult = numberOne * numberTwo;
        int NOK = 0;
        boolean condition;
        do {
            condition = (mult % numberOne == 0
                    && (mult % numberTwo == 0));
            if (condition) {
                NOK = mult;
            }
            mult--;
        } while (mult != maxNumber - 1);
        return NOK;
    }

    private static int countDiffFigure(int number) { // 6 paragraph
        int counter;
        int counter1 = 0;
        int figureOne, figureTwo, tempNumber;

        cont:
        while (number != 0) {
            tempNumber = number;
            figureOne = number % TEN;
            counter = 0;
            while (tempNumber != 0) {
                figureTwo = tempNumber % TEN;
                if (figureOne == figureTwo) {
                    counter++;
                }
                if (figureOne == figureTwo && counter > 1) {
                    number /= TEN;
                    continue cont;
                }
                tempNumber /= TEN;
            }
            counter1 += counter;
            number /= TEN;

        }
        return counter1;
    }
}