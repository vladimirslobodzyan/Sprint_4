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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class TestOrderPage {

    private final String orderButtonLocator;
    private final String firstName;
    private final String secondName;
    private final String streetName;
    private final String metroStation;
    private final String phoneNumber;
    private final String dataFields;
    private final String commentField;

    WebDriver driver;

    public TestOrderPage(String orderButtonLocator, String firstName, String secondName, String streetName, String metroStation, String phoneNumber, String dataFields, String commentField) {
        this.orderButtonLocator = orderButtonLocator;
        this.firstName = firstName;
        this.secondName = secondName;
        this.streetName = streetName;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dataFields = dataFields;
        this.commentField = commentField;
    }

    @Parameterized.Parameters
    public static Object[][] getCostumersData() {
        return new Object[][] {
                //Проверям каждое поле формы для Chrome и FireFox на допустимость внесения кирилицы и латиницы
               { "//div/button[@class='Button_Button__ra12g']","Владимир", "Ианович", "Ломоносова 7", "Чистые пруды", "89001234567", "31.12.2022", "Хорошо"},
                { "//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']","Владимир", "Ианович", "Ломоносова 7", "Чистые пруды", "89001234567", "31.12.2022", "Хорошо"},
                // Проверка поля Имя
               /* {  "//div/button[@class='Button_Button__ra12g']","Ivanov", "Сергей", "Московская 10", "Павелецкая", "+79001234567","31.12.2022", "Всем спасибо!"},
                { "//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']","Ivanov", "Сергей", "Московская 10", "Павелецкая", "+79001234567","31.12.2022", "Всем спасибо!"},
                // Проверка поля Фамилия
                { "//div/button[@class='Button_Button__ra12g']","Петя", "Fox", "Краснодарская ул.10", "Киевская", "0987654321", "31.12.2022", "спасибо" },
                {"//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']","Петя", "Fox", "Краснодарская ул.10", "Киевская", "0987654321", "31.12.2022", "спасибо" },
               // Проверка поля Адрес
                { "//div/button[@class='Button_Button__ra12g']","Алена", "Иванова", "Street 25", "Электрозаводская", "0987654321", "31.12.2022", "Еще пиццы" },
                {"//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']","Алена", "Иванова", "Street 25", "Электрозаводская", "0987654321", "31.12.2022", "Еще пиццы" },
                // Проверка поля Станция метро
                { "//div/button[@class='Button_Button__ra12g']","Алена", "Иванова", "Григорьева д.123 кв 34", "Paveleckay", "0987654321", "31.12.2022", "Оставить у двери" },
                {"//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']","Алена", "Иванова", "Григорьева д.123 кв 34", "Paveleckay", "0987654321", "31.12.2022", "Оставить у двери" },
                //Проверка поля телефон
                { "//div/button[@class='Button_Button__ra12g']","Алена", "Иванова", "Григорьева д.123 кв 34", "Пушкинская", "МобNb1233", "31.12.2022", "Оставить у двери" },
                {"//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']","Алена", "Иванова", "Григорьева д.123 кв 34", "Пушкинская", "МобNb1233", "31.12.2022", "Оставить у двери" },
                // Проверка заказа не валидной датой
                { "//div/button[@class='Button_Button__ra12g']","Алена", "Иванова", "Григорьева д.123 кв 34", "Третьяковская", "89001234567", "31.12.2021", "Оставить у двери" },
                {"//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']","Алена", "Иванова", "Григорьева д.123 кв 34", "Третьяковская", "89001234567", "31.12.2021", "Оставить у двери" },
                // Проверка поля Коментарий
                { "//div/button[@class='Button_Button__ra12g']","Алена", "Иванова", "Григорьева д.123 кв 34", "Третьяковская", "89001234567", "31.12.2022", "Spasibo" },
                { "//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']", "Григорьева д.123 кв 34", "Третьяковская", "89001234567", "31.12.2022", "Spasibo" },*/
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

      driver.findElement(By.xpath(orderButtonLocator)).click();
        // создать объект класса 2 страницы заказа;
       FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
       // Заполнить форму 1
       firstOrderPage.fillFirstPage(firstName, secondName, streetName, metroStation,phoneNumber);
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

   @After
   public void quit() {
   driver.quit();
    }
}
