import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task7 {
    public static void main(String[] args) {
        System.out.println("Enter the first variable: ");
        int firstVariable = enterVariable();
        System.out.println("Enter the second variable: ");
        int secondVariable = enterVariable();
        changePosition(firstVariable,secondVariable);
    }
    private static void changePosition(int firstVariable,int secondVariable){
        System.out.println("First variable: "+firstVariable
                +"\nSecond variable: "+secondVariable+"\n");
        firstVariable=firstVariable+secondVariable;
        secondVariable = firstVariable-secondVariable;
        firstVariable=firstVariable-secondVariable;
        System.out.println("First variable: "+firstVariable
                +"\nSecond variable: "+secondVariable);
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
