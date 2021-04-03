import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class diplomtest {
        private WebDriver driver;

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        @After
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void testIntershop() {
            driver.navigate().to("http://intershop5.skillbox.ru/");
            var buttonEnter = By.cssSelector("a[class='account']");
            var buttonCustomRegister = By.cssSelector("button[class^='custom']");
            var lineUserName = By.cssSelector("[id='reg_username']");
            var lineUserEmail = By.cssSelector("[id='reg_email']");
            var lineUserPassword = By.cssSelector("[id='reg_password']");
            var buttonFinishRegister = By.cssSelector("button[name='register']");
            var registerFinish = By.cssSelector("//*[text() = 'Регистрация завершена']");

            driver.findElement(buttonEnter).click();
            driver.findElement(buttonCustomRegister).click();
            driver.findElement(lineUserName).sendKeys("Jazy");
            driver.findElement(lineUserEmail).sendKeys("jaz@mail.ru");
            driver.findElement(lineUserPassword).sendKeys("qwerty");
            driver.findElement(buttonFinishRegister).click();

            Assert.assertTrue("не выводится сообщение что регистрация завершена",driver.findElement(registerFinish).isDisplayed());



        }
    }


