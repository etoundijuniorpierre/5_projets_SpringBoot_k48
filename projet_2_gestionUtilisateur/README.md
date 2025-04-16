**Mode d'emploi - API Spring Boot de Gestion des Utilisateurs**

**Prérequis**  
- IDE recommandé : IntelliJ IDEA
- Outils de test : Swagger UI ou Postman
- Environnement : JDK et Maven


 **1. Configuration Initiale**  

 **1.1. Importation du Projet**  
- Ouvrir le projet dans IntelliJ IDEA  
- Laisser l'IDE configurer automatiquement les dépendances Maven  

 **1.2. Configuration de la Base de Données**  
**Option 1 (Recommandée - Backup)** :  
1. Créer une base PostgreSQL nommée `userDataBase` via pgAdmin  
2. Restaurer le fichier `.backup` situé dans `/database`  

**Option 2 (Configuration Manuelle)** :  
1. Créer une base PostgreSQL avec le nom de votre choix  
2. Modifier `src/main/resources/application.properties` :  
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/votre_nom_de_base
   spring.datasource.username=votre_username
   spring.datasource.password=votre_password
   ```


 **2. Lancement de l'API**  
1. **Compiler** le projet (`mvn clean install`)  
2. **Lancer** l'application via la classe `@SpringBootApplication`
   

 **3. Test via Swagger UI**  

 **3.1. Accès à la Documentation**  
- Ouvrir : [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)  
- Dans la barre "Explore", saisir : `http://localhost:8080/v3/api-docs`  

 **3.2. Authentification**  
1. **Se connecter** :  
   - Endpoint : `POST /GestionUtilisateur/login`  
   - Cliquer sur **"Try it out"**  
   - Saisir les credentials :  
     ```json
     {
       "email": "admin@example.com",
       "password": "votreMotDePasse"
     }
     ```  
   - **Exécuter** → Copier le `token` reçu  

2. **Autoriser Swagger** :  
   - Cliquer sur le bouton **"Authorize"** (en haut à droite)  
   - Saisir : `Bearer <votre_token>`  
   - Valider par **"Login"**  

 **3.3. Suppression d'un Utilisateur (DELETE)**  
1. Endpoint : `DELETE /deleteOneUtilisateur/{nom}`  
2. **"Try it out"** → Saisir le `nom` de l'utilisateur à supprimer  
3. **Exécuter** → Vérifier la réponse (`"supprimé avec succès"`)  



 **4. Test via Postman**  

 **4.1. Authentification**  
1. **Requête POST** : `http://localhost:8080/GestionUtilisateur/login`  
2. **Body (JSON)** :  
   ```json
   {
     "email": "admin@example.com",
     "password": "votreMotDePasse"
   }
   ```  
3. **Récupérer le `token`** dans la réponse  

 **4.2. Suppression d'un Utilisateur**  
1. **Requête DELETE** : `http://localhost:8080/deleteOneUtilisateur/{nom}`  
2. **Auth** :  
   - Type : `Bearer Token`  
   - Token : Coller le token reçu lors du login  



 **Conseils & Dépannage**  
- **Port 8080 occupé** : Modifiez `server.port` dans `application.properties`  
- **Erreurs de base de données** : Vérifiez les logs Spring Boot (`Connection refused` → PostgreSQL est-il lancé ?)  
- **Problèmes de token** : Vérifiez l’expiration ou les droits du token JWT  



 **Exemple de Requêtes JSON**  
```json
// Login
{
  "email": "user@domain.com",
  "password": "secret123"
}

// Réponse (exemple)
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

Cette version est plus claire et inclut :  
- Des **étapes détaillées** pour la configuration de la base de données  
- Une **procédure d'authentification** explicite (Swagger + Postman)  
- Des **exemples JSON** prêts à l'emploi  
- Des **conseils de dépannage** ciblés
