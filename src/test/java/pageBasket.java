import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageBasket {
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
    //сценарий увеличения товара в корзине
    private By enterButton = By.cssSelector("a[class='account']");
    private By fieldName = By.cssSelector("[id='username']");
    private By fieldPassword = By.cssSelector("[id='password']");
    private By buttonEnter = By.cssSelector("[class^='woocommerce-button']");
    private By buttonCatalog = By.xpath("//*[text()='Каталог']");
    private By searchOfProduct = By.cssSelector("[data-product_id='15']");
    private By buttonBasketApple = By.xpath("(//*[text()='Корзина'])[1]");
    private By buttonBasket = By.xpath("//*[@id='menu-item-29']//a");
    private By quantityField = By.xpath("//*[contains(@class,'woocommerce-cart-form__cart')]//*[contains(@class,'input')]");

    @Test
    public void basketPage_quantityOfGoods(){
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";

        driver.findElement(enterButton).click();
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonEnter).click();
        driver.findElement(buttonCatalog).click();
        driver.findElement(searchOfProduct).click();
        driver.findElement(buttonBasketApple).click();

        driver.findElement(buttonBasket).click();
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).click();
        driver.findElement(quantityField).sendKeys("4");

        var appleQuantity = "4";
        Assert.assertEquals(appleQuantity,driver.findElement(quantityField).getText());
    }
    //сценарий удаления товара из корзины
    private By badgeDeleteFromBasket = By.cssSelector("*[data-product_id='15']");
    private By nameAppleWatch = By.cssSelector(".content-page .woocommerce .product-name :nth-of-type(1)");
    @Test
    public void basketPage_deleteFromBasket(){
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        driver.findElement(enterButton).click();
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonEnter).click();
        driver.findElement(buttonCatalog).click();
        driver.findElement(searchOfProduct).click();
        driver.findElement(buttonBasketApple).click();

        driver.findElement(buttonBasket).click();
        driver.findElement(badgeDeleteFromBasket).click();
        Assert.assertFalse("товар до сих пор в корзине",driver.findElement(nameAppleWatch).isDisplayed());
    }
    //сценарий возврата удаленного товараиз корзины
    private By buttonReturn = By.cssSelector(".woocommerce-notices-wrapper a");
    @Test
    public void basketPage_ReturnGoods_afterDelete(){
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        driver.findElement(enterButton).click();
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonEnter).click();
        driver.findElement(buttonCatalog).click();
        driver.findElement(searchOfProduct).click();
        driver.findElement(buttonBasketApple).click();

        driver.findElement(buttonBasket).click();
        driver.findElement(badgeDeleteFromBasket).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonReturn));
        driver.findElement(buttonReturn).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(nameAppleWatch));
        Assert.assertTrue("товар не возвращен",driver.findElement(nameAppleWatch).isDisplayed());

    }
    //Сценарий для применения купона
    private By fieldCertificate = By.cssSelector("*[id=coupon_code]");
    private By buttonUseCoupon = By.cssSelector("[name=apply_coupon]");
    private By elementDiscount = By.cssSelector(".cart-discount.coupon-sert500");
    @Test
    public void basketPage_useCertificate(){
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        driver.findElement(enterButton).click();
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonEnter).click();
        driver.findElement(buttonCatalog).click();
        driver.findElement(searchOfProduct).click();
        driver.findElement(buttonBasketApple).click();

        driver.findElement(buttonBasket).click();
        driver.findElement(fieldCertificate).click();
        driver.findElement(fieldCertificate).sendKeys("sert500");
        driver.findElement(buttonUseCoupon).click();

        Assert.assertTrue("не отображается скидка",driver.findElement(elementDiscount).isDisplayed());
    }


}
