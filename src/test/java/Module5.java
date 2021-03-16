import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Module5 {
    /*1-2. Для сайта книжного магазина составьте, используя CSS:

Локаторы на странице http://qajava.skillbox.ru/index.html для элемента <a href="" test-info="about-us">О магазине</a>. Осуществите поиск только по атрибуту test-info, равному "about-us".
Локатор на странице http://qajava.skillbox.ru/index.html для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным "".
Локатор на странице http://qajava.skillbox.ru/search.html для всех элементов с тегом option и с атрибутом selected. Осуществите поиск только по атрибуту selected.
Локатор на странице http://qajava.skillbox.ru/index.html для элемента <div class="book-price">. Осуществите поиск одновременно по тегу и классу равному "book-price".
Локатор на странице http://qajava.skillbox.ru/index.html для всех элементов с тегом button и с атрибутом class, начинающимся на "book".
Локатор на странице http://qajava.skillbox.ru/index.html для всех элементов, у которых атрибут class заканчивается на "main".
Локатор на странице http://qajava.skillbox.ru/index.html для всех элементов с тегом a и с атрибутом class, содержащим в себе слово "menu".
На странице http://qajava.skillbox.ru/index.html найдите все теги div, которые являются дочерними элементами первого уровня у элемента <footer id="footer">.
На странице http://qajava.skillbox.ru/index.html найдите любой тег, который расположен сразу после <li id="genres">.
На странице http://qajava.skillbox.ru/search.html найдите любые теги, которые расположены после <div class="filter-container"> (не обязательно ближайший сосед).
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
    public void testSkillboxIndex(){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        var firstLocator = driver.findElement(By.cssSelector("a[href][test-info='about-us']"));
        var twoLocator = driver.findElement(By.cssSelector("a[href='']"));
        var fourLocator = driver.findElement(By.cssSelector("div.book-price"));
        var fiveLocator = driver.findElement(By.cssSelector("div > button"));
        var sevenLocator = driver.findElement(By.cssSelector("a[class*='menu']"));
        var eightLocator = driver.findElement(By.cssSelector("footer#footer > div"));
        var tenLocator = driver.findElement(By.cssSelector("li#genres > a:first-child"));

    }

    @Test
    public void testSkillboxSearch(){
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        var threeLocator = driver.findElement(By.cssSelector("select > option"));
        var sixLocator = driver.findElement(By.cssSelector("head >link[rel='stylesheet'][href*='main']"));
        var nineLocator = driver.findElement(By.cssSelector("div.filter-container > span + *"));
    }

    @Test
    /*
    3. Для сайта клуба любителей весёлых носков http://qajava.skillbox.ru/module05/auth/index.html составьте CSS-локаторы, в которых найдите:

первый тег h1, находящийся сразу на первом уровне вложенности внутри <section class="important-section-block" for="main-header-page">; Используйте поиск по первому child.
последний тег p, находящийся сразу на первом уровне вложенности внутри <form class="form" id="login-form">; Используйте поиск по child.
любой тег, который является третьим дочерним элементом первого уровня тега <body>; Используйте поиск по child.
все элементы с тегом <a>, которые являются первым элементом своего родителя <div class="footer__menuList">. Используйте поиск по type.
     */
    public void testSkillboxModule5(){
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        var elevenElement = driver.findElement(By.cssSelector("section > h1:first-child"));
        var twelveElement = driver.findElement(By.cssSelector("form#login-form> p:last-child"));
        var thirteenElement = driver.findElement(By.cssSelector("body> *:nth-child(3)"));
        var fourteenElement = driver.findElement(By.cssSelector("div.footer__menuList > a:nth-of-type(1)"));
    }
}
