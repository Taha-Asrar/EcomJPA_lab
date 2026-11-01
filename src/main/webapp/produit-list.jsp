<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Produits</title>
</head>
<body>
    <h2>Liste des Produits</h2>
    <a href="ProduitServlet?action=ajouter">Ajouter un nouveau produit</a> | 
    <a href="PanierServlet?action=afficher"><strong>Voir mon Panier</strong></a>
    <br><br>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix</th>
            <th>Stock</th>
            <th>Catégorie</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${produits}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.nom}</td>
                <td>${p.description}</td>
                <td>${p.prix} DH</td>
                <td>${p.stock}</td>
                <td>${p.categorie != null ? p.categorie.nom : 'Aucune'}</td>
                <td>
                    <form action="PanierServlet" method="post" style="margin:0;">
                        <input type="hidden" name="action" value="ajouter">
                        <input type="hidden" name="produitId" value="${p.id}">
                        <input type="hidden" name="prix" value="${p.prix}">
                        <input type="number" name="quantite" value="1" min="1" max="${p.stock}" style="width: 40px;">
                        <button type="submit">Ajouter</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="index.jsp">Retour à l'accueil</a>
</body>
</html>
