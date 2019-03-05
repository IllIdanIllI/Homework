package entity.impl;

import entity.Sweetness;

public class Chocolate extends Sweetness {
    private String form;
    public Chocolate() {
    }
    public Chocolate(String type, String form) {
        this.form=form;
        super.setType(type);
    }

    public Chocolate(String type, String name, short sugarValue, int weight, short quantity, String form) {
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
        return "Chocolate  {" +
                "form = \"" + form + '\"'+", "
                + super.toString();
    }
}
