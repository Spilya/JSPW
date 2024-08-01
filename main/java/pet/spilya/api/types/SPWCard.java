package pet.spilya.api.types;

import org.jetbrains.annotations.Nullable;

public class SPWCard {

    private int balance;
    private String webhook;

    public SPWCard(int balance, String webhook) {
        this.balance = balance;
        this.webhook = webhook;
    }

    public int getBalance() {
        return balance;
    }

    public String getWebhook() {
        return webhook;
    }
}
