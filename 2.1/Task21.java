import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task21 {
    private final static double HALF = 0.5;
    private final static int ZERO = 0;
    private final static int ONE = 1;
    private final static int TWO = 2;
    private final static int THREE = 3;

    public static void main(String[] args) {
        int[][] point = massFil();
        triangleCheck(lineMeasure(point));
    }

    private static Double[] lineMeasure(int[][] point) {
        Double[] linesLength = new Double[point.length];
        for (int i = 0; i < linesLength.length; i++) {
            linesLength[i] = Math.pow(Math.pow(point[i][ZERO], TWO)
                    + Math.pow(point[i][ONE], TWO), HALF);
        }
        return linesLength;
    }

    private static int[][] massFil() {
        int[][] point = new int[THREE][TWO];
        for (int i = 0; i < THREE; i++) {
            System.out.println("Enter the first num of point " + (i + 1));
            point[i][ZERO] = enterNumber();
            System.out.println("Enter the second num of point " + (i + 1));
            point[i][ONE] = enterNumber();
        }
        return point;
    }

    private static void triangleCheck(Double[] line) {
        boolean conditionTriangle = line[ZERO] < line[ONE] + line[TWO]
                && line[ZERO] + line[ONE] > line[TWO]
                && line[ONE] < line[ZERO] + line[TWO];
        boolean conditionRightTriangle
                = line[ZERO] == Math.pow(Math.pow(line[ONE], TWO) + Math.pow(line[TWO], TWO), HALF)
                || line[ONE] == Math.pow(Math.pow(line[ZERO], TWO) + Math.pow(line[TWO], TWO), HALF)
                || line[TWO] == Math.pow(Math.pow(line[ONE], TWO) + Math.pow(line[ZERO], TWO), HALF);
        if (conditionTriangle) {
            System.out.println("Triangle is exist");
        } else if (conditionRightTriangle) {
            System.out.println("This is a right triangle");
        } else {
            System.out.println("This is not a triangle");
        }
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
