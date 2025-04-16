Mode d'emploi pour tester l'API Spring Boot de notre Programme de Gestion des utilisateurs


Prérequis :
- IDE recommandé : IntelliJ IDEA
- Outils de test : Swagger UI ou Postman
- Environnement : JDK et Maven

Étapes pour lancer et tester l'API :
1. Importation du projet :
   - Ouvrir le dossier du projet dans IntelliJ IDEA
   - Laisser l'IDE configurer les dépendances automatiquement

2. création de la base de donnée : 
   - Créer une base PostgreSQL nommée "userDataBase" via pgAdmin ensuite faite un backup de la base de donnée se touvant dans le dossier database (".backup" de préférence si pgAdmin utilisé)
   - vous pouvez aussi aussi créer une base de donnée avec un autre nom suffira juste de modifier les informations de "application.properties" pour les adapter aux votres

3. Compilation et lancement :
   - Compiler le projet 
   - Lancer l'application via la classe principale (annotée `@SpringBootApplication`)

4. Tester un endpoint (exemple DELETE) :
   a. Via Postman :
   - premèrement se login avec son email et son password
     exemple requête Json :
           {
           "password": "password",
           "email": "email"
            }
   - récupérer le token fourni et l'insèrer dans l'onglet Auth -> Type -> Bearer Token  
   - Créer une nouvelle requête DELETE vers `http://localhost:8080/deleteOneUtilisateur/{nom}`
   - Envoyer la requête et vérifier la réponse

Conseils :
- Vérifiez que le port 8080 est disponible
- En cas d'erreur, consultez les logs de l'application
- Pour Postman, vous pouvez importer la configuration Swagger si disponible







