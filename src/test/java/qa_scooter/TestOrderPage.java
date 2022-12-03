package qa_scooter;

import Pages.MainPage;
import Pages.FirstOrderPage;
import Pages.SecondOrderPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class TestOrderPage {

    private final String firstName;
    private final String secondName;
    private final String streetName;
    private final String metroStantion;
    private final String phoneNumber;
    private final String dataFields;
    private final String commentField;

    WebDriver driver;

    public TestOrderPage(String firstName, String secondName, String streetName, String metroStantion, String phoneNumber, String dataFields, String commentField) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.streetName = streetName;
        this.metroStantion = metroStantion;
        this.phoneNumber = phoneNumber;
        this.dataFields = dataFields;
        this.commentField = commentField;
    }

    @Parameterized.Parameters
    public static Object[][] getCostumersData() {
        return new Object[][] {
                { "Владимир", "Ианович", "Ломоносова 7", "Чистые пруды", "89001234567", "31.12.2022", "Хорошо"},
                { "Ivanov", "Сергей", "Московская 10", "Павелецкая", "+79001234567","31.12.2022", "Всем спасибо!"},
                {"Петя", "Fox", "Краснодарская ул.10", "Киевская", "0987654321", "31.12.2022", "спасибо" },
                {"Алена", "Иванова", "Street 25", "Электрозаводская", "0987654321", "31.12.2022", "Еще пиццы" },
                {"Алена", "Иванова", "Григорьева д.123 кв 34", "Paveleckay", "0987654321", "31.12.2022", "Оставить у двери" },
                {"Алена", "Иванова", "Григорьева д.123 кв 34", "Пушкинская", "МобNb1233", "31.12.2022", "Оставить у двери" },
                {"Алена", "Иванова", "Григорьева д.123 кв 34", "Третьяковская", "89001234567", "31.12.2021", "Оставить у двери" },
                {"Алена", "Иванова", "Григорьева д.123 кв 34", "Третьяковская", "89001234567", "31.12.2022", "Spasibo" },

        };
    }

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
        // Закрыть окно про куки
        objMainPage.clickSignInButton();
    }

  @Test
    public void testUpOrderButton ()  {
      // создать объект класса главной страницы
      MainPage objMainPage = new MainPage(driver);
      objMainPage.clickOrderUpButton();
        // создать объект класса 2 страницы заказа;
       FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
       // Заполнить форму 1
       firstOrderPage.fillFirstPage(firstName, secondName, streetName, metroStantion,phoneNumber);
     // Нажать кнопку Далее
      firstOrderPage.setNextButton();
      // создаем объект класса 3 страницы заказа
      SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
      // Заполнили форму 2
      secondOrderPage.fillSecondPage(dataFields,commentField);
      //Нажали кнопку заказать
      secondOrderPage.clicOrderBook();
      // нажатия кнопки подтверждения заказа
      secondOrderPage.setOrderConfirmation();
      //получение текста из подтверждения заказа
      String orderText = secondOrderPage.getOrderSocsessText();
      MatcherAssert.assertThat(orderText, containsString("Заказ оформлен"));
    }

    @Test
    public void testDownOrderButton () {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Скролл и клик нижней кнопки Заказать
        objMainPage.goToDownOrderButton();
        // создать объект класса 2 страницы заказа;
        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        // Выполнили шаг заполнения формы 1
        firstOrderPage.fillFirstPage(firstName, secondName, streetName, metroStantion, phoneNumber);
        // Нажали кнопку для перехода в форму 2
        firstOrderPage.setNextButton();
        // создали объект класса 3 страницы заказа
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        // Выполнили шаг заполнения формы 2
        secondOrderPage.fillSecondPage(dataFields,commentField);
        //Нажали кнопку заказать
        secondOrderPage.clicOrderBook();
        // нажатия кнопки подтверждения заказа
        secondOrderPage.setOrderConfirmation();
        //получение текста из подтверждения заказа
        String orderText = secondOrderPage.getOrderSocsessText();
        MatcherAssert.assertThat(orderText, containsString("Заказ оформлен"));
    }

   @After
   public void quit() {
   driver.quit();
    }
}
