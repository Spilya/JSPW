package pet.spilya.api.types;

public class SPWOwnerCity {

    private String ID;
    private String name;
    private String description;
    private int X;
    private int Z;
    private boolean isMayor;

    public SPWOwnerCity(String ID, String name, String description, int x, int z, boolean isMayor) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.X = x;
        this.Z = z;
        this.isMayor = isMayor;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getX() {
        return X;
    }

    public int getZ() {
        return Z;
    }

    public boolean isMayor() {
        return isMayor;
    }
}
