package model.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Topico;

public class TopicoDAO {
    
    public static void inserir(Topico topico) throws Exception {
        try (PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(
            "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?);")) {       
            
            statement.setString(1, topico.getTitulo());
            statement.setString(2, topico.getConteudo());
            statement.setString(3, topico.getLogin());
            
            UsuarioDAO.adicionarPontos(topico.getLogin(), 10);
            statement.execute();
        } 
    }
    
    public static List<Topico> listaTopicos() throws SQLException {
        try (PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(
            "SELECT * FROM topico ORDER BY id_topico DESC;")) {
            
            List<Topico> topicos = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                topicos.add(new Topico(
                    rs.getInt("id_topico"),
                    rs.getString("titulo"),
                    rs.getString("conteudo"),
                    rs.getString("login")
                ));
            }
            
            return topicos;
        } 
    }
    
    public static Topico recuperar(int id) throws SQLException, Exception {
        try(PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(
            "SELECT * FROM topico WHERE id_topico = ?;")) {
            
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                return new Topico(
                    rs.getInt("id_topico"), rs.getString("titulo"),
                    rs.getString("conteudo"), rs.getString("login")
                );
            } else {
                throw new Exception();
            }
        }
    }
}
