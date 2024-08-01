### Установка

#### Maven:
```xml
<dependency>
  <groupId>pet.spilya</groupId>
  <artifactId>JSPW</artifactId>
  <version>1.0</version>
</dependency>
```


#### Gradle:
```xml
implementation group: 'pet.spilya', name: 'JSPW', version: '1.0'
```

### Использование
#### Основное
```java
JSPW api = new JSPW("ID", "TOKEN");

SPWCard spwCard = api.getThisCard(); // Получение карточки
spwCard.getBalance();                // Получение баланса карточки
spwCard.getWebhook();                // Получение веюхука

SPWOwner spwOwner = api.getOwner(); // Получение владельца карты
spwOwner.getCards();                // Получения списка карточек владельца
spwOwner.getCity();                 // Получение города владельца
//... И всякое другое, полная документация в процессе создания

SPWUser spwUser = api.getUser("DISCORD_ID"); // Получение пользователя
spwUser.getCards();                  // Получение карточек пользователя
spwUser.getUsername();               // Ник пользователя
spwUser.getUuid();                   // Minecraft UUID пользователя
```

#### Перевод
```java
JSPW api = new JSPW("ID", "TONEN");

        SPWTransaction spwTransaction =new SPWTransaction("CARD_NUMBER", AMOUNT, "Comment");
        api.doTransactions(SPWTransaction)
```

#### Создание ссылки для оплаты
```java
JSPW api = new JSPW("ID", "TONEN");
        //Создание списка предметов
        SPWItem spwItem1 = new SPWItem("Товар 1", "Описание", PRICE, COUNT);
        SPWItem spwItem2 = new SPWItem("Товар 2", "Описание", PRICE, COUNT);
        ArrayList<SPWItem> spwItems = new ArrayList<>();
        spwItems.add(spwItem1);
        spwItems.add(spwItem2);
        //Создание оплаты
        SPWPayment spwPayment = new SPWPayment(spwItems, "redirectUrl", "webhookUrl", "data");
        //Получение ссылки
        api.createPaymentLink(spwPayment);
```


Если будут багулины дс - spilya
