import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteForum {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/AssignmentWeek4/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testeCadastro() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.name("nome")).clear();
        driver.findElement(By.name("nome")).sendKeys("Emerson");
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("emersondms");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("emesondms@gmail.com");
        driver.findElement(By.name("senha")).clear();
        driver.findElement(By.name("senha")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        assertEquals("Usuário cadastrado! Faça seu login.",
            driver.findElement(By.id("usuario_cadastrado")).getText()
        );
    }
    
    @Test
    public void testeLogin() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.name("usuario")).clear();
        driver.findElement(By.name("usuario")).sendKeys("emersondms");
        driver.findElement(By.name("senha")).clear();
        driver.findElement(By.name("senha")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        assertEquals("Tópicos", driver.getTitle());
    }
    
    @Test
    public void testeRanking() throws Exception {
        driver.get(baseUrl + "TopicosServlet");
        driver.findElement(By.linkText("Ranking")).click();
        assertEquals("Ranking", driver.getTitle());
    }
}
