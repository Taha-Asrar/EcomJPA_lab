<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil - E-commerce JPA</title>
</head>
<body>
    <h2>Bienvenue sur l'application E-commerce</h2>
    <p>Choisissez une section pour gérer votre boutique :</p>
    
    <ul>
        <li><a href="CategorieServlet?action=lister">Gérer les Catégories</a></li>
        <li><a href="ProduitServlet?action=lister">Gérer les Produits (Catalogue)</a></li>
        <li><a href="InternauteServlet?action=lister">Gérer les Internautes (Utilisateurs)</a></li>
        <li><a href="PanierServlet?action=afficher">Voir mon Panier</a></li>
    </ul>
</body>
</html>