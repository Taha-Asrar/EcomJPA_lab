<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Internautes</title>
</head>
<body>
    <h2>Liste des Internautes</h2>
    <a href="InternauteServlet?action=ajouter">Ajouter un internaute</a>
    <br><br>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${internautes}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.nom}</td>
                <td>${i.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>