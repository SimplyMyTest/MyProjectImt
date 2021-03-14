import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModuleFour {
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
    private By emailLocator = By.className("email");
    private By writeToMeLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("notification-email");
    @Test
    public void testKittens() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(writeToMeLocator).click();
        Assert.assertTrue("не отобразился текст про e-mail", driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("неправильный текст про e-mail", email, driver.findElement(resultEmailLocator).getText());
    }
    @Test
    public void testKittensEmptyEmail(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        driver.findElement(writeToMeLocator).click();
        Assert.assertEquals("неправильный текст про e-mail", "", driver.findElement(resultEmailLocator).getText());
    }
    @Test
    public void testFeedBack(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        var nameLocator = By.cssSelector(".data.text");
        var buttonLocator = By.id("comment");
        var messageLocator = By.className("message-header");
        driver.findElement(nameLocator).sendKeys("Вася");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("не отобразился текст про спасибо", driver.findElement(messageLocator).isDisplayed());
    }
    /*Используя известные вам техники тест-дизайна, напишите ещё два теста на позитивные сценарии к сайту
    с подбором имени для щенка. Используйте при этом все советы из урока.
     */

    private By radioElement = By.id("boy");
    private By emailElement = By.name("email");
    private By buttonElement = By.id("sendMe");
    private By resultElement = By.className("your-email");

    @Test
    public void testNameDog(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(radioElement).click();
        var email = "test@test.ru";
        driver.findElement(emailElement).sendKeys(email);
        driver.findElement(buttonElement).click();
        Assert.assertTrue("не отобразился текст про e-mail", driver.findElement(resultElement).isDisplayed());
    }
    @Test
    public void tesDogNameEmptyEmail(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(buttonElement).click();
        Assert.assertEquals("не правильный текст про e-mail", "", driver.findElement(resultElement).getText());
    }
    /*Напишите один позитивный тест для странички, включающий в себя заполнение всех полей. Перед написанием
     кода проверьте свои локаторы через браузер. Ищите элементы с помощью By.cssSelector, указывая один или два
      класса там, где поиск по одному классу будет неуникальным.
     */
    @Test
    public void testCallMaster(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
        driver.findElement(By.cssSelector(".form-input.fio")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.cssSelector(".form-input.street")).sendKeys("Ленина");
        driver.findElement(By.cssSelector(".form-input.house")).sendKeys("1");
        driver.findElement(By.cssSelector(".form-input.flat")).sendKeys("256");
        driver.findElement(By.cssSelector(".form-input.date")).sendKeys("завтра");
        driver.findElement(By.cssSelector(".form-submit")).click();
        var resultResultElement = By.cssSelector(".form-result");
        Assert.assertTrue("не отображается текст заявки", driver.findElement(resultResultElement).isDisplayed());
    }
    /* 1. Запишите один тест на сценарий работы валидации формы авторизации на сайте клуба любителей весёлых носков.



Сценарий следующий:

перейти на страницу;
ввести в поле email значение «@»;
ввести в поле для пароля значение «123»;
нажать на кнопку «Войти»;
убедиться, что отобразился текст с ошибкой (проверка только на видимость);
проверить сам текст с ошибкой, он должен быть равен «Некорректный email или пароль».


При этом каждый элемент на странице ищите новым способом из уже изученных, а  именно: By.id, By.tagName, By.className, By.name. Итого у вас будет четыре элемента, найденные четырьмя разными стратегиями поиска.

Локаторы для этих элементов выносите в отдельный блок кода (на уровне класса или самого тестового метода — не так важно), а элементы ищите непосредственно перед взаимодействием. Используйте при проверках assertTrue и assertEquals с указанием сообщений в случае падения теста.*/
    private By nameElement = By.name("email");
    private By passwordElement = By.id("password");
    private By buttonEnterElement = By.className("form-submit");
    private By resultErrorElement = By.tagName("pre");
    @Test
    public void testSockLoversClub(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
        driver.findElement(nameElement).sendKeys("@");
        driver.findElement(passwordElement).sendKeys("123");
        driver.findElement(buttonEnterElement).click();
        Assert.assertTrue("не отобразился текст про ошибку авторизации", driver.findElement(resultErrorElement).isDisplayed());
        var expectedText = "Некорректный email или пароль";
        var actualResult = driver.findElement(resultErrorElement).getText();
        Assert.assertEquals("неправильно отображается текст про ошибку", expectedText, actualResult);
    }
    /* 2. Страница авторизации обновилась. Запишите точно такой же тест для страницы. В этом задании ищите все элементы
     с помощью By.cssSelector. Там, где элемент нельзя найти уникально по одному классу, ищите по двум.
     */
    private By nameElementUpdate = By.cssSelector(".form-input.input-data");
    private By passwordElementUpdate = By.cssSelector(".form-input.password");
    private By buttonEnterElementUpdate = By.cssSelector(".form-submit");
    private By resultErrorElementUp = By.cssSelector(".form-error-password-email");
    @Test
    public void testSockLoversClubUpdate(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(nameElementUpdate).sendKeys("@");
        driver.findElement(passwordElementUpdate).sendKeys("123");
        driver.findElement(buttonEnterElementUpdate).click();
        Assert.assertTrue("не отобразился текст про ошибку авторизации", driver.findElement(resultErrorElementUp).isDisplayed());
        var expectedText = "Некорректный email или пароль";
        var actualResultUp = driver.findElement(resultErrorElementUp).getText();
        Assert.assertEquals("неправильно отображается текст про ошибку", expectedText, actualResultUp);
    }
    /* 3. Используйте сценарий и тест, как в задании 2, только теперь ищите элементы с помощью
     By.cssSelector с поиском
     по тегу и одному или двум классам одновременно.
     */
    private By nameElement3 = By.cssSelector("input.form-input.input-data");
    private By passwordElement3 = By.cssSelector("input.form-input.password");
    private By buttonEnterElement3 = By.cssSelector("button.form-submit");
    private By resultErrorElement3 = By.cssSelector("pre.form-error-password-email");
    @Test
    public void testSockLoversClub3(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(nameElement3).sendKeys("@");
        driver.findElement(passwordElement3).sendKeys("123");
        driver.findElement(buttonEnterElement3).click();
        Assert.assertTrue("не отобразился текст про ошибку авторизации", driver.findElement(resultErrorElement3).isDisplayed());
        var expectedText = "Некорректный email или пароль";
        var actualResult3 = driver.findElement(resultErrorElement3).getText();
        Assert.assertEquals("неправильно отображается текст про ошибку", expectedText, actualResult3);
    }
    /* 4. Используйте сценарий и тест, как в задании 2, только теперь ищите элементы с помощью By.cssSelector
     с поиском по id.
     */
    private By nameElement4 = By.cssSelector("#email");
    private By passwordElement4 = By.cssSelector("#password");
    private By buttonEnterElement4 = By.cssSelector("#submit");
    private By resultErrorElement4 = By.cssSelector("#error");
    @Test
    public void testSockLoversClub4(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(nameElement4).sendKeys("@");
        driver.findElement(passwordElement4).sendKeys("123");
        driver.findElement(buttonEnterElement4).click();
        Assert.assertTrue("не отобразился текст про ошибку авторизации", driver.findElement(resultErrorElement4).isDisplayed());
        var expectedText = "Некорректный email или пароль";
        var actualResult4 = driver.findElement(resultErrorElement4).getText();
        Assert.assertEquals("неправильно отображается текст про ошибку", expectedText, actualResult4);
    }
    /* 5. Используйте сценарий и тест, как в задании 2. Элементы с одним классом ищите с помощью By.cssSelector с
    поиском по id, тегу и классу одновременно. Элементы с двумя классами ищите по id, тегу и двум классам.
     */
    private By nameElement5 = By.cssSelector("input#email.form-input.input-data");
    private By passwordElement5 = By.cssSelector("input#password.form-input.password");
    private By buttonEnterElement5 = By.cssSelector("button#submit.form-submit");
    private By resultErrorElement5 = By.cssSelector("pre#error.form-error-password-email");
    @Test
    public void testSockLoversClub5(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(nameElement5).sendKeys("@");
        driver.findElement(passwordElement5).sendKeys("123");
        driver.findElement(buttonEnterElement5).click();
        Assert.assertTrue("не отобразился текст про ошибку авторизации", driver.findElement(resultErrorElement5).isDisplayed());
        var expectedText = "Некорректный email или пароль";
        var actualResult5 = driver.findElement(resultErrorElement5).getText();
        Assert.assertEquals("неправильно отображается текст про ошибку", expectedText, actualResult5);
    }

}
