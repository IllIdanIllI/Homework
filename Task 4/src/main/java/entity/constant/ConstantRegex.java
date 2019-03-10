package entity.constant;

public enum ConstantRegex {
    SUGAR_VALUE_REGEX("[0-9]{1,3}"),
    WEIGHT_REGEX("[0-9]{1,4}"),
    NAME_REGEX("(.){3,}"),
    QUANTITY_REGEX("[0-9]{1,3}"),
    TYPE_REGEX("[a-zA-Z]{3,}"),
    FORM_REGEX("[a-zA-Z]{3,}");

    private String param;

    ConstantRegex(String param) {
        this.param = param;
    }

    public String get() {
        return param;
    }
}
