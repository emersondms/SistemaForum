package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.jdbc.UsuarioDAO;

@WebServlet(name = "RankingServlet", urlPatterns = {"/RankingServlet"})
public class RankingServlet extends HttpServlet {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {}
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("ranking", UsuarioDAO.ranking());
            request.getRequestDispatcher("ranking.jsp").forward(request, response);
        } catch (Exception ex) {} 
    }
}
