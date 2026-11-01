<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Internaute</title>
</head>
<body>
    <h2>Ajouter un Internaute</h2>
    <form action="InternauteServlet" method="post">
        <input type="hidden" name="action" value="ajouter">
        
        <label>Nom :</label><br>
        <input type="text" name="nom" required><br><br>
        
        <label>Email :</label><br>
        <input type="email" name="email" required><br><br>
        
        <label>Mot de passe :</label><br>
        <input type="password" name="motDePasse" required><br><br>
        
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>