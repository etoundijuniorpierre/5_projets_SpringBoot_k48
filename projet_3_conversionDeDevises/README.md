Mode d'emploi pour tester l'API Spring Boot de notre Programme de Conversion de Devises 


Prérequis :
- IDE recommandé : IntelliJ IDEA
- Outils de test : Swagger UI ou Postman
- Environnement : JDK 21 et Maven

Étapes pour lancer et tester l'API :
 **1. Configuration initiale**

 **1.1. Importation du projet**
1. Cloner le dépôt Git (si applicable)
2. Dans IntelliJ :
   - File → Open → Sélectionner le dossier du projet
   - Autoriser l'indexation automatique (≈1-2 minutes)
3. Vérifier les dépendances :
   - Maven devrait résoudre automatiquement les packages
   - Vérifier dans le panneau "Maven" (droit → Reload project)

 **2. Lancement de l'application**

 **2.1. Compilation**
```bash
mvn clean install
```
 **2.2. Exécution**
- **Via IDE** : 
  - Exécuter la classe principale `ConversionDeviseApplication`
  - Vérifier dans les logs : `Started Application in X.XX seconds`

- **Via terminal** :
  ```bash
  mvn spring-boot:run
  ```

 **3. Utilisation via Swagger UI**
 **3.1. Accès à l'interface**
```url
http://localhost:8080/swagger-ui/index.html
```
 **3.2. Test de conversion (GET)**
1. Localiser le contrôleur `ConversionController`
2. Développer l'endpoint `GET /convertDevise/convert/{from}/{to}/{amount}`
3. Cliquer sur **"Try it out"**
4. Renseigner :
   - `fromCurrency` : Code devise source (ex: EUR)
   - `toCurrency` : Code devise cible (ex: XAF)
   - `amount` : Montant à convertir (ex: 1000)
5. Exécuter ("Execute")

 **3.3. Réponse attendue**
```json
{
  "base_code": "EUR",
  "target_code": "XAF",
  "conversion_rate": 655.96,
  "amount": 1000,
  "conversion_result": 655960.00
}
```


 **4. Utilisation via Postman**

 **4.1. Collection recommandée**
1. Importer la configuration Swagger :
   ```url
   http://localhost:8080/v3/api-docs
   ```
 **4.2. Requête manuelle**
- **Méthode** : GET
- **URL** :
  ```url
  http://localhost:8080/convertDevise/convert/EUR/XAF/1000
  ```
- **Headers** :
  - `Accept: application/json`
    

Conseils :
- Vérifiez que le port 8080 est disponible
- En cas d'erreur, consultez les logs de l'application
- Pour Postman, vous pouvez importer la configuration Swagger si disponible


Exemple de corps de requête :
"http://localhost:8080/convertDevise/convert/EUR/XAF/1000"
