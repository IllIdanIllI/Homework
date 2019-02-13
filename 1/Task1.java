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
        System.out.println("������� ������ �����: ");
        int numberOne = enterNumber();
        System.out.println("������� ������ �����: ");
        int numberTwo = enterNumber();
        System.out.println("������� ������ �����: ");
        int numberThree = enterNumber();
        comparison(numberOne, numberTwo, numberThree);
    }

    private void comparison(int numberOne, int numberTwo, int numberThree) {

        if (numberOne == numberTwo && numberThree == numberTwo) {
            System.out.println("��� �����");
        } else if (numberOne != numberTwo && numberThree != numberTwo && numberOne != numberThree) {
            System.out.println("��� �� �����");
        } else {
            System.out.println("���-�� �����");
        }
    }
}
