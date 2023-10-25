﻿# JavaPersonne
 
Tout d'abord j'utilise le MVC pour sa modularité, qui sépare l'application en trois composants distincts (Modèle, Vue et Contrôleur),
pour facilité le développement, les tests et la maintenance de chaque composant. Cette séparation
améliore la compréhension du code.

De plus, j'ai choisis de créer une abstract factory pour détacher toutes les méthodes de création des méthodes d'utilisation, pour faciliter la maintenance et la compréhension.

Enfin en créant un singleton pour la connexion à la base de donnée il n'existe qu'une seule instance d'une classe,
je permets donc à n'importe quelle partie de l'application.
