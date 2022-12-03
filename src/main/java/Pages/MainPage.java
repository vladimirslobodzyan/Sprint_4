package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Создали page object — класс для страницы Main
public class MainPage {
    // Добавили поле driver
    private WebDriver driver;

    //Добавили локатор кнопки "Куки"
    private By cookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //Добавили локатор до тексат "Вопросы о важном"
    private By mainQwestionText = By.xpath("//div[text()='Вопросы о важном']");

    // Добавили локатор accordionBlock_0 с вопросами и ответами
    public By firstAccordionBlock = By.xpath("//div[@id='accordion__heading-0']");

    // Добавили локатор accordionBlock_1 с вопросами и ответами
    public By secondAccordionBlock = By.xpath("//div[@id='accordion__heading-1']");

    // Добавили локатор accordionBlock_2 с вопросами и ответами
    public By thirdAccordionBlock = By.xpath("//div[@id='accordion__heading-2']");

    // Добавили локатор accordionBlock_3 с вопросами и ответами
    public By fofthAccordionBlock = By.xpath("//div[@id='accordion__heading-3']");

    // Добавили локатор accordionBlock_4 с вопросами и ответами
    public By fifthAccordionBlock = By.xpath("//div[@id='accordion__heading-4']");

    // Добавили локатор accordionBlock_6 с вопросами и ответами
    public By sixthAccordionBlock = By.xpath("//div[@id='accordion__heading-5']");

    // Добавили локатор accordionBlock_7 с вопросами и ответами
    public By seventhAccordionBlock = By.xpath("//div[@id='accordion__heading-6']");

    // Добавили локатор accordionBlock_8 с вопросами и ответами
    public By eighthAccordionBlock = By.xpath("//div[@id='accordion__heading-7']");

    //Добавили локатор ответа
    public By openAnswerText = By.xpath("//div[@aria-expanded='true']/parent :: div/parent::div/div[@class='accordion__panel']/p");

    //Добавили локатор верхней кнопки "Заказать"
    public By orderUpButton = By.xpath("//div/button[@class='Button_Button__ra12g']");

    //Добавили локатор нижней кнопки "Заказать"
    public By orderDownButton = By.xpath("//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    // Добавили конструктор класса page object
    public MainPage(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }

    //  Добавили метод, который кликает по кнопке «Куки»
    public void clickSignInButton() {
        driver.findElement(cookiesButton).click();
    }

    //Добавили метод, который делает скрол до текста "Вопросы о важном"
        public void scrollToMainQwestion() {
            WebElement element = driver.findElement(mainQwestionText);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        }

    //Добавили метод, скролл до нидней кнопки заказать
    public void scrollToOrderButton() {
        WebElement element = driver.findElement(orderDownButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Добавили метод нажатия на первый вопрос
    public void clickFirstAccordionBlock() {
        driver.findElement(firstAccordionBlock).click();
    }

    //Добавили метод нажатия на второй  вопрос
    public void clickSecondAccordionBlock() {
        driver.findElement(secondAccordionBlock).click();
    }

    //Добавили метод нажатия на третий  вопрос
    public void clickThirdAccordionBlock() {
        driver.findElement(thirdAccordionBlock).click();
    }

    //Добавили метод нажатия на четвертый  вопрос
    public void clickFofthAccordionBlock() {
        driver.findElement(fofthAccordionBlock).click();
    }

    //Добавили метод нажатия на пятый  вопрос
    public void clickFifthAccordionBlock() {
        driver.findElement(fifthAccordionBlock).click();
    }

    //Добавили метод нажатия на шестой  вопрос
    public void clickSixthAccordionBlock() {
        driver.findElement(sixthAccordionBlock).click();
    }

    //Добавили метод нажатия на седьмой  вопрос
    public void clickSeventhAccordionBlock() {
        driver.findElement(seventhAccordionBlock).click();
    }

    //Добавили метод нажатия на восьмой  вопрос
    public void clickEighthAccordionBlock() {
        driver.findElement(eighthAccordionBlock).click();
    }

    //Добавили метод получения текста ответа
    public String getOpenAnswerText() {
        String textElement = driver.findElement(openAnswerText).getText();
        return textElement;
    }

    //Добавили метод нажатия на верхнюю кнопку Заказть
    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }

    //Добавили метод нажатия на нижнюю кнопку Заказть
    public void clickOrderDownButton() {
        driver.findElement(orderDownButton).click();
    }

    //Добавим шаг скролл и нажатие на нижнюю кнопку заказать
    public void goToDownOrderButton() {
        scrollToOrderButton();
        clickOrderDownButton();

    }
    }
