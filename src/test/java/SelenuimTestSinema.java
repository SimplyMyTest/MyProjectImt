import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelenuimTestSinema {
    private WebDriver driver;
    @Before
    public  void setUp(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testRegisterTrue(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.name("name")).sendKeys("Мирослав");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actualText = driver.findElement(By.className("form-result")).getText();
        var expectedText = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void testRegisterFalse(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var actualText = driver.findElement(By.className("form-result")).getText();
        var expectedText = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals(expectedText, actualText);
    }
}
