import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task7 {
    public static void main(String[] args) {
        System.out.println("Введите первую переменную: ");
        int firstVariable = enterVariable();
        System.out.println("Введите первую переменную: ");
        int secondVariable = enterVariable();
        changePosition(firstVariable,secondVariable);
    }
    private static void changePosition(int firstVariable,int secondVariable){
        System.out.println("Первая переменная: "+firstVariable
                +"\nВторая переменная: "+secondVariable+"\n");
        firstVariable=firstVariable+secondVariable;
        secondVariable = firstVariable-secondVariable;
        firstVariable=firstVariable-secondVariable;
        System.out.println("Первая переменная: "+firstVariable
                +"\nВторая переменная: "+secondVariable);
    }
    private static int enterVariable() {
        int variable = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            variable = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return variable;
    }
}
