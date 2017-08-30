package teste_topico;

import model.Topico;
import model.jdbc.TopicoDAO;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

public class TesteTopicoDAO {
    
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
        jdt.setDataSet(loader.load("/teste_topico/inicio_topico.xml"));
        jdt.onSetup();
    }
    
    @Test
    public void testeInserir() throws Exception {
        TopicoDAO.inserir(new Topico(
            2, "titulo", "conteudo", "jane_calamidade"
        ));
        
        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("topico");
        IDataSet expectedDataSet = (loader.load("/teste_topico/validacao_topico.xml"));
        ITable expectedTable = expectedDataSet.getTable("topico");
        
        Assertion.assertEquals(expectedTable, currentTable);
    }
}
