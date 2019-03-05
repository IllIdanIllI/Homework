package entity.impl;

import entity.Sweetness;

public class Candy extends Sweetness {
    private String form;
    public Candy(){
    }
    public Candy(String type, String form) {
        this.form=form;
        super.setType(type);
    }

    public Candy(String type, String name, short sugarValue, int weight, short quantity, String form){
        super(type, name, sugarValue, weight, quantity);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    @Override
    public String toString() {
        return "Candy      {"
                + "form = \"" + form + '\"'+", "
                + super.toString();
    }


    public void setForm(String form) {
        this.form = form;
    }
}
