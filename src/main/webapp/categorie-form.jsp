<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter une Catégorie</title>
</head>
<body>
    <h2>Ajouter une Catégorie</h2>
    <form action="CategorieServlet" method="post">
        <input type="hidden" name="action" value="ajouter">
        
        <label>Nom :</label><br>
        <input type="text" name="nom" required><br><br>
        
        <label>Description :</label><br>
        <textarea name="description" required></textarea><br><br>
        
        <button type="submit">Enregistrer la catégorie</button>
    </form>
    <br>
    <a href="CategorieServlet?action=lister">Retour à la liste</a>
</body>
</html>