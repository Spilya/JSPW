package pet.spilya.api.types;

public class SPWOwnerCard {

    private String ID;
    private String name;
    private String number;
    private int color;

    public SPWOwnerCard(String ID, String name, String number, int color) {
        this.ID = ID;
        this.name = name;
        this.number = number;
        this.color = color;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }
}
