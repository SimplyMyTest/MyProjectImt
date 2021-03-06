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
        wait = new WebDriverWait(driver, 8);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*Тест на оформление товара*/
    private By enterButton = By.cssSelector("a[class='account']");
    private By fieldName = By.cssSelector("[id='username']");
    private By fieldPassword = By.cssSelector("[id='password']");
    private By buttonEnter = By.cssSelector("[class^='woocommerce-button']");
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
    public void myAccountPage_FillAndConfirm_EnterMyAccount() {
        /*arrange*/
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        var firstName = "Антон";
        var lastName = "Макаров";
        var addressStreet = "ул. Ленина 1";
        var cityLocation = "Москва";
        var stateLocation = "Московская область";
        var postcode = "423800";
        var phone = "79279999999";

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

    //сценарий поиска Ipad через строку поиска
    private By searchField = By.cssSelector("[class='search-field']");
    private By buttonSearch = By.cssSelector("i[class$='fa-search']");
    private By imgIpad = By.cssSelector("a[href$='ipad-air-2020-64gb-wi-fi/']:not([class])");

    @Test
    public void pageSearchField_IpadAir() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        var searchProduct = "Ipad";

        driver.findElement(enterButton).click();
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonEnter).click();

        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(searchProduct);
        driver.findElement(buttonSearch).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(imgIpad));
        Assert.assertTrue("Товар не обнаружен", driver.findElement(imgIpad).isDisplayed());
    }

    //3 Сценарий добавления холодильника в корзину
    private By bridgeCatalog = By.xpath("(//*[text()='Холодильники'])[2]");
    private By buttonAddBridgeToBasket = By.xpath("//*[@class='wc-products']//ul//li[2]//div[@class='price-cart']//a");
    private By buttonBasketInSite = By.cssSelector("[id=menu-item-29]");
    private By cartBridgeGorenjeInBasket = By.xpath("//div[@class='content-page']//*[@class='woocommerce-cart-form']//tr[2]//td[3]//a");

    @Test
    public void pageBridge_addToBasket() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        var nameBridge = "Холодильник GORENJE NRK611CLI, двухкамерный, слоновая кость";
        driver.findElement(enterButton).click();
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonEnter).click();

        driver.findElement(buttonCatalog).click();
        driver.findElement(bridgeCatalog).click();
        driver.findElement(buttonAddBridgeToBasket).click();
        driver.findElement(buttonBasketInSite).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(cartBridgeGorenjeInBasket));
        Assert.assertEquals("Неправильно отображается имя", nameBridge, driver.findElement(cartBridgeGorenjeInBasket).getText());
    }
//сценарий смены пароля
    private By buttonAccount = By.xpath("(//*[text()='Мой аккаунт'])[1]");
    private By buttonDetailsAccount = By.xpath("//*[text()='Данные аккаунта']");
    private By fieldPasswordCurrent = By.cssSelector("*[id=password_current]");
    private By fieldPasswordOne = By.cssSelector("*[id=password_1]");
    private By fieldPasswordTwo = By.cssSelector("*[id=password_2]");
    private By buttonSaveAccountDetails = By.cssSelector("*[name=save_account_details]");
    private By accountDetailsChanged = By.cssSelector("*[role=alert]");

    @Test
    public void pageAccount_changeParole() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        var newPassword = "qwerty123456";
        driver.findElement(enterButton).click();
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonEnter).click();
        driver.findElement(buttonAccount).click();
        driver.findElement(buttonDetailsAccount).click();

        driver.findElement(fieldPasswordCurrent).sendKeys(password);
        driver.findElement(fieldPasswordOne).sendKeys(newPassword);
        driver.findElement(fieldPasswordTwo).sendKeys(newPassword);
        driver.findElement(buttonSaveAccountDetails).click();

        Assert.assertTrue("сообщение о изменениях сохранены", driver.findElement(accountDetailsChanged).isDisplayed());

    }

    //сценарий для пагинации на странице каталога (13.04.21)
    private By pageNumbersTwo = By.xpath("//ul[@class='page-numbers']//li[2]");
    private By imgPageTwo = By.xpath("//*[text()='Page 2']");

    @Test
    public void pageCatalog_pageNext() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        driver.findElement(buttonCatalog).click();

        driver.findElement(pageNumbersTwo).click();

        Assert.assertTrue(" отображается 2 страница экрана", driver.findElement(pageNumbersTwo).isDisplayed());
    }

    //Сценарий перехода из категории товаро на страницу электроники в разделе страницы каталога
    private By buttonElectronic = By.xpath("//ul[@class='product-categories']//li[12]");
    private By pageElectronic = By.xpath("//*[@class='entry-title ak-container']");

    @Test
    public void pageElectronic_selectFromCategory() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        driver.findElement(buttonCatalog).click();

        driver.findElement(buttonElectronic).click();
        var expectedPageElectronicText = "КАТАЛОГ";
        Assert.assertEquals("не соответствует названию", expectedPageElectronicText, driver.findElement(pageElectronic).getText());
    }

    //Сценарий для добавленния товара из категории телевизоров и промотра товара в корзине
    private By buttonTv = By.xpath("//ul[@class='product-categories']/li[8]");
    private By buttonAddToBasketLedTv = By.cssSelector("a[href='?add-to-cart=79']");
    private By buttonMoreDetailed = By.xpath("//div[@class='collection_desc clearfix']//a[2]");
    private By elementTextTvLedInTheBasket = By.xpath("//*[contains(@class,'product-template-default single single-product postid-79')]");

    @Test
    public void pageTv_addToBasket_lookInTheBasket() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        driver.findElement(buttonCatalog).click();
        driver.findElement(buttonTv).click();

        driver.findElement(buttonAddToBasketLedTv).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonMoreDetailed));
        driver.findElement(buttonMoreDetailed).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(elementTextTvLedInTheBasket));
        Assert.assertTrue("Товар не добавлен в корзину", driver.findElement(elementTextTvLedInTheBasket).isDisplayed());
    }

    //Сценарий добавления часов в виде 2 экземпляров в корзину
    private By buttonClockOfCategory = By.xpath("//ul[@class='product-categories']/li[12]");
    private By buttonImgClock = By.xpath("//ul//li[contains(@class,'product type-product post-15')]//span[@class='onsale']");
    private By fieldQuantity = By.xpath("//*[@class='input-text qty text']");
    private By buttonAddClockToBasket = By.cssSelector(".button[type=submit]");
    private By lookBasket = By.cssSelector(".content-inner.clearfix");
    @Test
    public void pageClock_addToBasket_lookInTheBasket() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var name = "Jazy";
        var password = "qwerty";
        driver.findElement(buttonCatalog).click();

        driver.findElement(buttonClockOfCategory).click();
        driver.findElement(buttonImgClock).click();
        driver.findElement(fieldQuantity).clear();
        driver.findElement(fieldQuantity).sendKeys("2");
        driver.findElement(buttonAddClockToBasket).click();
        driver.findElement(buttonBasket).click();

        Assert.assertTrue("добавлено 2 товара в корзину",driver.findElement(lookBasket).isDisplayed());


    }
}


