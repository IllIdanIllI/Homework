package entity;

public abstract class Sweetness {
    private String type;
    private String name;
    private short sugarValue;
    private int weight;

    public Sweetness() {
    }

    public Sweetness(String type, String name, short sugarValue, int weight, short quantity) {
        this.type = type;
        this.name = name;
        this.sugarValue = sugarValue;
        this.weight = weight;
        this.quantity = quantity;
    }

    private short quantity;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getSugarValue() {
        return sugarValue;
    }

    public void setSugarValue(short sugarValue) {
        this.sugarValue = sugarValue;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(byte quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "type = \"" + type + '\"' +
                ", name = \"" + name + '\"' +
                ", sugarValue = " + sugarValue +
                " picogram, weight = " + weight +
                " g, quantity = " + quantity +
                '}';
    }
    public abstract void setForm(String form);

    public abstract String getForm();
}
