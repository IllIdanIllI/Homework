import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task2 {
    public static void main(String[] args) {
        System.out.println("Enter how much your dinosaur weighs in kg:");
        int kilo = enterMass();
        long gram = kilo * 1000;
        long milligram = gram * 10;
        float ton = (float) kilo / 100;
        System.out.println("Our Dino weighs:" + kilo + "kg " + gram + "g " + milligram + "mg " + ton + "ton");
    }

    private int enterMass() {
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
