package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondOrderPage {
    private WebDriver driver;

    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Добавили локатор *Когда привезти самокат
    public By dateField = By.xpath("//div/input[@placeholder='* Когда привезти самокат']");

    //Добавили локатор *Срок аренды
    public By orderArrowTimeField = By.xpath("//div/span[@class='Dropdown-arrow']");

    //Добавили локатор *Срок аренды drop down menu
    public By orderDropTimeField = By.xpath("//div[contains(text(),'двое суток')]"); ///div[contains(text(),'двое суток')'//div[@class='Dropdown-menu']/div[2]

    //Добавили локатор чек-бокс цвет
    public By colorScooterChek = By.xpath("//label[contains(text(),'чёрный жемчуг')]");

    //Добавили локатор Комментраий
    public By orderComment = By.xpath("//div/input[@placeholder='Комментарий для курьера']");

    //Добавили локатор кнопки Заказать
    public By orderBook = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(text(),'Заказать')]");

    //Добавили локатор подтверждения заказа
    public By orderConfirmation = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");

    //Добавили локатор текста подтверждения заказа
    public By orderSocsessText = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    //Добавили метод указывающий Дату заказа
    public void setDateOrdier(String dataFields){
        driver.findElement(dateField).sendKeys(dataFields);}
    //Добавили метод выбора срока аренды1
    public  void setOrderArrowTimeField(){
        driver.findElement(orderArrowTimeField).click();}
    //Добавили метод выбора срока аренды2
    public  void setOrderDropTimeField(){
        driver.findElement(orderDropTimeField).click();}
    //Добавили метод выбор цвета самоката
    public  void setColorScooterChek(){
        driver.findElement(colorScooterChek).click();}
    //Добавили метод добавления коментария
    public  void setOrderComments(String commentField){
        driver.findElement(orderComment).sendKeys(commentField);}
    //Добавили метод нажатия кнопки заказать
    public void clicOrderBook() {
        driver.findElement(orderBook).click();}
    // Добавили метод нажатия кнопки подтверждения заказа
    public  void setOrderConfirmation() {
        driver.findElement(orderConfirmation).click();
    }
    // Добавили метод получения текста из подтверждения заказа
    public String getOrderSocsessText() {
        String orderText = driver.findElement(orderSocsessText).getText();
        return orderText;
    }
    //Создаем шаг зполнение страницы 2
    public void fillSecondPage(String dataFields, String commentField) {
        setDateOrdier(dataFields);
        setOrderArrowTimeField();
        setOrderDropTimeField();
        setColorScooterChek();
        setOrderComments(commentField);
    }

}

