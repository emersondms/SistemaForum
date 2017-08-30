package teste_comentario;

import model.Comentario;
import model.jdbc.ComentarioDAO;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

public class TesteComentarioDAO {
    
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
        jdt.setDataSet(loader.load("/teste_comentario/inicio_comentario.xml"));
        jdt.onSetup();
    }
    
    @Test
    public void testeInserir() throws Exception {
        ComentarioDAO.inserir(new Comentario(
            2, "comentario", "jane_calamidade", 1
        ));
        
        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("comentario");
        IDataSet expectedDataSet = (loader.load("/teste_comentario/validacao_comentario.xml"));
        ITable expectedTable = expectedDataSet.getTable("comentario");
        
        Assertion.assertEquals(expectedTable, currentTable);
    }
}
