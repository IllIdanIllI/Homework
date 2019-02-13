import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task3 {
    public static void main(String[] args) {
        Task3 obj = new Task3();
        obj.counting();

    }
    private int enterRadius() {
        int radius = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            radius = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return radius;
    }
    private void counting() {
        System.out.println("Введите первый, больший, радиус:");
        int R1=enterRadius();
        System.out.println("Введите второй, меньший, радиус:");
        int R2=enterRadius();
        if (R1 > R2) {
            System.out.println("Площадь: " + square(R1, R2));
        } else {
            System.out.println("Не соответствует условию");
        }
    }
    private  double square(int R1, int R2) {
        double bigSquare = Math.pow(R1, 2) * Math.PI;
        double smallSquare = Math.pow(R2, 2) * Math.PI;
        return bigSquare - smallSquare;
    }
}