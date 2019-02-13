import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task6 {
    public static void main(String []args){
        System.out.println("������� �����:");
        int number = enterNumber();
        revers(number);
    }
    private static void revers(int number){
        StringBuilder stringBuilder=new StringBuilder(String.valueOf(number));
        String reversNumber =stringBuilder.reverse().toString();
        System.out.println("����: "+number
                +"\n�����: "+reversNumber);

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
