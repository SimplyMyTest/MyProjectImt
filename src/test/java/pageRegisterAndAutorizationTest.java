import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageRegisterAndAutorizationTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 8);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    //Сценарий для регистрации на сайте
    private By enterButton = By.cssSelector("a[class='account']");
    private By registerButton = By.cssSelector(".custom-register-button");
    private By regUserName = By.cssSelector("[id=reg_username]");
    private By regEmailName = By.cssSelector("[id=reg_email]");
    private By regPassword = By.cssSelector("[id=reg_password]");
    private By registerButtonTwo = By.xpath("//*[contains(@class,'woocommerce-Button')]");
    private By registrationCompleted = By.xpath ("//*[text()='Регистрация завершена'");
    @Test
    public void pageRegister_InMyAccount(){
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Georg";
        var emailName = "georger6@mail.ru";
        var password = "123456";
        driver.findElement(enterButton).click();
        driver.findElement(registerButton).click();

        driver.findElement(regUserName).sendKeys(name);
        driver.findElement(regEmailName).sendKeys(emailName);
        driver.findElement(regPassword).sendKeys(password);
        driver.findElement(registerButtonTwo).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(registrationCompleted));
        Assert.assertTrue("сообщение верное",driver.findElement(registrationCompleted).isDisplayed());

    }
    //сценарий для авторизации уже с существующим пользователем
    private By fieldUserName = By.cssSelector("*[id=username]");
    private By fieldPassword = By.cssSelector("[id=password]");
    private By radioButtonRememberMe = By.cssSelector("[name=rememberme]");
    private By customRegisterButton = By.xpath("//*[contains(@class,'woocommerce-button button')]");
    private By postTitle = By.xpath("//div[@id='primary']//*[@class='post-title']");
    @Test
    public void pageRegistration_Error(){
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Georg";
        var emailName = "georger6@mail.ru";
        var password = "123456";
        driver.findElement(enterButton).click();

        driver.findElement(fieldUserName).sendKeys(name);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(radioButtonRememberMe).click();
        driver.findElement(customRegisterButton).click();

        Assert.assertTrue("не вошли в аккаунт",driver.findElement(postTitle).isDisplayed());

    }
    //сценарий выхода из аккаунта после входа
    private By buttonLogout = By.cssSelector("li[class$=logout]");
    @Test
    public void pageRegistration_LogOut(){

        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Georg";
        var emailName = "georger6@mail.ru";
        var password = "123456";
        driver.findElement(enterButton).click();

        driver.findElement(fieldUserName).sendKeys(name);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(customRegisterButton).click();
        driver.findElement(buttonLogout).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(enterButton));
        Assert.assertTrue("из аккаунта выход не произошел",driver.findElement(enterButton).isDisplayed());
    }
    //сценарий для входа с пустыми значениями полей авторизации
    private By messageOfError = By.xpath("//div[@class='woocommerce-notices-wrapper']//li");
    @Test
    public void pageRegister_EmptyFields(){
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(enterButton).click();

        driver.findElement(fieldUserName).click();
        driver.findElement(fieldPassword).click();
        driver.findElement(customRegisterButton).click();

        Assert.assertTrue("вход выполнен", driver.findElement(messageOfError).isDisplayed());
    }
}
