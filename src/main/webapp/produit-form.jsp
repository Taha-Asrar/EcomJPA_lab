<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ajouter un Produit</title>
</head>
<body>
    <h2>Ajouter un Produit</h2>
    <form action="ProduitServlet" method="post">
        <!-- Hidden field to trigger the "ajouter" action in doPost -->
        <input type="hidden" name="action" value="ajouter">
        
        <label>Nom :</label><br>
        <input type="text" name="nom" required><br><br>
        
        <label>Description :</label><br>
        <textarea name="description" required></textarea><br><br>
        
        <label>Prix :</label><br>
        <input type="number" step="0.01" name="prix" required><br><br>
        
        <label>Stock :</label><br>
        <input type="number" name="stock" required><br><br>
        
        <label>Catégorie :</label><br>
        <select name="categorieId" required>
            <option value="">Sélectionnez une catégorie</option>
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.nom}</option>
            </c:forEach>
        </select><br><br>
        
        <button type="submit">Enregistrer le produit</button>
    </form>
</body>
</html>