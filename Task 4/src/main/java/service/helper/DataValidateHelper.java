package service.helper;

import entity.constant.ConstantRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidateHelper {

    public String isValidName(String name) {
        if (checkMatch(ConstantRegex.NAME_REGEX.get(), name)) {
            return name;
        }
        return null;
    }

    public short isValidSugarValue(String value) {
        if (checkMatch(ConstantRegex.SUGAR_VALUE_REGEX.get(), value)) {
            return Short.parseShort(value);
        }
        return 0;
    }

    public int isValidWeight(String value) {
        if (checkMatch(ConstantRegex.WEIGHT_REGEX.get(), value)) {
            return Integer.parseInt(value);
        }
        return 0;
    }

    public short isValidQuantity(String value) {
        if (checkMatch(ConstantRegex.QUANTITY_REGEX.get(), value)) {
            return Short.parseShort(value);
        }
        return 0;
    }

    public String isValidType(String type) {
        if (checkMatch(ConstantRegex.TYPE_REGEX.get(), type)) {
            return type;
        }
        return null;
    }

    public String isValidForm(String form) {
        if (checkMatch(ConstantRegex.FORM_REGEX.get(), form)) {
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
