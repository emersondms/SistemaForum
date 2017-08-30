package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Topico;
import model.jdbc.TopicoDAO;

@WebServlet(name = "InsereTopicoServlet", urlPatterns = {"/InsereTopicoServlet"})
public class InsereTopicoServlet extends HttpServlet {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {}
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            TopicoDAO.inserir(new Topico(
                request.getParameter("titulo"),request.getParameter("conteudo"),
                LoginServlet.usuarioLogado
            )); 
            
            request.getRequestDispatcher("TopicosServlet").forward(request, response);
        } catch (Exception ex) {}
    }
}
