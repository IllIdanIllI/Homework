package service.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidateHelper {

    public String isValidName(String name) {
        if (checkMatch("(.){3,}", name)) {
            return name;
        }
        return null;
    }

    public short isValidSugarValue(String value) {
        if (checkMatch("[0-9]+", value)) {
            return Short.parseShort(value);
        }
        return 0;
    }

    public int isValidWeight(String value) {
        if (checkMatch("[0-9]+", value)) {
            return Integer.parseInt(value);
        }
        return 0;
    }

    public short isValidQuantity(String value) {
        if (checkMatch("[0-9]+", value)) {
            return Short.parseShort(value);
        }
        return 0;
    }

    public String isValidType(String type) {
        if (checkMatch("[a-zA-Z]{3,}", type)) {
            return type;
        }
        return null;
    }

    public String isValidForm(String form) {
        if (checkMatch("[a-zA-Z]{3,}", form)) {
            return form;
        }
        return null;
    }
    public boolean conditionForSend(String type, String name,
                                    short sugarValue, int weight,
                                    short quantity,  String form){
        return name != null && type != null
                && sugarValue > 0 && weight > 0
                && quantity > 0 && form != null;
    }

    private boolean checkMatch(String regex, String item) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(item);
        return matcher.matches();
    }
}
