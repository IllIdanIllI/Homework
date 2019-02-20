import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskThree {
    public static void main(String[] args)   {
        System.out.println("Enter the number: ");
        int number = enterNumber();
        System.out.println(isPerfect(number));
    }
    private static String isPerfect(int number){
        int sum=0;
        for(int i=1;i<number;i++){
            if(number % i==0){
                sum += i;
            }
        }
        return "Number "+number+" is "+ compareNum(sum,number);
    }
    private static String compareNum(int numberOne, int numberTwo){
        if(numberOne!=numberTwo){
            return "not perfect";
        }
        return "perfect";
    }
    private static int enterNumber() {
        int number = 0;
        String input;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
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
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}