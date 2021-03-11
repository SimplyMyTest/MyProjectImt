import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class helloVasyaTest {
    /*(Модуль 2 задание 2 и3) 2. Повторите действия из этого урока для сайта приветствия (https://lm.skillbox.ru/qa_tester/module01/): создайте тест, который вводит имя Вася и получает текст «Привет, Вася!».





3. Запишите ещё один тест для этого же сайта (https://lm.skillbox.ru/qa_tester/module01/), который бы:

— открывал браузер,

— переходил на сайт приветствия,

— сразу же кликал по кнопке «Ввод»,

— проверял полученный текст приветствия,

— закрывал браузер.

*/
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe ");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
      driver.quit();
    }


@Test
public void TestHelloVasya(){

    driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
    driver.findElement(By.name("name")).sendKeys("Вася");
    driver.findElement(By.className("button")).click();
    var actualResult = driver.findElement(By.className("start-screen__res")).getText();
    var expectedResult = "Привет, Вася!";
    Assert.assertEquals(expectedResult, actualResult);


}
    @Test
    public void TestHelloVasya2() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, !";
        Assert.assertEquals(expectedResult, actualResult);


    }
}