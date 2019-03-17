package entity.impl;

import entity.Sweetness;

public class Chocolate extends Sweetness {
    private String form;
    public Chocolate() {
    }

    private Chocolate(final ChocolateBuilder chocoBuilder) {
        super.setType(chocoBuilder.getType());
        super.setName(chocoBuilder.getName());
        super.setSugarValue(chocoBuilder.getSugarValue());
        super.setQuantity(chocoBuilder.getQuantity());
        super.setWeight(chocoBuilder.getWeight());
        this.form = chocoBuilder.getForm();
    }

    public String getForm() {
        return form;
    }


    @Override
    public String toString() {
        return "Chocolate  {" +
                "form = \"" + form + '\"'+", "
                + super.toString();
    }
    public static class ChocolateBuilder {
        private String type;
        private String name;
        private short sugarValue;
        private int weight;
        private String form;
        private short quantity;

        public Chocolate.ChocolateBuilder type(final String type) {
            this.type = type;
            return this;
        }

        public Chocolate.ChocolateBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public Chocolate.ChocolateBuilder sugarValue(final short sugarValue) {
            this.sugarValue = sugarValue;
            return this;
        }

        public Chocolate.ChocolateBuilder weight(final int weight) {
            this.weight = weight;
            return this;
        }

        public Chocolate.ChocolateBuilder form(final String form) {
            this.form = form;
            return this;
        }

        public Chocolate.ChocolateBuilder quantity(final short quantity) {
            this.quantity = quantity;
            return this;
        }

        String getType() {
            return type;
        }

        String getName() {
            return name;
        }

        short getSugarValue() {
            return sugarValue;
        }

        int getWeight() {
            return weight;
        }

        String getForm() {
            return form;
        }

        short getQuantity() {
            return quantity;
        }

        public Chocolate build() {
            return new Chocolate(this);
        }
    }
}
