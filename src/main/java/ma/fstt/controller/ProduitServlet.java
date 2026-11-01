package ma.fstt.controller;

import ma.fstt.dao.ProduitDAO;
import ma.fstt.dao.CategorieDAO;
import ma.fstt.entities.Produit;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ProduitDAO produitDAO;
    
    @Inject
    private CategorieDAO categorieDAO;

    String action = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        
        if (action == null) {
            action = "lister"; // default action
        }

        if ("ajouter".equals(action)) {
            // Forward to the add product form
            request.setAttribute("categories", categorieDAO.findAll());
            request.getRequestDispatcher("produit-form.jsp").forward(request, response);
            
        } else if ("modifier".equals(action)) {
            // Logic to fetch product and forward to edit form
            
        } else {
            // "lister" action (default)
            request.setAttribute("produits", produitDAO.findAll());
            request.getRequestDispatcher("produit-list.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        
        if ("ajouter".equals(action)) {
            Produit produit = new Produit();
            produit.setNom(request.getParameter("nom"));
            produit.setDescription(request.getParameter("description"));
            produit.setPrix(Double.parseDouble(request.getParameter("prix")));
            produit.setStock(Integer.parseInt(request.getParameter("stock")));
            
            Long categorieId = Long.parseLong(request.getParameter("categorieId"));
            produit.setCategorie(categorieDAO.findById(categorieId));
            
            produitDAO.save(produit);
            response.sendRedirect("ProduitServlet?action=lister");
        }
    }
}