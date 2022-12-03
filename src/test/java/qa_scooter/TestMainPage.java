package qa_scooter;

import Pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestMainPage  {
WebDriver driver;

    @Before
    public void startDriver () {
        //Драйвер
       driver = new ChromeDriver();
       //driver = new FirefoxDriver();
        // Разернули окно
        driver.manage().window().maximize();
        // Переход на главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Закрытьокно про куки
        objMainPage.clickSignInButton();
    }

    @Test
    public void testMainPage()  throws InterruptedException {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Скролл до Вопросы о важном
        objMainPage.scrollToMainQwestion();

        objMainPage.clickFirstAccordionBlock();
        Thread.sleep(500);
        String zeroText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст не совпал!","Сутки — 400 рублей. Оплата курьеру — наличными или картой.", zeroText);

        objMainPage.clickSecondAccordionBlock();
        Thread.sleep(500);
        String firstText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст не совпал!","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", firstText);

        objMainPage.clickThirdAccordionBlock();
        Thread.sleep(500);
        String secondText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст не совпал!","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", secondText);


        objMainPage.clickFofthAccordionBlock();
        Thread.sleep(500);
        String thText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст не совпал!","Только начиная с завтрашнего дня. Но скоро станем расторопнее.", thText);

        objMainPage.clickFifthAccordionBlock();
        Thread.sleep(500);
        String foText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст не совпал!","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", foText);

        objMainPage.clickSixthAccordionBlock();
        Thread.sleep(500);
        String fifText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст не совпал!","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", fifText);

        objMainPage.clickSeventhAccordionBlock();
        Thread.sleep(500);
        String sixText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст не совпал!","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", sixText);


        objMainPage.clickEighthAccordionBlock();
        Thread.sleep(500);
        String sevText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст не совпал!","Да, обязательно. Всем самокатов! И Москве, и Московской области.", sevText);
        }

    // Закрыть браузер
    @After
  public void quit() {
       driver.quit();
    }
}





