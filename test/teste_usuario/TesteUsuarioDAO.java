package teste_usuario;

import model.Usuario;
import model.jdbc.UsuarioDAO;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

public class TesteUsuarioDAO {
    
    JdbcDatabaseTester jdt;
    FlatXmlDataFileLoader loader;
    
    @Before
    public void setUp() throws ClassNotFoundException, Exception { 
        jdt = new JdbcDatabaseTester(
            "org.postgresql.Driver", 
            "jdbc:postgresql://localhost:5432/coursera", 
            "postgres", "postgres"
        );
        
        loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/teste_usuario/inicio_usuario.xml"));
        jdt.onSetup();
    }
    
    @Test
    public void testeCadastrar() throws Exception {
        UsuarioDAO.cadastrar(new Usuario(
            "jane_calamidade", "jane_calamidade@hotmail.com", 
            "Jane Calamidade", "12345", 0
        ));
        
        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("usuario");
        IDataSet expectedDataSet = (loader.load("/teste_usuario/validacao_usuario.xml"));
        ITable expectedTable = expectedDataSet.getTable("usuario");
        
        Assertion.assertEquals(expectedTable, currentTable);
    }
}
