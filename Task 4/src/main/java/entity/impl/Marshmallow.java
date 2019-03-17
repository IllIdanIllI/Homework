package entity.impl;

import entity.Sweetness;

public class Marshmallow extends Sweetness {
    private String form;

    public Marshmallow() {
    }

    private Marshmallow(final MarshmallowBuilder mBuilder) {
        super.setType(mBuilder.getType());
        super.setName(mBuilder.getName());
        super.setSugarValue(mBuilder.getSugarValue());
        super.setQuantity(mBuilder.getQuantity());
        super.setWeight(mBuilder.getWeight());
        this.form = mBuilder.getForm();
    }

    public String getForm() {
        return form;
    }


    @Override
    public String toString() {
        return "Marshmallow{" +
                "form = \"" + form + '\"' +
                ", " + super.toString();
    }

    public static class MarshmallowBuilder {
        private String type;
        private String name;
        private short sugarValue;
        private int weight;
        private String form;
        private short quantity;

        public MarshmallowBuilder type(final String type) {
            this.type = type;
            return this;
        }

        public MarshmallowBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public MarshmallowBuilder sugarValue(final short sugarValue) {
            this.sugarValue = sugarValue;
            return this;
        }

        public MarshmallowBuilder weight(final int weight) {
            this.weight = weight;
            return this;
        }

        public MarshmallowBuilder form(final String form) {
            this.form = form;
            return this;
        }

        public MarshmallowBuilder quantity(final short quantity) {
            this.quantity = quantity;
            return this;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public short getSugarValue() {
            return sugarValue;
        }

        public int getWeight() {
            return weight;
        }

        public String getForm() {
            return form;
        }

        public short getQuantity() {
            return quantity;
        }

        public Marshmallow build(){
            return new Marshmallow(this);
        }
    }
}
