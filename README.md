# mon_dashboard_meteo
Projet 2020 - Mon dashboard météo

- Gomes Nicolas
- Elimane Sene
- François Godin
- Daouda Fofana

## API utilisées
https://geo.api.gouv.fr/decoupage-administratif
https://api.meteo-concept.com/

## Scalingo
https://my.osc-fr1.scalingo.com/apps/mon-dashboard-meteo/code

## Aspect fonctionnel
Les utilisateurs ont un profil avec dedans :
- Des villes favorites
- Moyen de transport
- Des paramètres d’alertes comme :
    - Mail le matin avant de sortir
    - Mail en journée en cas de changement
    - Mail en fonction des jours sélectionnés
    - Mail avec les détails des villes
- Moyenne de température
- Meilleure ville par température
- Type de prévision (alerte), semaine, jour, mois
- Profile de la personne, frileux ou non
- Information sur les événements, soleil, neige, pluie + température
- Proposer des activités en fonction de la température (Optionnel)


## Conventions et normes
-	**Tout le code est en anglais**

-   **Classes**, **Interfaces**
    - Première lettre en majuscule
    - Pas de « s » en fin classe.
    ```
    User
    Dog
    ImageMainWindow
    ```
                
-	**Methods**
    - Un verbe de préférence
    - Première lettre minuscule puis chaque première lettre des mots en majuscule.
    ```
    run();
    runFast();
    getBackground() ;
    ```
                
-   **Variables**
    - Première lettre minuscule puis chaque première lettre des mots en majuscule
    - Pas de « _ » ou « $ » en debut.
    ```
    int i;
    char c;
    float myWidth;
    ```
                
-	**Constants**
    - Tout en majuscule
    - Mots séparer par « _ ».
    ```
    static final MIN_WIDTH = 4;
    ```
                
-   **Packages**
    - Tout en minuscule.
    ```
    com.sun.eng
    com.app.quicktime.v2
    ```
