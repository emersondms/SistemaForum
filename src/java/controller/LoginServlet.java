package controller;

import model.jdbc.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    public static String usuarioLogado;
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {}
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            usuarioLogado = UsuarioDAO.autenticar(
                request.getParameter("usuario"), request.getParameter("senha")
            ).getLogin();   
                  
            request.getRequestDispatcher("TopicosServlet").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("erro", "Usuário ou senha inválidos!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
