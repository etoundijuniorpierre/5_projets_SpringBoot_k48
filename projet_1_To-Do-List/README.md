                              Mode d'emploi pour tester l'API Spring Boot de notre programme ToDoList


Prérequis :
- IDE recommandé : IntelliJ IDEA
- Outils de test : Swagger UI ou Postman
- Environnement : JDK et Maven
- base de donnée : Postgres(pgAdmin)

Étapes pour lancer et tester l'API :
 **1. Configuration Initiale**

 **1.1. Importation du Projet**
1. Ouvrir le projet dans IntelliJ IDEA
2. Laisser l'IDE :
   - Configurer automatiquement les dépendances Maven
   - Indexer les fichiers (peut prendre quelques minutes)

 **1.2. Configuration de la Base de Données**
**Option 1 (Recommandée)** :
```sql
CREATE DATABASE todoListeBD;
-- Puis importer le fichier .backup fourni via pgAdmin


**Option 2 (Configuration manuelle)** :
1. Créer une base PostgreSQL avec le nom de votre choix
2. Modifier `src/main/resources/application.properties` :
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/votre_nom_de_base
spring.datasource.username=postgres
spring.datasource.password=votre_mdp
spring.jpa.hibernate.ddl-auto=update
```


 **2. Lancement de l'API**
1. **Compiler** : `mvn clean install`
2. **Lancer** :
   - Via IDE : Exécuter la classe `@SpringBootApplication`
   - Via terminal : `mvn spring-boot:run`


 **3. Test via Swagger UI**

 **3.1. Accès à l'interface**
- URL : [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- Vérifier que tous les endpoints sont visibles

 **3.2. Création d'une tâche (POST)**
1. Sélectionner le contrôleur `/todos`
2. Développer `POST /todos`
3. Cliquer sur **"Try it out"**
4. Modifier le JSON :
```json
{
  "titre": "Faire les courses",
  "description": "Acheter du lait et des œufs",
  "status": "EN_COURS"
}
```
5. Cliquer sur **"Execute"**
6. Vérifier :
   - Code réponse : `201 Created`
   - Corps de réponse : `"success"` avec les détails


 **4. Test via Postman**

 **4.1. Collection recommandée**
1. Importer la collection Swagger :
   - Fichier → Import → Link
   - Coller : `http://localhost:8080/v3/api-docs`

 **4.2. Création de tâche**
1. **Méthode** : POST
2. **URL** : `http://localhost:8080/todos`
3. **Headers** :
   - `Content-Type: application/json`
4. **Body** (raw/JSON) :
```json
{
  "titre": "Réunion client",
  "description": "Préparer le dossier projet",
  "status": "A_FAIRE"
}
```



 **Conseils & Dépannage**
- Vérifiez que le port 8080 est disponible
- En cas d'erreur, consultez les logs de l'application
- Pour Postman, vous pouvez importer la configuration Swagger si disponible



 **Exemples de Requêtes**
**Pour PATCH (mise à jour)** :
```json
{
  "status": "TERMINE"
}
```

**Réponse réussie** :
```json
{
  "status": "success",
  "data": {
    "id": 1,
    "titre": "Faire les courses",
    "status": "TERMINE"
  }
}
```

**Structure complète d'une tâche** :
```json
{
  "id": 1,
  "titre": "String",
  "description": "String",
  "status": "A_FAIRE|EN_COURS|TERMINE",
}
```


Cette version apporte :
1. Une **structure visuelle claire** avec séparation des sections
2. Des **exemples complets** pour chaque cas d'usage
3. Un **tableau de dépannage** rapide
4. La **documentation des modèles** de données
5. Les **deux méthodes** (Swagger et Postman) bien distinguées

La documentation des modèles de données

Les deux méthodes (Swagger et Postman) bien distinguées

