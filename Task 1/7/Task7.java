import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private int enterVariable() {
        int number = 0;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine();
            while(!isValidInput(input)) {
                System.out.println("!!!Please, enter correct number from 0 to 9!!!");
                input = br.readLine();
            }
            number = Integer.parseInt(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }
    private static boolean isValidInput(String input) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
