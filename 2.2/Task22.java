import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task22 {
    public static void main(String[] args) {
        System.out.println("Enter at how many years the Dragon looks like: ");
        int year = enterNumber();
        counter(year);
    }

    private static void counter(int yearQuantity) {
        int headQuantity = 3;
        if (isBetween(yearQuantity, 0, 200)) {
            System.out.println("The Dragon grown heads: "
                    + yangDragon(headQuantity, yearQuantity));
        } else if (isBetween(yearQuantity, 200, 300)) {
            System.out.println("The Dragon grown heads: "
                    + middleDragon(headQuantity, yearQuantity));
        } else if (yearQuantity > 300) {
            System.out.println("The Dragon grown heads: "
                    + oldDragon(headQuantity, yearQuantity));
        } else {
            System.out.println("Before the birth of the Dragon lefts: "
                    + Math.abs(yearQuantity) + " years");
        }
    }

    private static int yangDragon(int headQuantity, int yearQuantity) {
        for (int i = 0; i < yearQuantity; i++) {
            headQuantity += 3;
        }
        return headQuantity;
    }

    private static int middleDragon(int headQuantity, int yearQuantity) {
        for (int i = 0; i < 200; i++) {
            headQuantity += 3;
        }
        for (int i = 200; i < yearQuantity; i++) {
            headQuantity += 2;
        }
        return headQuantity;
    }

    private static int oldDragon(int headQuantity, int yearQuantity) {
        for (int i = 0; i < 200; i++) {
            headQuantity += 3;
        }
        for (int i = 200; i < 300; i++) {
            headQuantity += 2;
        }
        for (int i = 300; i < yearQuantity; i++) {
            headQuantity += 1;
        }
        return headQuantity;
    }

    private static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
    private static int enterNumber() {
        int number = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            number = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }
}
