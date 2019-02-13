import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task2 {
    public static void main(String[] args) {
        System.out.println("������� ������� ����� ��� �������� � ��:");
        int kilo = enterMass();
        long gram = kilo * 1000;
        long milligram = gram * 10;
        float ton = (float) kilo / 100;
        System.out.println("��� ���� �����:" + kilo + "�� " + gram + "� " + milligram + "�� " + ton + "�����");
    }

    private static int enterMass() {
        int mass = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            mass = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mass;
    }
}
