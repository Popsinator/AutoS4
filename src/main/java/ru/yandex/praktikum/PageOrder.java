package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class PageOrder {

    //драйвер для браузера
    private WebDriver driver;

    public PageOrder(WebDriver driver) {
        this.driver = driver;
    }

    //локатор поля ввода имени
     private final By fieldInName = By.xpath(".//input[@placeholder = '* Имя']");

    //локатор поля ввода фамилии
     private final By fieldInSurename = By.xpath(".//input[@placeholder = '* Фамилия']");

    //локатор поля ввода адреса
     private final By fieldInAddress =
            By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    //локатор поля ввода станции метро
     private final By fieldInStationMetro = By.xpath(".//input[@placeholder = '* Станция метро']");

    //локатор первого варианта в выпадающем списке станций метро
     private final By fieldFirstStation =
            By.xpath(".//li[@class = 'select-search__row'][@data-index = '0']");

    //локатор поля ввода номера телефона
     private final By fieldPhone =
            By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    //локатор кнопки далее
     private final By fieldNext =
            By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM'][text() = 'Далее']");

    //про аренду
    //локатор поля ввода даты аренды самоката
     private final By fieldInData = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    //локатор поля ввода времени аренды
    private final By fieldInDataRenta = By.xpath(".//span[@class = 'Dropdown-arrow']");

    //Выбор элемента выпадающего списка с временем аренды
    public PageOrder getRentalRangeByText(String range) {
        List<WebElement> menu = driver.findElements(By.className("Dropdown-option"));
        menu.stream().filter(x-> x.getText().equals(range)).findFirst().get().click();
        return this;
    }

    //локатор поля ввода комментария для курьера
     private final By fieldInCommentForCourier =
            By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");


    //локатор кнопки заказать (нижняя)
     private final By buttonMakeOrderDown =  By.xpath
            (".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM'][text() = 'Заказать']");

    //локатор кнопки подтверждения заказа
     private final By buttonConfirmOrder =
            By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM'][text() = 'Да']");


    //локатор вспывающего окна об успешном заказе
     private final By windowSuccessOrder = By.className("Order_Modal__YZ-d3");

    //локатор текста с номером заказа
    private final By numberOrder =  By.className("Order_ModalHeader__3FDaJ");

    //клик и ввод имени
    public PageOrder clickAndInputName(String name) {
        driver.findElement(fieldInName).click();
        driver.findElement(fieldInName).sendKeys(name);
        return this;
    }

    //клик и ввод Фамилии
    public PageOrder clickAndInputSurname(String surname) {
        driver.findElement(fieldInSurename).click();
        driver.findElement(fieldInSurename).sendKeys(surname);
        return this;
    }

    //клик и ввод Адреса
    public PageOrder clickAndInputAddress(String address) {
        driver.findElement(fieldInAddress).click();
        driver.findElement(fieldInAddress).sendKeys(address);
        return this;
    }

    //клик и ввод Станции метро
    public PageOrder clickAndInputStation(String station) {
        driver.findElement(fieldInStationMetro).click();
        driver.findElement(fieldInStationMetro).sendKeys(station);
        driver.findElement(fieldFirstStation).click();
        return this;
    }

    //клик и ввод Телефона
    public PageOrder clickAndInputPhone(String phone) {
        driver.findElement(fieldPhone).click();
        driver.findElement(fieldPhone).sendKeys(phone);
        return this;
    }

    //клик по кнопке Далее
    public PageOrder clickNext() {
        driver.findElement(fieldNext).click();
        return this;
    }

    //клик и ввод "Когда привезти"
    public PageOrder fillRentalDate(String date) {
        driver.findElement(fieldInData).click();
        driver.findElement(fieldInData).sendKeys(date);
        return this;
    }

    //метод клика по полю ввода Срока аренды и ввод
    public PageOrder fillRentalRange(String range) {
        driver.findElement(fieldInDataRenta).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-menu")));
        return getRentalRangeByText(range);
        //return this;
    }

    //метод выбора цвета самоката
    private PageOrder setColor(String color) {
        List<WebElement> menu = driver.findElements(By.className("Checkbox_Label__3wxSf"));
        menu.stream().filter( x-> x.getText().equals(color)).findFirst().get().click();
        return this;
    }

    //метод клика по полю ввода Комментария и ввод
    public PageOrder fillComment(String comment) {
        driver.findElement(fieldInCommentForCourier).click();
        driver.findElement(fieldInCommentForCourier).sendKeys(comment);
        return this;
    }

    //метод клика по кнопке Заказать
    public PageOrder makeOrder() {
        driver.findElement(buttonMakeOrderDown).click();
        return this;
    }

    //метод клика по кнопке подтверждения заказа (Да)
    public PageOrder clickYesOrderButton() {
        driver.findElement(buttonConfirmOrder).click();
        return this;
    }

    //метод проверки того, что появилось всплывающее окно с сообщением "Заказ оформлен"
    public void successfulOrder() {
        boolean flag = driver.findElement(windowSuccessOrder).isDisplayed()
                && driver.findElement(numberOrder).getText().contains("Заказ оформлен");
        assertTrue(flag);
    }

    //Вводим имя, фамилию, адрес, станцию метро, номер телефона
    public PageOrder fillFirstForm(String name, String surname, String address,
                                           String metroStation, String phoneNumber) {
        return this.clickAndInputName(name)
                .clickAndInputSurname(surname)
                .clickAndInputAddress(address)
                .clickAndInputStation(metroStation)
                .clickAndInputPhone(phoneNumber);
    }

    //Вводим дату аренды, срок аренды, цвет самоката, комментарий курьеру
    public PageOrder fillSecondForm(String rentalDate, String rentalRange, String color, String comment) {

        return this.fillRentalDate(rentalDate)
                .fillRentalRange(rentalRange)
                .setColor(color)
                .fillComment(comment);
    }
}
