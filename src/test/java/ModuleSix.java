import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ModuleSix {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public  void setUp(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    /*1. Составьте такой CSS-локатор, по которому бы находились все элементы, отмеченные записью <!-- Нужен этот элемент -->.

a. <section class="header">

   <h1>Ежедневник</h1>

   <div>

        <p>На текущий год</p> <!-- Нужен этот элемент -->

   </div>

   <p>Первая запись</p> <!-- Нужен этот элемент -->

   <p>Вторая запись</p>  <!-- Нужен этот элемент -->

</section>

b. <section>

   <h1>Ежедневник</h1>

   <main>

        <div class="mainText text" name="mainBlock">

            <a href='#'>Посмотреть за предыдущий год</a><!-- Нужен этот элемент -->

        </div>

   </main>

   <div class="text">

        <a href='#'>На текущий год</a> <!-- Нужен этот элемент -->

        <div>

            <a href='#'>Еще ранее</a>

        </div>

   </div>

   <p>Первая запись</p>

   <p>Вторая запись</p>

</section>

c. <section>

   <h1>Ежедневник</h1>

   <div class="text">

        <div class="header" name="headerName">

            <a href='#'>Посмотреть за предыдущий год</a>

        </div>

   </div>

   <div class="text">

        <a href='#'>На текущий год</a> <!-- Нужен этот элемент -->

        <div>

            <a href='#'>Еще записи...</a>

        </div>

   </div>

   <div class="text">

        <a href='#'>За прошлый год</a>

        <div>

            <a href='#'>Еще записи...</a>

        </div>

   </div>

   <p>Первая запись</p>

   <p>Вторая запись</p>

</section>*/
    @Test
    public void testHomework() {
        driver.findElement(By.cssSelector("a[class='header'] div:first-child"));
        driver.findElement(By.cssSelector("a[header] p:nth-child"));
        driver.findElement(By.cssSelector("div[class='mainText'][name=mainBlock]>[href^=#]:nth-child"));
        driver.findElement(By.cssSelector("div.header.headerName>a[href=#]:nth-of-type(2)"));
    }
    /*
     2. Для сайта заказа такси составьте CSS-локаторы, в них:

Найдите тег input, у которого нет атрибута id.
Найдите все теги p, у которых одновременно выполняются два условия:
class начинается на слово "form";
class НЕ заканчивается на слово "error".
Найдите <div class="form-inner">, у него найдите первый по счёту элемент такого типа: <p class="form-row">.
     */
    @Test
    public void testGetTaxi(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
        driver.findElement(By.cssSelector("input[name=time]"));
        driver.findElement(By.cssSelector(".form.form :nth-child(1).form-row"));
        driver.findElement(By.cssSelector(".form.form :nth-child(2).form-row"));
        driver.findElement(By.cssSelector(".form.form :nth-child(3).form-row"));
        driver.findElement(By.cssSelector("label[class=form-label]"));

        driver.findElement(By.cssSelector("div.form-inner .form *:nth-of-type(2)"));

    }
    /*
    3. Для сайта онлайн-ежедневника составьте один тест, в котором:

Перейдите на страницу.
Кликните на заметку из списка заметок по центру экрана.
Дождитесь появления справа от заголовка выбранной записи в разделе «Все записи».
Проверьте, что у первой записи заголовок равен только что выбранной записи.
Проверьте, что у первой записи текст и заголовок равен только что выбранной записи.
Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
В разделе «Все записи» выберите самую верхнюю запись (первую).
Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
Дождитесь исчезновения записи в разделе «Все записи».
Проверьте, что справа в списке «Все записи» не видно записей.

     */
    @Test
    public void testNoteBook(){
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        driver.findElement(By.cssSelector("button.articlePreview__link")).click();
        var notePlansOfMounth = By.cssSelector("div.vb-content > div:nth-child(1) p.articlePreview__title");
        var expectedTitle = "План на следующий месяц";
        var notePlansOfText = By.cssSelector("div.vb-content > div:nth-child(1) p.articlePreview__text ");
        var expectedText = "Прочитать книгу «Искусство цвета».";
        var vbContent = By.cssSelector("div.vb-content *:nth-of-type(1) button.articlePreview__link");
        var pageArticle = By.cssSelector(".page__content.pageArticle__content");
        driver.findElement(By.cssSelector("div.articlePreview__buttons > button:nth-child(2) .articlePreview__icon")).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(notePlansOfMounth, expectedTitle));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(notePlansOfText, expectedText));
        Assert.assertEquals("не верно отображается заголовок",expectedTitle, driver.findElement(notePlansOfMounth).getText());
        Assert.assertEquals("не верно отображается текст",expectedText, driver.findElement(notePlansOfText).getText());

        driver.findElement(By.cssSelector(".pageArticle__buttons >.pageArticle__button:nth-child(2) svg.pageArticle__icon")).click();


        }





    //Это практика урока, не домашнее задание
    @Test
    public void testAddCourse(){
        driver.navigate().to("http://skillbox.mstprime.ru/16_2/#/");
        var firstButtonLocator = By.className("div.baseCard.pageCreate__card:nth-of-type(1) button");
        var lightBoxLocator = By.className("popup__content");
        var lightBoxTitleLocator = By.className("popup__title");
        var lightBoxButtonLocator = By.className("popup__button");

        driver.findElement(firstButtonLocator).click();

        var actualTitle = driver.findElement(lightBoxTitleLocator).getText();
        var expectedTitle = "Курс добавлен";
        Assert.assertTrue("не отображается текст", driver.findElement(lightBoxLocator).isDisplayed());
        Assert.assertEquals("неправильный заголовок лайтбокса для добавленного курса ", expectedTitle, actualTitle);
        driver.findElement(lightBoxButtonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lightBoxLocator));
        Assert.assertTrue("не исчез лайтбокс после нажатия", driver.findElements(lightBoxLocator).size()==0);
    }
}


