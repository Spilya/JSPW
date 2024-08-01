package pet.spilya.api.types;

import org.json.JSONArray;
import org.json.JSONObject;
import pet.spilya.api.RequestType;
import pet.spilya.api.SPWException;
import pet.spilya.api.SPWRequests;

import java.util.ArrayList;
import java.util.Base64;

public class JSPW {

    private String BearerKey;

    public JSPW(String ID, String TOKEN) {
        String bearerKey = Base64.getEncoder().encodeToString((ID + ":" + TOKEN).getBytes());
        this.BearerKey = bearerKey;
    }

    public SPWOwner getOwner() {
        JSONObject respond = new JSONObject(SPWRequests.sendRequest("https://spworlds.ru/api/public/accounts/me",
                RequestType.GET, this.BearerKey, null));
        //Если есть город = заполнение города
        SPWOwnerCity spwOwnerCity = null;
        if (respond.get("city") == null) {
            JSONObject cityData = respond.getJSONObject("city");
            spwOwnerCity = new SPWOwnerCity(cityData.getString("id"), cityData.getString("name"),
                    cityData.getString("description"), cityData.getInt("x"), cityData.getInt("z"),
                    cityData.getBoolean("isMayor"));
        }
        //Карточки в ArrayList
        JSONArray cardsData = respond.getJSONArray("cards");
        ArrayList<SPWOwnerCard> cardsArray = new ArrayList<>();
        for (int i = 0; i < cardsData.length(); i++) {
            JSONObject cardData = cardsData.getJSONObject(i);
            cardsArray.add(new SPWOwnerCard(cardData.getString("id"), cardData.getString("name"),
                    cardData.getString("number"), cardData.getInt("color")));
        }
        //Роли в ArrayList
        JSONArray rolesJSONArray = respond.getJSONArray("roles");
        ArrayList<String> roles = new ArrayList<>();
        for (int i = 0; i < rolesJSONArray.length(); i++) {
            roles.add(rolesJSONArray.getString(i));
        }
        //Финальный return
        return new SPWOwner(respond.getString("id"), respond.getString("username"),
                respond.getString("minecraftUUID"), respond.getString("status"), roles, spwOwnerCity,
                cardsArray, respond.getString("createdAt"));
    }


    public SPWUser getUser(String discordID) throws SPWException {
        JSONObject respond = new JSONObject(SPWRequests.sendRequest("https://spworlds.ru/api/public/users/" + discordID, RequestType.GET, this.BearerKey, null));
        if (!(respond.getString("username") == null)) {
            return new SPWUser(respond.getString("username"), respond.getString("uuid"), this.BearerKey);
        } else throw new SPWException("Пользователь не не найден");
    }



    public ArrayList<SPWUserCard> getUserCards(String username) {
        return new SPWUser(username, null, this.BearerKey).getCards();
    }


    public SPWCard getThisCard() {
        JSONObject respond = new JSONObject(SPWRequests.sendRequest("https://spworlds.ru/api/public/card", RequestType.GET, this.BearerKey, null));
        return new SPWCard(Integer.parseInt(respond.get("balance").toString()), respond.get("webhook").toString());
    }

    public String createPaymentLink(SPWPayment spwPayment) {
        JSONObject respond = new JSONObject(SPWRequests.sendRequest("https://spworlds.ru/api/public/payments", RequestType.POST, this.BearerKey, spwPayment.getJSON()));
        return respond.getString("url");
    }


    public void changeThisCardWebHook(String url) {
        SPWRequests.sendRequest("https://spworlds.ru/api/public/card/webhook", RequestType.PUT, this.BearerKey, "{ \"url\": \"" + url + "\" }");
    }


    public int doTransactions(SPWTransaction spwTransaction) {
        JSONObject respond = new JSONObject(SPWRequests.sendRequest("https://spworlds.ru/api/public/transactions", RequestType.POST, this.BearerKey, spwTransaction.getJSON()));
        return respond.getInt("balance");
    }
}