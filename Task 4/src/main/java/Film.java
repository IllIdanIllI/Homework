public class Film {
    private String title;
    private int price;

    public Film(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    static int compare(Film v1, Film v2) {
        if(v1.getPrice() > v2.getPrice())  return 1;
        return -1;
    }
}
