import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkTest {
    /*(Модуль 2 задание 4)4. Для усложнённой версии сайта приветствия (https://lm.skillbox.ru/qa_tester/module02/homework1/)

напишите браузерные тесты с использованием JUnit и Selenium WebDriver, применяя привычные вам техники
 тест-дизайна. Напишите не менее пяти тестов. Поиск элементов на этой странице можно осуществлять по классу
  или атрибуту name, аналогично рассмотренному примеру в этом уроке.
     */
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
    public void testAllFieldsHello(){
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

    }
    @Test
    public void testEmptyFieldsHello(){
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testThirtyFieldsHello(){
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void testFortyFieldsHello(){
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("phone")).sendKeys("+7900-000-00-00");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +7900-000-00-00.";
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void testFiftyFieldsHello(){
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, .\n" +
                "На вашу почту (test@test.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void sixtyFieldsHello(){
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
    }
    @Test
    public void testLocators(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var passwordConfirmElement = driver.findElement(By.name("confirm_password"));
        var buttonElement = driver.findElement(By.tagName("button"));
        var headerElementResult = driver.findElement(By.tagName("h3"));
        var password = "123";
        var email = "test@test.ru";
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        passwordConfirmElement.sendKeys(password);
        buttonElement.click();
        var emailResultElement = driver.findElement(By.linkText(email));
        var emailResultElement2 = driver.findElement(By.partialLinkText(email));
        Assert.assertEquals("неверный текст при успешной регистрации", "Спасибо за регистрацию!",headerElementResult.getText());
        Assert.assertEquals("неверный email при успешной регистрации", email, emailResultElement.getText());
    }
    /* (Модуль 3 задание 4) Запишите не менее трёх тестов для сайта кинотеатра.

В первом тесте реализуйте следующий сценарий:

введите текст в поле «Ваши любимые фильмы»;
введите текст в поле «Ваши любимые сериалы»;
нажмите «Сохранить»;
нажмите на кнопку «2»;
нажмите на кнопку «ВВОД»;
нажмите на кнопку «ОК»;
проверьте, что после нажатия кнопки «ОК» появился текст и он равен тому, который вы вводили в поле «Ваши любимые фильмы»;
проверьте, что после нажатия кнопки «ОК» появился текст и он равен тому, который вы вводили в поле «Ваши любимые сериалы».
Сценарии остальных тестов выберите на своё усмотрение, опираясь на техники тест-дизайна. Для поиска элементов в тесте по возможности используйте все изученные стратегии поиска.

*/
    @Test
    public void testLocatorsHomeWork(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var filmElement = driver.findElement(By.tagName("input"));
        var serialElement = driver.findElement(By.name("serials"));
        var saveButtonElement = driver.findElement(By.id("save"));
        var twoButtonElement = driver.findElement(By.id("two"));
        var enterElement = driver.findElement(By.id("save"));
        var okElement = driver.findElement(By.id("ok"));
        var filmResultElement = driver.findElement(By.className("result__text"));
        var serialResultElement = driver.findElement(By.id("best_serials"));
    }

    @Test
    public void testLocatorsHomeWork2(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.tagName("input")).sendKeys("Матрица");
        driver.findElement(By.name("serials")).sendKeys("Сверхъестественное");
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.tagName("span")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var actualTextFilm = driver.findElement(By.id("best_films")).getText();
        var expectedTextFilm = "Матрица";
        Assert.assertEquals(expectedTextFilm, actualTextFilm);
    }

    @Test
    public void testLocatorsHomeWork3(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var headerElement = driver.findElement(By.className("header__content"));
        var twoButtonElement = driver.findElement(By.id("two"));
        var headerElement2 =  driver.findElement(By.className("header__content"));
        var okElement = driver.findElement(By.id("ok"));
    }
    /* (Модуль 3 задание 3)Запишите тест для сайта книжного магазина. В тесте осуществите переход на сайт, найдите с помощью
     функции findElements
    все элементы <div class="book-info"> и в конце проверьте, что их ровно 15 штук.
     */
    @Test
    public void testBookMagazine(){
        driver.navigate().to("http://qajava.skillbox.ru/");
        var bookElement = driver.findElements(By.className("book-info"));
        var expectedResult = 15;
        Assert.assertEquals(15, bookElement.size());
    }
    /* (Модуль 3 задание 2) Запишите тест для сайта книжного магазина http://qajava.skillbox.ru/.

В тесте сделайте переход на сайт и найдите с помощью функции findElement следующие элементы:

ссылку «Обратная связь» в самом низу страницы <a href="">Обратная связь</a>;
ссылку «Предзаказы» в самом низу страницы <a href="">Предзаказы</a>;
кнопку «В корзину» у первой книги <button class="book-add" onclick="AddToCart(this.parentElement)">;
цифру с количеством товаров в корзинке у значка корзины справа вверху <span id="cart_count">;
пункт меню «Книги» <li id="genres">;
поле поиска по магазину <input name="search-input-form" id="search-input" type="text"
 placeholder="Поиск по магазину..." autocomplete="off" maxlength="100" value="">.
Обратите внимание, что в этом тесте не будет никаких действий, только поиск элементов по локаторам.*/
  @Test
  public void testMagazineBook(){
      driver.navigate().to("http://qajava.skillbox.ru/.");
      var feedBackElement = driver.findElement(By.linkText("Обратная связь"));
      var preOrdersElement = driver.findElement(By.linkText("Предзаказы"));
      var buttonBasketElement = driver.findElement(By.className("book-info"));
      var countElement = driver.findElement(By.id("cart_count"));
      var bookMenuElement = driver.findElement(By.id("genres"));
      var searchElement = driver.findElement(By.id("search"));
  }
  /*(Модуль 3 задание 1)Запишите один тест на негативный сценарий для сайта магазина обуви https://lm.skillbox.ru/qa_tester/module03/practice1/.

Примените известные вам техники тест-дизайна при составлении сценария. Добавьте к нему позитивный тест
 из практики третьего урока. И вынесите отдельно в setUp и tearDown-методы подготовительную работу по настройке
  драйвера, открытию и закрытию браузера.
 Не забудьте в проверках в тесте первым параметром указать текст на случай, если тест не пройдёт.
   */
  @Test
    public void testMagazineShoes(){
      driver.navigate().to("https://lm.skillbox.ru/qa_tester/module03/practice1/.");
      driver.findElement(By.id("size")).sendKeys("45");
      driver.findElement(By.className("input-field")).click();
      var actualResult = driver.findElement(By.name("check")).getText();
      var expectedResult = "В нашем магазине нет обуви вашего размера";
      Assert.assertEquals("неправильный текст при успешном заполнении", expectedResult, actualResult);
  }

}
