package ma.fstt.controller;

import ma.fstt.dao.CategorieDAO;
import ma.fstt.entities.Categorie;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CategorieServlet")
public class CategorieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private CategorieDAO categorieDAO;

    String action = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");

        if (action == null) {
            action = "lister";
        }

        if ("ajouter".equals(action)) {
            request.getRequestDispatcher("categorie-form.jsp").forward(request, response);
        } else {
            request.setAttribute("categories", categorieDAO.findAll());
            request.getRequestDispatcher("categorie-list.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            Categorie categorie = new Categorie();
            categorie.setNom(request.getParameter("nom"));
            categorie.setDescription(request.getParameter("description"));
            
            categorieDAO.save(categorie);
            response.sendRedirect("CategorieServlet?action=lister");
        }
    }
}