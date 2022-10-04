package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class ClassForPageOrder {

    //драйвер для браузера
    private WebDriver driver;

    public ClassForPageOrder(WebDriver driver) {
        this.driver = driver;
    }

    //локатор поля ввода имени
     private  static final By FIELDINNAME = By.xpath(".//input[@placeholder = '* Имя']");

    //локатор поля ввода фамилии
     private  static final By FIELDINSURENAME = By.xpath(".//input[@placeholder = '* Фамилия']");

    //локатор поля ввода адреса
     private  static final By FIELDINADDRESS =
            By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    //локатор поля ввода станции метро
     private  static final By FIELDINSTATIONMETRO = By.xpath(".//input[@placeholder = '* Станция метро']");

    //локатор первого варианта в выпадающем списке станций метро
     private  static final By FIELDFIRSTSTATION =
            By.xpath(".//li[@class = 'select-search__row'][@data-index = '0']");

    //локатор поля ввода номера телефона
     private  static final By FIELDPHONE =
            By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    //локатор кнопки далее
     private  static final By FIELDNEXT =
            By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM'][text() = 'Далее']");

    //про аренду
    //локатор поля ввода даты аренды самоката
     private  static final By FIELDINDATA = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    //локатор поля ввода времени аренды
    private  static final By FIELDINDATARENTA = By.xpath(".//span[@class = 'Dropdown-arrow']");

    //Выбор элемента выпадающего списка с временем аренды
    public WebElement getRentalRangeByText(String range) {
        List<WebElement> menu = driver.findElements(By.className("Dropdown-option"));
        WebElement element = driver.findElement(By.className("Dropdown-menu"));
        for (WebElement webElement : menu) {
            if(webElement.getText().equals(range)) {
                element = webElement;
                break;
            }
        }
        return element;
    }

    //локатор поля ввода комментария для курьера
     private  static final By FIELDINCOMMENTFORCOURIER =
            By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");


    //локатор кнопки заказать (нижняя)
     private  static final By BUTTONMAKEORDERDOWN =  By.xpath
            (".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM'][text() = 'Заказать']");

    //локатор кнопки подтверждения заказа
     private  static final By BUTTONCONFIRMORDER =
            By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM'][text() = 'Да']");


    //локатор вспывающего окна об успешном заказе
     private  static final By WINDOWSUCCESSORDER = By.className("Order_Modal__YZ-d3");

    //локатор текста с номером заказа
    private  static final By NUMBERORDER =  By.className("Order_ModalHeader__3FDaJ");

    //клик и ввод имени
    public ClassForPageOrder clickAndInputName(String name) {
        driver.findElement(FIELDINNAME).click();
        driver.findElement(FIELDINNAME).sendKeys(name);
        return this;
    }

    //клик и ввод Фамилии
    public ClassForPageOrder clickAndInputSurname(String surname) {
        driver.findElement(FIELDINSURENAME).click();
        driver.findElement(FIELDINSURENAME).sendKeys(surname);
        return this;
    }

    //клик и ввод Адреса
    public ClassForPageOrder clickAndInputAddress(String address) {
        driver.findElement(FIELDINADDRESS).click();
        driver.findElement(FIELDINADDRESS).sendKeys(address);
        return this;
    }

    //клик и ввод Станции метро
    public ClassForPageOrder clickAndInputStation(String station) {
        driver.findElement(FIELDINSTATIONMETRO).click();
        driver.findElement(FIELDINSTATIONMETRO).sendKeys(station);
        driver.findElement(FIELDFIRSTSTATION).click();
        return this;
    }

    //клик и ввод Телефона
    public ClassForPageOrder clickAndInputPhone(String phone) {
        driver.findElement(FIELDPHONE).click();
        driver.findElement(FIELDPHONE).sendKeys(phone);
        return this;
    }

    //клик по кнопке Далее
    public ClassForPageOrder clickNext() {
        driver.findElement(FIELDNEXT).click();
        return this;
    }

    //клик и ввод "Когда привезти"
    public ClassForPageOrder fillRentalDate(String date) {
        driver.findElement(FIELDINDATA).click();
        driver.findElement(FIELDINDATA).sendKeys(date);
        return this;
    }

    //метод клика по полю ввода Срока аренды и ввод
    public ClassForPageOrder fillRentalRange(String range) {
        driver.findElement(FIELDINDATARENTA).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-menu")));
        getRentalRangeByText(range).click();
        return this;
    }

    //метод выбора цвета самоката
    private ClassForPageOrder setColor(String color) {
        List<WebElement> menu = driver.findElements(By.className("Checkbox_Label__3wxSf"));
        for (WebElement webElement : menu) {
            if(webElement.getText().equals(color)) {
                webElement.click();
                break;
            }
        }
        return this;
    }

    //метод клика по полю ввода Комментария и ввод
    public ClassForPageOrder fillComment(String comment) {
        driver.findElement(FIELDINCOMMENTFORCOURIER).click();
        driver.findElement(FIELDINCOMMENTFORCOURIER).sendKeys(comment);
        return this;
    }

    //метод клика по кнопке Заказать
    public ClassForPageOrder makeOrder() {
        driver.findElement(BUTTONMAKEORDERDOWN).click();
        return this;
    }

    //метод клика по кнопке подтверждения заказа (Да)
    public ClassForPageOrder clickYesOrderButton() {
        driver.findElement(BUTTONCONFIRMORDER).click();
        return this;
    }

    //метод проверки того, что появилось всплывающее окно с сообщением "Заказ оформлен"
    public void successfulOrder() {
        boolean flag = driver.findElement(WINDOWSUCCESSORDER).isDisplayed()
                && driver.findElement(NUMBERORDER).getText().contains("Заказ оформлен");
        assertTrue(flag);
    }

    //Вводим имя, фамилию, адрес, станцию метро, номер телефона
    public ClassForPageOrder fillFirstForm(String name, String surname, String address,
                                           String metroStation, String phoneNumber) {
        return this.clickAndInputName(name)
                .clickAndInputSurname(surname)
                .clickAndInputAddress(address)
                .clickAndInputStation(metroStation)
                .clickAndInputPhone(phoneNumber);
    }

    //Вводим дату аренды, срок аренды, цвет самоката, комментарий курьеру
    public ClassForPageOrder fillSecondForm(String rentalDate, String rentalRange, String color, String comment) {

        return this.fillRentalDate(rentalDate)
                .fillRentalRange(rentalRange)
                .setColor(color)
                .fillComment(comment);
    }
}
