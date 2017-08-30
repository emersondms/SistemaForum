package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comentario;
import model.jdbc.ComentarioDAO;

@WebServlet(name = "InsereComentarioServlet", urlPatterns = {"/InsereComentarioServlet"})
public class InsereComentarioServlet extends HttpServlet {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {}
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idTopico = Integer.parseInt(request.getParameter("id_topico"));
            
            ComentarioDAO.inserir(new Comentario(
                request.getParameter("comentario"), LoginServlet.usuarioLogado,
                idTopico
            )); 

            request.getRequestDispatcher(
                "ExibeTopicoServlet?id_topico=" + idTopico
            ).forward(request, response);
        } catch (Exception ex) {}
    }
}
