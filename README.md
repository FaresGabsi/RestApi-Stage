# Boutique en ligne API REST

## Introduction

Ce projet consiste en la création d'un API REST pour gérer les commandes d'une boutique en ligne. L'API offre aux clients la possibilité de créer de nouvelles commandes, de consulter les détails des commandes existantes et de gérer les informations sur les produits disponibles. Le système est structuré autour de trois principales entités : le client, la commande et le produit.

Les technologies utilisées dans ce projet incluent :

- Spring Boot : Framework Java utilisé pour simplifier la création d'applications web en fournissant des fonctionnalités prêtes à l'emploi.
- Maven : Outil de gestion de projet pour Java, facilitant la gestion des dépendances et la construction du projet.
- Hibernate JPA : Framework d'ORM (Object-Relational Mapping) permettant de simplifier l'accès aux bases de données relationnelles.
- H2 Database : Base de données relationnelle en mémoire utilisée pour stocker temporairement les données du système.
- Postman : Outil utilisé pour tester et valider les requêtes et réponses de l'API REST.

## Détails de l'Implémentation

### Opérations principales

Le projet définit un contrôleur REST qui gère les requêtes HTTP pour différentes fonctionnalités liées aux clients et aux commandes. Les entités principales du système sont les clients, les commandes et les produits, chacune étant représentée par une classe Java correspondante.

Les opérations principales incluent :

1. Récupérer la liste de tous les clients (/clients) et la liste de tous les produits (/produits).

2. Créer un nouveau client à partir des données fournies dans un formulaire (/clients).

3. Récupérer un client spécifique en fonction de son identifiant unique (/clients/{id}).

4. Récupérer les commandes d'un client spécifique en fonction de son identifiant unique (/clients/{id}/commandes).

5. Créer une nouvelle commande pour un client spécifique en fonction de son identifiant unique (/clients/{id}/commandes) en fournissant une liste des identifiants des produits.

6. Récupérer une commande spécifique pour un client donné, en utilisant à la fois l'identifiant du client et l'identifiant de la commande (/clients/{id}/commandes/{id_cmd}).

7. Récupérer un produit spécifique en fonction de son identifiant unique (/produits/{id}).

8. Créer un nouveau produit à partir des données fournies (/produits).

### Gestion des erreurs

Le code gère également certaines erreurs, par exemple, lorsque les identifiants des clients ou des produits ne correspondent pas aux enregistrements existants, une réponse d'erreur avec un code de statut 404 Not Found ou 400 Bad Request est renvoyée.

## Utilisation

Pour utiliser cette API, vous pouvez exécuter le projet dans un environnement de développement compatible avec Java et Spring Boot. Assurez-vous d'avoir toutes les dépendances requises (Maven) et une base de données H2 configurée pour le stockage temporaire des données.

Vous pouvez tester les différentes fonctionnalités de l'API à l'aide de l'outil Postman ou tout autre client REST. Suivez les endpoints et les méthodes définis dans la section "Détails de l'Implémentation" pour interagir avec les clients, les produits et les commandes.

## Conclusion

Globalement, ce code fournit une interface de service Web pour gérer les clients, les produits et les commandes, et il communique avec une base de données pour effectuer les opérations demandées. Vous pouvez étendre cette API et ajouter de nouvelles fonctionnalités en fonction des besoins de votre boutique en ligne. Bon développement !
