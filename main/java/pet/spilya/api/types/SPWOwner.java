package pet.spilya.api.types;

import pet.spilya.api.SPWException;

import java.util.ArrayList;

public class SPWOwner {

    private String ID;
    private String username;
    private String minecraftUUID;
    private String status;
    private ArrayList<String> roles;
    private SPWOwnerCity city;
    private ArrayList<SPWOwnerCard> cards;
    private String createdAt;

    public SPWOwner(String ID, String username, String minecraftUUID, String status, ArrayList<String> roles, SPWOwnerCity city, ArrayList<SPWOwnerCard> cards, String createdAt) {
        this.ID = ID;
        this.username = username;
        this.minecraftUUID = minecraftUUID;
        this.status = status;
        this.roles = roles;
        this.city = city;
        this.cards = cards;
        this.createdAt = createdAt;
    }

    public String getID() {
        if (ID == null) {
            throw new NullPointerException();
        } else return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getMinecraftUUID() {
        return minecraftUUID;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public SPWOwnerCity getCity() throws SPWException {
        if (city == null) {
            throw new SPWException("City is null");
        }
        return city;
    }

    public ArrayList<SPWOwnerCard> getCards() {
        return cards;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
