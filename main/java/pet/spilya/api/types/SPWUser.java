package pet.spilya.api.types;

import org.json.JSONArray;
import org.json.JSONObject;
import pet.spilya.api.SPWRequests;
import pet.spilya.api.RequestType;

import java.util.ArrayList;

public class SPWUser {

    private String username;
    private String uuid;
    private String bearerkey;

    public SPWUser(String username, String uuid, String bearerkey) {
        this.username = username;
        this.uuid = uuid;
        this.bearerkey = bearerkey;
    }

    public String getUsername() {
        return username;
    }

    public String getUuid() {
        return uuid;
    }

    public ArrayList<SPWUserCard> getCards() {
        JSONObject respond = new JSONObject("{cards: " + SPWRequests.sendRequest("https://spworlds.ru/api/public/accounts/" + this.username + "/cards", RequestType.GET, this.bearerkey, null) + "}");
        JSONArray cards = respond.getJSONArray("cards");
        ArrayList<SPWUserCard> list = new ArrayList<>();
        for (int i = 0; i < cards.length(); i++) {
            JSONObject card = cards.getJSONObject(i);
            SPWUserCard spwUserCard = new SPWUserCard(card.getString("number"), card.getString("name"));
            list.add(spwUserCard);
        }
        return list;
    }
}
