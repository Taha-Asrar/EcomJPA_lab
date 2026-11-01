<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Catégories</title>
</head>
<body>
    <h2>Liste des Catégories</h2>
    <a href="CategorieServlet?action=ajouter">Ajouter une nouvelle catégorie</a>
    <br><br>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${categories}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.nom}</td>
                <td>${c.description}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="ProduitServlet?action=lister">Gérer les produits</a>
</body>
</html>