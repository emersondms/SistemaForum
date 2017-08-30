package model.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {
    
    public static Usuario autenticar(String login, String senha) throws Exception {
        try(PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(
            "SELECT * FROM usuario WHERE login = ? AND senha = ?;")) {
            
            statement.setString(1, login);
            statement.setString(2, senha);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                return new Usuario(
                    rs.getString("login"), rs.getString("email"),
                    rs.getString("nome"), rs.getString("senha"),
                    rs.getInt("pontos")
                );
            } else {
                throw new Exception();
            }
        } 
    }
    
    public static void cadastrar(Usuario usuario) throws Exception {
        try (PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(
            "INSERT INTO usuario(login, email, nome, senha, pontos) " +
            "VALUES (?, ?, ?, ?, ?);")) {       
            
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getSenha());
            statement.setInt(5, usuario.getPontos());
            
            statement.execute();
        } 
    }
    
    public static List<Usuario> ranking() throws SQLException {
        try (PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(
            "SELECT * FROM usuario ORDER BY pontos DESC;")) {
            
            List<Usuario> usuarios = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                usuarios.add(new Usuario(
                    rs.getString("login"), rs.getString("email"),
                    rs.getString("nome"), rs.getString("senha"),
                    rs.getInt("pontos")
                ));
            }
            
            return usuarios;
        }
    }
    
    public static void adicionarPontos(String usuario, int pontos) throws SQLException {
        try (PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(
            "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;")) {       
            
            statement.setInt(1, pontos);
            statement.setString(2, usuario);
            
            statement.execute();
        } 
    }
}
