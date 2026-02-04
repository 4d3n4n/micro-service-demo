### TP architecture microservice

En vous basant sur le schéma et l'architecture mise en place, vous devez mettre en place le fonctionnement suivant :

- Lors de la création d'une Card ou d'un Loan, on doit être en capacité à vérifier que l'Account existe avant de créer une card ou un Loan.
- On doit être capable de récupérer un Account et notamment la liste des Cards ou des Loans appartenant à ce Account.
- Intégrer un DTO dans pour le microservice Account.
- Les appels aux autres microservices doivent être gérer dans des Class à part avec un RestTemplate.
- Utiliser Postman pour effectuer vos tests et les simulations.