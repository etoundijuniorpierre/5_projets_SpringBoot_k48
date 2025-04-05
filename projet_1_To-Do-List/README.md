                              Mode d'emploi pour tester l'API Spring Boot de notre programme ToDoList


Prérequis :
- IDE recommandé : IntelliJ IDEA
- Outils de test : Swagger UI ou Postman
- Environnement : JDK et Maven
- base de donnée : Postgres(pgAdmin)

Étapes pour lancer et tester l'API :
1. Importation du projet :
   - Ouvrir le dossier du projet dans IntelliJ IDEA
   - Laisser l'IDE configurer les dépendances automatiquement

2. création de la base de donnée : 
   - Créer une base PostgreSQL nommée todoListeBD via pgAdmin ou exporter la base de donnée fournie
   - vous pouvez aussi aussi créer une base de donnée avec un autre nom suffira juste de modifier les informations de "application.properties" pour les adapter aux votres

3. Compilation et lancement :
   - Compiler le projet 
   - Lancer l'application via la classe principale (annotée `@SpringBootApplication`)

4. Accès à l'interface Swagger :
   - Ouvrir un navigateur web
   - Accéder à : `http://localhost:8080/swagger-ui/index.html`
   - Vous devriez voir la documentation interactive de l'API

5. Tester un endpoint (exemple POST) :
   a. Dans Swagger UI :
   - Trouver la section correspondant à votre contrôleur
   - Cliquer sur "POST" pour développer la section
   - Cliquer sur "Try it out"
   - Dans le corps de la requête :
     * Remplacer le contenu exemple par vos données
     * Supprimer l'id (généré automatiquement)
     * Renseigner les champs obligatoires (titre, description, status)
   - Cliquer sur "Execute"
   - Vérifier la réponse "success" si tout s'est bien passé

   b. Via Postman :
   - Créer une nouvelle requête POST vers `http://localhost:8080/[votre-endpoint]`
   - Dans l'onglet "Body", sélectionner "raw" et "JSON"
   - Saisir votre objet JSON (sans l'id)
   - Envoyer la requête et vérifier la réponse

Conseils :
- Vérifiez que le port 8080 est disponible
- En cas d'erreur, consultez les logs de l'application
- Pour Postman, vous pouvez importer la configuration Swagger si disponible

Exemple de corps de requête JSON :
```json
{
  "titre": "Exemple de titre",
  "description": "Description test",
  "status": "ACTIF"
}
```


