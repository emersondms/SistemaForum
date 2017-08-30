package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.jdbc.ComentarioDAO;
import model.jdbc.TopicoDAO;

@WebServlet(name = "ExibeTopicoServlet", urlPatterns = {"/ExibeTopicoServlet"})
public class ExibeTopicoServlet extends HttpServlet {
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {}
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idTopico = Integer.parseInt(request.getParameter("id_topico"));
            
            request.setAttribute("topico", TopicoDAO.recuperar(idTopico));
            request.setAttribute("comentarios", ComentarioDAO.listaComentarios(idTopico));
            request.getRequestDispatcher("exibe_topico.jsp").forward(request, response);
        } catch (Exception ex) {}
    }
}
