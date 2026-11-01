<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Mon Panier</title>
</head>
<body>
    <h2>Mon Panier</h2>
    <p><strong>Internaute :</strong> ${panier.internaute != null ? panier.internaute.nom : 'Invité'}</p>
    
    <c:choose>
        <c:when test="${empty panier.lignes}">
            <p>Votre panier est vide.</p>
        </c:when>
        <c:otherwise>
            <table border="1" cellpadding="8" cellspacing="0">
                <thead>
                    <tr style="background-color: #f2f2f2;">
                        <th>Produit</th>
                        <th>Prix unitaire</th>
                        <th>Quantité</th>
                        <th>Sous-total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${panier.lignes}" var="ligne">
                        <tr>
                            <td>${ligne.produit.nom}</td>
                            <td>${ligne.produit.prix} DH</td>
                            <td>${ligne.quantite}</td>
                            <td>${ligne.sousTotal} DH</td>
                            <td>
                                <a href="PanierServlet?action=supprimer&id=${ligne.id}" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet article ?');">Supprimer</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr style="background-color: #e6f7ff; font-weight: bold;">
                        <td colspan="3" align="right">Total à payer :</td>
                        <td colspan="2" style="color: #007bff; font-size: 1.1em;">
                            ${panier.total != null ? panier.total : 0.0} DH
                        </td>
                    </tr>
                </tfoot>
            </table>
        </c:otherwise>
    </c:choose>

    <br>
    <div>
        <a href="ProduitServlet?action=lister">Continuer mes achats</a>
        <c:if test="${not empty panier.lignes}">
            &nbsp;|&nbsp;
            <button type="button" onclick="alert('Commande validée pour un total de ${panier.total} DH !');">Passer à la caisse (Payer)</button>
        </c:if>
    </div>
</body>
</html>
