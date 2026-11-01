package ma.fstt.controller;

import ma.fstt.dao.ProduitDAO;
import ma.fstt.dao.PanierDAO;
import ma.fstt.dao.LignePanierDAO;
import ma.fstt.entities.LignePanier;
import ma.fstt.entities.Panier;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/PanierServlet")
public class PanierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private PanierDAO panierDAO;

    @Inject
    private LignePanierDAO lignePanierDAO;

    @Inject 
    private ProduitDAO produitDAO;
    String action = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");

        if (action == null) {
            action = "afficher";
        }

        if ("afficher".equals(action)) {
            Panier panier = panierDAO.findById(1L);
            if (panier != null) {
                panier.calculerTotal();
                panierDAO.update(panier);
            }
            request.setAttribute("panier", panier);
            request.getRequestDispatcher("panier-list.jsp").forward(request, response);
            
        } else if ("supprimer".equals(action)) {
            Long ligneId = Long.parseLong(request.getParameter("id"));
            lignePanierDAO.delete(ligneId);
            
            Panier panier = panierDAO.findById(1L);
            if (panier != null) {
                panier.calculerTotal();
                panierDAO.update(panier);
            }
            response.sendRedirect("PanierServlet?action=afficher");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            Long produitId = Long.parseLong(request.getParameter("produitId"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            double prix = Double.parseDouble(request.getParameter("prix"));
            
            // Assuming a default Panier ID of 1 for the current session testing
            Panier panier = panierDAO.findById(1L);
            if (panier == null) {
                panier = new Panier();
                panier.setDateCreation(new Date());
                panier.setTotal(0.0);
                panierDAO.save(panier);
                panier = panierDAO.findById(1L);
            }

            LignePanier ligne = new LignePanier();
            ligne.setQuantite(quantite);
            ligne.setSousTotal(quantite * prix);
            ligne.setProduit(produitDAO.findById(produitId));
            ligne.setPanier(panier);
            
            lignePanierDAO.save(ligne);
            
            // Recalculer le total après ajout
            panier = panierDAO.findById(1L);
            if (panier != null) {
                panier.calculerTotal();
                panierDAO.update(panier);
            }
            
            response.sendRedirect("PanierServlet?action=afficher");
        }
    }
}
