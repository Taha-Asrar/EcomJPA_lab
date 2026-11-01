package ma.fstt.controller;

import ma.fstt.dao.InternauteDAO;
import ma.fstt.entities.Internaute;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InternauteServlet")
public class InternauteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private InternauteDAO internauteDAO;

    String action = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        
        if (action == null) {
            action = "lister";
        }

        if ("ajouter".equals(action)) {
            request.getRequestDispatcher("internaute-form.jsp").forward(request, response);
            
        } else {
            request.setAttribute("internautes", internauteDAO.findAll());
            request.getRequestDispatcher("internaute-list.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        
        if ("ajouter".equals(action)) {
            Internaute internaute = new Internaute();
            internaute.setNom(request.getParameter("nom"));
            internaute.setEmail(request.getParameter("email"));
            internaute.setMotDePasse(request.getParameter("motDePasse"));
            
            internauteDAO.save(internaute);
            response.sendRedirect("InternauteServlet?action=lister");
        }
    }
}