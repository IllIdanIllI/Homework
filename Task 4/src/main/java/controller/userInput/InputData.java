package controller.userInput;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    private static BufferedReader br = null;
    private final static String FOR_INPUT_INT = "([1-9])([0-9]{0,8})";
    private final static String FOR_INPUT_LINE = "([a-zA-Z])+";
    private final static Logger LOGGER = Logger.getLogger(InputData.class);

    public static int enterNumber() throws IOException {
        int number;
        String input;
        br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        while (!isValidInput(input, FOR_INPUT_INT)) {
            System.out.println("!!!Please, enter correct number!!!");
            input = br.readLine();
        }
        number = Integer.parseInt(input);

        return number;
    }

    public static String enterLine() throws IOException {
        String input;
        br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        while (!isValidInput(input,FOR_INPUT_LINE)) {
            System.out.println("!!!Please, enter correct line!!!");
            input = br.readLine();
        }
        return input;
    }
    private static boolean isValidInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

   public static void closeStream() {
        try {
            br.close();
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
