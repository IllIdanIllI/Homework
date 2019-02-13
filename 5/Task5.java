import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("Введите число");
        int number = enterNumber();
        System.out.println("Среднее арифметическое: "+arithmeticAverage(number)
                +"\nСреднее геометрическое: "+geometricAverage(number));
    }

    private static double arithmeticAverage(int number) {
        String[] temp = String.valueOf(number).split("");
        int sum = 0;
        for (String s : temp) {
            sum += Integer.parseInt(s);
        }
        return (double) sum / temp.length;
    }

    private static double geometricAverage(int number) {
        String[] temp = String.valueOf(number).split("");
        int multiplication = 1;
        for (String s : temp) {
            multiplication*=Integer.parseInt(s);
        }
        return Math.pow(multiplication,((double)1/temp.length));
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
