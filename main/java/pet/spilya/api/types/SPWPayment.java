package pet.spilya.api.types;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class SPWPayment {
    private ArrayList<SPWItem> items;
    private String redirectUrl;
    private String webhookUrl;
    private String data;

    public SPWPayment(ArrayList<SPWItem> items, String redirectUrl, String webhookUrl, String data) {
        this.items = items;
        this.redirectUrl = redirectUrl;
        this.webhookUrl = webhookUrl;
        this.data = data;
    }

    protected String getJSON() {
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(this));
        return gson.toJson(this);
    }
}
