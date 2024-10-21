## Velociraptor API

In diesem Repository liegt die API des neuen [Velociraptor NG](https://byteandbit.store/shop/category/velociraptor) vom
ByteAndBit Studio.

**Bitte beachte: Die API ist aktuell noch in der Betaphase. Bei Problemen oder Fragen melde dich bitte bei uns
im [Discord](https://discord.com/invite/tSvGXeN).**

### Nutzungshinweis und Lizenz

Die Nutzung der API erfolgt auf eigene Gefahr!
Wir haften nicht für Probleme, Fehler oder sonstige Aktionen, die im Zusammenhang mit der Nutzung der API auftreten.

Solltest du nicht wissen, was du tust, benutze bitte nicht die API!

Die API ist unter der [MIT Lizenz](https://github.com/ByteAndBit-Studio/Velociraptor-API/blob/master/LICENSE) veröffentlicht.

### Dokumentation

Jede Klasse ist ausführlich mit JavaDoc beschrieben. 
Die JavaDoc findest du [hier](https://javadocs.velociraptor-bot.de/).

Solltest du Probleme oder zusätzliche Fragen zur Benutzung haben
kannst du dich bei uns im [Discord](https://discord.com/invite/tSvGXeN) melden!

### Einbindung der API

Bitte lade aus dem [Releases](https://github.com/ByteAndBit-Studio/Velociraptor-API/releases) die aktuellste
Velociraptor API Version herunter und binde diese anschließend ein. Per Gradle funktioniert dies beispielsweise
folgendermaßen:

Wir gehen davon aus, dass du einen libs Unterordner erstellt hast und dorthin deine Velociraptor-API-bXX.jar kopiert
hast.

```
dependencies {
    compileOnly fileTree(dir: 'libs', include: ['*.jar'])
}
```

Hier findest du ein Beispiel, wie man die API in sein LabyMod Plugin / Forge Mod / usw. einbinden kann.

```java
public class MeineHauptklasse {
    public static VelociraptorAPI velociraptorAPI;

    public void onEnable() {
        new Thread(() -> {
            try {
                Thread.sleep(10000);
                boolean foundApi = false;

                while (!foundApi) {
                    System.out.println("SUCHE VELOCIRAPTOR API.....");

                    try {
                        Class.forName("de.byteandbit.velociraptor.api.VelociraptorAPI");
                        foundApi = true;
                    } catch (Exception ex) {
                    }
                    Thread.sleep(1000L);
                }

                velociraptorAPI = new VelociraptorAPI();
                System.out.println("Velociraptor NG API wurde erfolgreich eingebunden!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
```

© ByteAndBit Studio UG (haftungsbeschränkt) 2021-2024
