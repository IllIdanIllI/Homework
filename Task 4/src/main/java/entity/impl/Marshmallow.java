package entity.impl;

import entity.Sweetness;

public class Marshmallow extends Sweetness {
    private String form;

    public Marshmallow() {
    }

    public Marshmallow(String type, String form) {
        this.form = form;
        super.setType(type);
    }


    public Marshmallow(String type, String name, short sugarValue, int weight, short quantity, String form) {
        super(type, name, sugarValue, weight, quantity);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "Marshmallow{" +
                "form = \"" + form + '\"' +
                ", " + super.toString();
    }
}
