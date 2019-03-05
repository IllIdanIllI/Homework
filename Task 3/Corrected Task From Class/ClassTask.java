import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassTask {
    private final static String FORINPUT = "(([1-9]){1}([0-9]){1,7})|(([2-9]){1}([0-9]{0,7}))";
    private final static int ELEVEN = 11;
    private final static int TEN = 10;
    private final static int EIGHT = 8;
    private final static int SIX = 6;
    private final static int ZERO = 0;
    private static int quantityNum = 0;

    public static void main(String[] args) {
        System.out.println("Input your range: ");
        int quantity = enterNumber();
        int arr[] = new int[quantity];
        fillArray(arr);
        System.out.println(Arrays.toString(arr));
        sortToTask(arr);
//        fillNewArray(arr,newArr);
        System.out.println(Arrays.toString(arr));
    }

    private static void fillArray(int[] arr) {
        Random random = new Random();
        for (int i = ZERO; i < arr.length; i++) {
            arr[i] = random.nextInt(ELEVEN);
        }
    }

    private static void sortToTaskLoop(int[] arrOne, int num) {
        int temp;
        for (int i = 0; i < arrOne.length; i++) {
            if (arrOne[i] == num && i != quantityNum) {
                temp = arrOne[i];
                arrOne[i] = arrOne[quantityNum];
                arrOne[quantityNum] = temp;
                quantityNum++;
            }
        }
    }

    private static void sortToTask(int[] arr) {
        sortToTaskLoop(arr, TEN);
        sortToTaskLoop(arr, EIGHT);
        sortToTaskLoop(arr, SIX);
    }


    private static int enterNumber() {
        int number;
        String input;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
            while (!isValidInput(input)) {
                System.out.println("!!!Please, enter correct number!!!");
                input = br.readLine();
            }
            number = Integer.parseInt(input);
            return number;
        } catch (IOException e) {
            System.err.print(e);
        }
        return ZERO;
    }

    private static boolean isValidInput(String input) {
        Pattern pattern = Pattern.compile(FORINPUT);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
