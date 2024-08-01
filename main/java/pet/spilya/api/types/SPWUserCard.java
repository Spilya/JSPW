package pet.spilya.api.types;

public class SPWUserCard {
    private String number;
    private String name;

    public SPWUserCard(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
