import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskTwo {
    private final static int TEN = 10;
    private static int length;
    private static String divider = "1 ";

    public static void main(String[] args) {
        System.out.println("Enter two figures:");

//        int firstFigure = enterNumber();
//        int secondFigure = tt.enterNumber();
// перевернуть число
        System.out.println("Wax figure is " + isMaxFigure(8));
        System.out.println(isSimpleNum(8));
        System.out.println(isPalindrome(8));
        showSimpleDivider(8);
        System.out.println("Simple dividers: " + divider);
        System.out.println("NOK: "+findNOD(8, 16));
        System.out.println("NOD: "+findNOK(8, 16));
    }

    private static int enterNumber() {
        int number = 0;
        String input;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
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
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static int isMaxFigure(int number) {
        int length = 0;
        int temp;
        int max = 0;
        while (number != 0) {
            temp = number % TEN;
            number = number / 10;
            if (max < temp) {
                max = temp;
            }
            length++;
        }
        TaskTwo.length = length;
        return max;
    }

    private static String isPalindrome(int number) {
        int reversNumber = reverse(number);
        if (reversNumber == number) {
            return "Palindrome";
        } else {
            return "Isn't palindrome";
        }

    }

    private static int reverse(int number) {
        int reverseNum = 0;
        int i = 1;
        while (number != 0) {
            reverseNum += (number % TEN) * (int) (Math.pow(TEN, length - i));
            number = number / TEN;
            i++;
        }
        return reverseNum;
    }

    private static String isSimpleDivider(int number) {
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

    private static void showSimpleDivider(int number) {
        boolean is = isSimpleNum(number) == "Complicate";
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

    private static String isSimpleNum(int number) {
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

    private static int findNOD(int numberOne, int numberTwo) {
        int minNumber = Math.min(numberOne, numberTwo);
        int maxDivider = 0;
        for (int i = 1; i <= minNumber; i++) {
            if (numberOne % i == 0 && numberTwo % i == 0) {
                maxDivider = i;
            }
        }
        return maxDivider;
    }

    private static int findNOK(int numberOne, int numberTwo) {
        int maxNumber = Math.max(numberOne, numberTwo);
        boolean condition = !(maxNumber % numberOne == 0 && (maxNumber % numberTwo == 0));
        while (condition) {
            maxNumber++;
        }
        return maxNumber;
    }
}
