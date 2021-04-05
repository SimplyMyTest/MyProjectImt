import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class diplomtest {
        private WebDriver driver;
        private WebDriverWait wait;

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver,8);
        }

        @After
        public void tearDown() {
            driver.quit();
        }

       /*Тест на оформление товара*/
        private By enterButton = By.cssSelector("a[class='account']");
        private By fieldName = By.cssSelector("[id='username']");
        private By fieldPassword = By.cssSelector("[id='password']");
        private  By buttonEnter = By.cssSelector("[class^='woocommerce-button']");
        private By buttonCatalog = By.xpath("//*[text()='Каталог']");
        private By searchOfProduct = By.cssSelector("[data-product_id='15']");
        private By buttonBasket = By.xpath("(//*[text()='Корзина'])[1]");
        private By placeAnOrder = By.cssSelector(".wc-proceed-to-checkout *:nth-child(1)");
        private By firstNameField = By.cssSelector("*[id='billing_first_name']");
        private By lastNameField = By.cssSelector("*[id='billing_last_name']");
        private By addressFirstField = By.cssSelector("*[id='billing_address_1']");
        private By cityField = By.cssSelector("*[id='billing_city']");
        private By stateField = By.cssSelector("*[id='billing_state']");
        private By postcodeField = By.cssSelector("*[id='billing_postcode']");
        private By phoneField = By.cssSelector("*[id='billing_phone']");
        private By buttonPlaceOrder = By.cssSelector("*[id='place_order']");
        private By postTitleBox = By.cssSelector("[class = 'post-title']");

        @Test
        public void myAccountPage_FillAndConfirm_EnterMyAccount(){
            /*arrange*/
            driver.navigate().to("http://intershop5.skillbox.ru/");
            var name = "Jazy";
            var password = "qwerty";
            var firstName ="Антон";
            var lastName = "Макаров";
            var addressStreet = "ул. Ленина 1";
            var cityLocation = "Москва";
            var stateLocation = "Московская область";
            var postcode = "423800";
            var  phone = "79279999999";

            driver.findElement(enterButton).click();
            driver.findElement(fieldName).sendKeys(name);
            driver.findElement(fieldPassword).sendKeys(password);
            driver.findElement(buttonEnter).click();
            driver.findElement(buttonCatalog).click();
            driver.findElement(searchOfProduct).click();
            driver.findElement(buttonBasket).click();
            driver.findElement(placeAnOrder).click();
            /*act*/
            driver.findElement(firstNameField).sendKeys(firstName);
            driver.findElement(lastNameField).sendKeys(lastName);
            driver.findElement(addressFirstField).sendKeys(addressStreet);
            driver.findElement(cityField).sendKeys(cityLocation);
            driver.findElement(stateField).sendKeys(stateLocation);
            driver.findElement(postcodeField).sendKeys(postcode);
            driver.findElement(phoneField).sendKeys(phone);
            driver.findElement(buttonPlaceOrder).click();
            /*assert*/
            wait.until(ExpectedConditions.textToBePresentInElementLocated(postTitleBox, "Заказ получен"));
            var actualText = "Заказ получен";
            Assert.assertEquals("Заказ не получен", actualText, driver.findElement(postTitleBox).getText());



        }
    }


