import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkTest {
    @Test
    public void testAllFieldsHello(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        var driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("+7900-000-00-00");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (test@test.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +7900-000-00-00.";
        Assert.assertEquals(expectedText, actualText);
        driver.quit();

    }
    @Test
    public void testEmptyFieldsHello(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        var driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }
    @Test
    public void testThirtyFieldsHello(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        var driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }
    @Test
    public void testFortyFieldsHello(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        var driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("phone")).sendKeys("+7900-000-00-00");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +7900-000-00-00.";
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }
    @Test
    public void testFiftyFieldsHello(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        var driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, .\n" +
                "На вашу почту (test@test.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }
    @Test
    public void sixtyFieldsHello(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        var driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Сэм");
        driver.findElement(By.name("email")).sendKeys("sam@");
        driver.findElement(By.name("phone")).sendKeys("qwerty");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, Сэм.\n" +
                "На вашу почту (sam@) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: qwerty.";
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }
}
