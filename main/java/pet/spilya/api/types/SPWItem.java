package pet.spilya.api.types;

public class SPWItem {
    private String name;
    private int count;
    private int price;
    private String comment;

    public SPWItem(String name, String description, int price, int count) {
        this.comment = description;
        this.price = price;
        this.count = count;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }
}
