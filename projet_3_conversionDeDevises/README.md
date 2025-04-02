Mode d'emploi pour tester l'API Spring Boot de notre Programme de Conversion de Devises 


Prérequis :
- IDE recommandé : IntelliJ IDEA
- Outils de test : Swagger UI ou Postman
- Environnement : JDK 21 et Maven

Étapes pour lancer et tester l'API :
1. Importation du projet :
   - Ouvrir le dossier du projet dans IntelliJ IDEA
   - Laisser l'IDE configurer les dépendances automatiquement

2. Compilation et lancement :
   - Compiler le projet 
   - Lancer l'application via la classe principale (annotée `@SpringBootApplication`)

3. Accès à l'interface Swagger :
   - Ouvrir un navigateur web
   - Accéder à : `http://localhost:8080/swagger-ui/index.html`
   - Vous devriez voir la documentation interactive de l'API

4. Tester un endpoint (exemple GET) :
   a. Dans Swagger UI :
   - Trouver la section correspondant à votre contrôleur
   - Cliquer sur "GET" pour développer la section
   - Cliquer sur "Try it out"
   - Dans le corps de la requête :
     * indiquez les informations (la dévise de départ(fromCurrency), la dévise de sortie(toCurrency), la somme à convertir(amount))
   - Cliquer sur "Execute"
   - Vérifier la réponse 
   {
  "base_code": "{fromCurrency}",
  "target_code": "{toCurrency}",
  "conversion_rate": {conversion_rate},
  "amount": {amount},
  "conversion_result": {conversion_result}
    } si tout s'est bien passé

   b. Via Postman :
   - Créer une nouvelle requête GET vers `http://localhost:8080/convertDevise/convert/{fromCurrency}/{toCurrency}/{amount}`
   - Envoyer la requête et vérifier la réponse

Conseils :
- Vérifiez que le port 8080 est disponible
- En cas d'erreur, consultez les logs de l'application
- Pour Postman, vous pouvez importer la configuration Swagger si disponible


Exemple de corps de requête :
"http://localhost:8080/convertDevise/convert/EUR/XAF/1000"