

## 1. Introduction

L'objectif de ce projet est de concevoir et développer une application en Kotlin permettant de créer et gérer équitablement des groupes d'étudiants en fonction de leur sexe et de leur classe, pour les événements organisés par le Bureau des Étudiants (BDE). L'application permettra également d'attribuer des points aux équipes, de créer manuellement des équipes et de gérer les membres des groupes de manière flexible.

## 2. Fonctionnalités principales

#### **2.1 Création automatique de groupes équilibrés :**

- L'application permettra de générer des groupes aléatoires en prenant en compte le cursus et la classe des étudiants.
- Les étudiants seront répartis de manière équitable dans les groupes en fonction de leur cursus (Marketing, Programmation et Cybersécurité) et de leur classe (B1 à M2).

#### **2.2 Attribution de points :**

- Les utilisateurs pourront attribuer des points aux équipes en fonction de leur performance ou de leur participation à des activités spécifiques.
- Les points seront stockés dans la base de données pour chaque équipe.

#### **2.3 Création manuelle de groupes :**

- Les utilisateurs auront la possibilité de créer manuellement des groupes en sélectionnant les membres à inclure dans chaque équipe.
- Cette fonctionnalité permettra une flexibilité totale dans la création des groupes pour des événements spécifiques ou des besoins particuliers.

#### **2.4 Gestion des membres et des groupes :**

- L'application offrira la possibilité de déplacer des étudiants d'un groupe à un autre.
- Les utilisateurs pourront également supprimer des membres individuels ou des groupes entiers si nécessaire.
- Cette fonctionnalité permettra une gestion efficace et personnalisée des équipes en fonction des changements ou des ajustements nécessaires.

## **3. Stockage des données

- Toutes les informations sur les étudiants, y compris leur nom, leur prénom, leur cursus, leur classe et leur groupe attribué, seront stockées dans une base de données SQLite.
- Les données sur les équipes, y compris les membres de chaque équipe et leurs points respectifs, seront également sauvegardées dans la base de données.

## 4. Interface Utilisateur

#### 4.1 Interface conviviale :

- L'application disposera d'une interface utilisateur intuitive et conviviale permettant aux utilisateurs de naviguer facilement entre les différentes fonctionnalités.
- Des instructions claires seront fournies pour guider les utilisateurs dans l'utilisation de chaque fonctionnalité.

#### 4.2 Fonctionnalités de gestion :

- Les utilisateurs auront accès à des fonctionnalités de gestion faciles à utiliser pour créer, modifier et supprimer des groupes et des membres.

## 5. Contraintes techniques

#### 5.1 Développement en Kotlin :

- L'application sera développée en utilisant le langage de programmation Kotlin, compatible avec les plateformes Android.

#### 5.2 Utilisation de la bibliothèque SQLite :

- La gestion des données sera réalisée en utilisant la bibliothèque SQLite pour le stockage et la récupération des informations des étudiants et des équipes.

## 6. Conclusion

Ce cahier des charges définit les fonctionnalités principales de l'application de gestion de groupes pour les événements étudiants. En respectant ces spécifications, l'application fournira une solution complète et efficace pour créer, gérer et attribuer des points aux équipes de manière équitable et personnalisée, contribuant ainsi à la réussite des événements organisés par le Bureau des Étudiants.