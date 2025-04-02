Mode d'emploi pour tester l'API Spring Boot de notre Programme de Gestion des utilisateurs


Prérequis :
- IDE recommandé : IntelliJ IDEA
- Outils de test : Swagger UI ou Postman
- Environnement : JDK et Maven

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

4. Tester un endpoint (exemple DELETE) :
   a. Dans Swagger UI :
   - Trouver la section correspondant à votre contrôleur
   - Cliquer sur "DELETE" pour développer la section
   - Cliquer sur "Try it out"
   - Dans le corps de la requête :
     * indiquez le nom de l'utilisateur à supprimer (faudrait au préalable déjà avoir des données entrées)
   - Cliquer sur "Execute"
   - Vérifier la réponse 
   {
  "utilisateur : ": "utilisateurNom",
  "message": "supprimé avec succès"
    } si tout s'est bien passé

   b. Via Postman :
   - Créer une nouvelle requête DELETE vers `http://localhost:8080/deleteOneUtilisateur/{nom}`
   - Envoyer la requête et vérifier la réponse

Conseils :
- Vérifiez que le port 8080 est disponible
- En cas d'erreur, consultez les logs de l'application
- Pour Postman, vous pouvez importer la configuration Swagger si disponible



