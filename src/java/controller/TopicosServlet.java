package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.jdbc.TopicoDAO;

@WebServlet(name = "TopicosServlet", urlPatterns = {"/TopicosServlet"})
public class TopicosServlet extends HttpServlet {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {}
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("topicos", TopicoDAO.listaTopicos());
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        } catch (Exception ex) {}
    }
}
