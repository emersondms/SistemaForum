package model.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Comentario;

public class ComentarioDAO {
    
    public static void inserir(Comentario comentario) throws Exception {
        try (PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(
            "INSERT INTO comentario(comentario, login, id_topico) VALUES (?, ?, ?);")) {       
            
            statement.setString(1, comentario.getComentario());
            statement.setString(2, comentario.getLogin());
            statement.setInt(3, comentario.getIdTopico());
            
            UsuarioDAO.adicionarPontos(comentario.getLogin(), 3);
            statement.execute();
        } 
    }
    
    public static List<Comentario> listaComentarios(int idTopico) throws SQLException {
        try (PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(
            "SELECT * FROM comentario WHERE id_topico = ? ORDER BY id_comentario DESC;")) {
            
            statement.setInt(1, idTopico);
            List<Comentario> comentarios = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                comentarios.add(new Comentario(
                    rs.getInt("id_comentario"), rs.getString("comentario"),
                    rs.getString("login"), rs.getInt("id_topico")
                ));
            }
            
            return comentarios;
        } 
    }
}
