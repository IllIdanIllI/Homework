package entity.impl;

import entity.Sweetness;

public class Candy extends Sweetness {
    private String form;

    public Candy() {
    }

    private Candy(final CandyBuilder candyBuilder) {
        super.setType(candyBuilder.getType());
        super.setName(candyBuilder.getName());
        super.setSugarValue(candyBuilder.getSugarValue());
        super.setQuantity(candyBuilder.getQuantity());
        super.setWeight(candyBuilder.getWeight());
        this.form = candyBuilder.getForm();
    }

    public String getForm() {
        return form;
    }

    @Override
    public String toString() {
        return "Candy      {"
                + "form = \"" + form + '\"' + ", "
                + super.toString();
    }

    public static class CandyBuilder {
        private String type;
        private String name;
        private short sugarValue;
        private int weight;
        private String form;
        private short quantity;

        public Candy.CandyBuilder type(final String type) {
            this.type = type;
            return this;
        }

        public Candy.CandyBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public Candy.CandyBuilder sugarValue(final short sugarValue) {
            this.sugarValue = sugarValue;
            return this;
        }

        public Candy.CandyBuilder weight(final int weight) {
            this.weight = weight;
            return this;
        }

        public Candy.CandyBuilder form(final String form) {
            this.form = form;
            return this;
        }

        public Candy.CandyBuilder quantity(final short quantity) {
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

        public Candy build() {
            return new Candy(this);
        }
    }
}
