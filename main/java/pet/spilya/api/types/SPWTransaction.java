package pet.spilya.api.types;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SPWTransaction {

    private String receiver;
    private int amount;
    private String comment;

    public SPWTransaction(String receiver, int amount, String comment) {
        this.receiver = receiver;
        this.amount = amount;
        this.comment = comment;
    }

    protected String getJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
