
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class ArrayTask {
    private final static Logger log = LoggerFactory.getLogger(ArrayTask.class);

    public static void main(String[] args) {
        outputInformation();
    }

    private static void outputInformation() {
        try {
            System.out.println("Enter quantity of rows: ");
            int row = DataInput.enterNumber();
            System.out.println("Enter quantity of columns: ");
            int column = DataInput.enterNumber();
            System.out.println("Enter the lowest point of array value: ");
            int lowRange = DataInput.enterNumber();
            System.out.println("Enter the highest point of array value: ");
            int highRange = DataInput.enterNumber();
            double arr[][] = new double[row][column];
            arr = fillArray(arr, lowRange, highRange);
            System.out.println("This array: \n" + showArray(arr));
            System.out.println("Max: " + isMaxValue(arr)
                    + "\nMin: " + isMinValue(arr)
                    + "\nArithmetic: " + findAvArithmetic(arr)
                    + "\nGeometric: " + findAvGeometric(arr));
            if (row < 3 || column < 3) {
                System.out.println("Local max: -1\nLocal min: -1");
            } else {
                System.out.println("Local max: " + findLocalMax(arr)
                        + "\nLocal min: " + findLocalMin(arr));
            }
            System.out.println("\nTransposition arr:\n"
                    + showArray(transposition(arr, row, column)));
            transpositionWithoutMemory(arr, row, column);
            log.info("Hi");
        } catch (IOException e) {
            log.error(String.valueOf(e));
        } catch (Exception e) {
            log.error(" Not IO error: " + String.valueOf(e));
        } finally {
            DataInput.closeStream();
        }

    }

    private static String showArray(double[][] arr) {
        StringBuilder show = new StringBuilder();
        for (double[] i : arr) {
            show.append(Arrays.toString(i)).append("\n");
        }
        return show.toString();
    }

    private static double[][] fillArray(double[][] arr, int lowRange, int highRange) {
        int localLow = (lowRange > highRange) ? highRange : lowRange;
        int localHigh = (lowRange < highRange) ? highRange : lowRange;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = fillFormatHelper(localLow, localHigh);
            }
        }
        return arr;
    }

    //method help with control number of digits in decimal numbers 
    private static double fillFormatHelper(int localLow, int localHigh) {
        Random random = new Random();
        double targetDouble;
        targetDouble = Double.parseDouble(String
                .format("%.4g%n"
                        , random.nextDouble()
                                * (localHigh - localLow) + localLow)
                .replace(",", "."));
        return targetDouble;
    }

    private static double isMaxValue(double[][] arr) {
        double maxValue = arr[0][0];
        for (double[] i : arr) {
            for (double j : i) {
                maxValue = (maxValue < j) ? j : maxValue;
            }
        }
        return maxValue;
    }

    private static double isMinValue(double[][] arr) {
        double minValue = arr[0][0];
        for (double[] i : arr) {
            for (double j : i) {
                minValue = (minValue > j) ? j : minValue;
            }
        }
        return minValue;
    }

    private static double findAvArithmetic(double[][] arr) {
        long sum = 0;
        int rowLength = arr.length, columnLength = 0;
        for (double i[] : arr) {
            columnLength = i.length;
            for (double j : i) {
                sum += j;
            }
        }
        return (double) (sum / (rowLength * columnLength));
    }

    private static double findAvGeometric(double[][] arr) {
        long multiplication = 1;
        int rowLength = arr.length, columnLength = 0;
        for (double i[] : arr) {
            columnLength = i.length;
            for (double j : i) {
                multiplication *= j;
            }
        }
        double geomValue = Math.pow(multiplication,
                (1. / columnLength * rowLength));
        geomValue = Double.parseDouble(String
                .format("%.4g%n", geomValue)
                .replace(",", "."));
        return geomValue;
    }

    private static double findLocalMax(double[][] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                boolean condition = arr[i][j] >= arr[i][j + 1]
                        && arr[i][j] >= arr[i][j - 1]
                        && arr[i][j] >= arr[i + 1][j]
                        && arr[i][j] >= arr[i - 1][j];
                if (condition) {
                    return arr[i][j];
                }
            }
        }
        return -1;
    }

    private static double findLocalMin(double[][] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                boolean condition = arr[i][j] <= arr[i][j + 1]
                        && arr[i][j] <= arr[i][j - 1]
                        && arr[i][j] <= arr[i + 1][j]
                        && arr[i][j] <= arr[i - 1][j];
                if (condition) {
                    return arr[i][j];
                }
            }
        }
        return -1;
    }

    private static double[][] transposition(double[][] arr, int row, int column) {
        double[][] transpArr = new double[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                transpArr[i][j] = arr[j][i];
            }
        }
        return transpArr;
    }

    //Output array without use extra memory 
    private static void transpositionWithoutMemory(double[][] arr, int row, int column) {
        for (int i = 0; i < column; i++) {
            System.out.print("[");
            for (int j = 0; j < row; j++) {
                if (row - 1 != j) {
                    System.out.print(arr[j][i] + ", ");
                } else
                    System.out.print(arr[j][i]);
            }
            System.out.println("]");
        }
    }
}