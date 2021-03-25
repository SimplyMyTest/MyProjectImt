import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class module7 {
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
    /*Для сайта домашнего кинотеатра составьте XPath-локаторы следующих элементов:

1.Кнопка перехода к предыдущему объявлению в слайдере «<». <span class="da-arrows-prev"></span>
2.Кнопка «Узнать больше» в слайдере. Используйте поиск сразу по двум классам. <a href="#" class="da-link
button">Узнать больше</a>
3.Все неактивные фильтры из раздела фильмов, которые есть в онлайн-кинотеатре.
<ul class="nav nav-pills">

                    <li class="filter active" data-filter="all">

                        <a href="#noAction">Все</a>

                    </li>

                    <li class="filter" data-filter="web">

                        <a href="#noAction">Семейные</a>

                    </li>

                    <li class="filter" data-filter="photo">

                        <a href="#noAction">Драмы</a>

                    </li>

                    <li class="filter" data-filter="identity">

                        <a href="#noAction">Комедии</a>

                    </li>

</ul>



Все элементы, у которых класс начинается на слова «button».
Кнопка «Подписаться сейчас».
Все картинки клиентов из раздела «Наши клиенты». Для уточнения локатора используйте указание ближайшего родительского элемента с id.
* Все элементы с ценами тарифов, следующих после тарифа «Любительский».
* Все поля для ввода в форме «Скажите "Привет"», которые предшествуют полю «* Текст сообщения».
*/
    public void testSinemaPark() {
        driver.navigate().to("http://qa.skillbox.ru/module19/");
        var firstLocator = By.cssSelector("//*[@class='da-arrows-prev']");
        var secondLocator = By.cssSelector("//a[@href='#'][@class='da-link button']");
        var threeLocator = By.cssSelector("//ul[@class='nav nav-pills']/li");
        var fourLocator = By.cssSelector("//*[starts-with(@class,'button')]");
        var fiveLocator = By.cssSelector("//a[@href='#' and @class='button']");
        var sixLocator = By.cssSelector("//ul[@id='clint-slider']//img");
        var sevenLocator = By.cssSelector("//div[@class='price-table row-fluid']//*[contains(@class,'price')]");
        var eightLocator = By.cssSelector("//*[@id='name']");
        var nineLocator = By.cssSelector("//*[@id='email']");

    }
   /* Задание 2. Онлайн-институт

    Для сайта онлайн-института составьте XPath-локаторы следующих элементов:

    Заголовок пятого курса.
    Элемент с учебным периодом последнего курса.
            * Все div, которые являются непосредственными родителями для ссылок с href='#'.
            * Преобразуйте предыдущий локатор, чтобы он возвращал пятый элемент.
* Все родительские элементы заголовка «Все курсы».*/
    public void testOnlineInstitute(){
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        var firstLocator = By.cssSelector("//*[@class='baseCard__wrapper']//span[5]");
        var secondLocator = By.cssSelector("((//span)[last()]");
        var threeLocator = By.cssSelector("//div[@id]");
        var fourLocator = By.cssSelector("//div[@id]//div[5]");
        var fiveLocator = By.cssSelector("//*[text()='Все курсы']/parent::*");
    }
    /*
    Применяя правила построения хороших локаторов, составьте XPath-локаторы для следующих элементов на сайте книжного магазина:
    Ссылка «О магазине» в футере.
Заголовок «Бестселлеры».
Строка поиска.
Итоговая сумма заказа в корзине.
Заголовок «Ваш заказ: » в корзине.
Кнопка «Отменить» на странице поиска.
     */
    public void testMagazine(){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        var firstLocator = By.cssSelector("//*[text()='О магазине']");
        var secondLocator = By.cssSelector("//*[@id='genres']/../li");
        var threeLocator = By.cssSelector("//*[@id='search-input']");
        var fourLocator = By.cssSelector("//*[@id='total']");
        var fiveLocator = By.cssSelector("//*[text()='Ваш заказ']");
        var sixLocator = By.cssSelector("//*[@class='filter-button']");
    }
}