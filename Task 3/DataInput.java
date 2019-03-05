import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DataInput {
    private static BufferedReader br = null;
    private final static String FORINPUT = "([1-9]){1}([0-9]{0,8})";

    static int enterNumber() throws IOException {
        int number;
        String input;
        br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        while (!isValidInput(input)) {
            System.out.println("!!!Please, enter correct number!!!");
            input = br.readLine();
        }
        number = Integer.parseInt(input);

        return number;
    }

    private static boolean isValidInput(String input) {
        Pattern pattern = Pattern.compile(FORINPUT);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    static void closeStream() {
        try {
            br.close();
        } catch (IOException e) {
            System.err.print(e);
        }
    }
}
