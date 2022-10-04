package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class MainPage {

    //драйвер для браузера
    private final WebDriver driver;

    private static final String URLSCOOTERYANDEX = "https://qa-scooter.praktikum-services.ru/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(URLSCOOTERYANDEX);
        return this;
    }

    //локатор кнопки заказать (верхняя)
     private final By buttonOrderUp = By.xpath(".//button[@class = 'Button_Button__ra12g']");

    //локатор кнопки заказать внизу страницы
     private final By buttonOrderDown =
            By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //локатор стрелочки: вопрос №1
     private final By arrowQuestion1 = By.id("accordion__heading-0");

    //сам вопрос №1
     private final By textQuestion1 = By.id("accordion__panel-0");

    //локатор стрелочки: вопрос о важном №2
     private final By arrowQuestion2 = By.id("accordion__heading-1");

    //сам вопрос №2
     private final By textQuestion2 = By.id("accordion__panel-1");

    //локатор стрелочки: вопрос о важном №3
     private final By arrowQuestion3 = By.id("accordion__heading-2");

    //сам вопрос №3
     private final By textQuestion3 = By.id("accordion__panel-2");

    //локатор стрелочки: вопрос о важном №4
     private final By arrowQuestion4 = By.id("accordion__heading-3");

    //сам вопрос №4
     private final By textQuestion4 = By.id("accordion__panel-3");

    //локатор стрелочки: вопрос о важном №5
     private final By arrowQuestion5 = By.id("accordion__heading-4");

    //сам вопрос №5
     private final By textQuestion5 = By.id("accordion__panel-4");

    //локатор стрелочки: вопрос о важном №6
     private final By arrowQuestion6 = By.id("accordion__heading-5");

    //сам вопрос №6
     private final By textQuestion6 = By.id("accordion__panel-5");

    //локатор стрелочки: вопрос №7
     private final By arrowQuestion7 = By.id("accordion__heading-6");

    //сам вопрос №7
     private final By textQuestion7 = By.id("accordion__panel-6");

    //локатор стрелочки: вопрос №8
     private final By arrowQuestion8 = By.id("accordion__heading-7");

    //сам вопрос №8
     private final By textQuestion8 = By.id("accordion__panel-7");

    //локатор CookieButton
     private final By elementCookie = By.className("App_CookieButton__3cvqF");

     private final List<By> elementArrow = Arrays.asList(arrowQuestion1, arrowQuestion2, arrowQuestion3, arrowQuestion4,
             arrowQuestion5, arrowQuestion6, arrowQuestion7, arrowQuestion8);

    private final List<By> elementText = Arrays.asList(textQuestion1, textQuestion2, textQuestion3, textQuestion4,
            textQuestion5, textQuestion6, textQuestion7, textQuestion8);


    //метод клика по кнопке Cookie, если необходимо
    public MainPage clickCookieButton() {
        if (driver.findElement(elementCookie).isDisplayed()) {
            driver.findElement(elementCookie).click();
        }
        return this;
    }

    //метод клика по стрелочке: вопрос о важном №1, и проверка текста
    public void clickAndCheckAnswerOnQuestion(String text, int number, boolean isDisplayedText) {

        scroll(driver.findElement(elementArrow.get(number)));
        driver.findElement(elementArrow.get(number)).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.
                textToBePresentInElementLocated(elementText.get(number), text));
        assertEquals(isDisplayedText, driver.findElement(elementText.get(number)).isDisplayed());
        assertEquals(driver.findElement(elementText.get(number)).getText(), text);
    }

    //метод клика по верхней кнопке заказать
    public PageOrder clickOrderUpButton() {
        driver.findElement(buttonOrderUp).click();
        return new PageOrder(driver);
    }

    //метод клика по нижней кнопке заказать
    public PageOrder clickOrderDownButton() {
        if (driver.findElement(buttonOrderDown).isDisplayed()) {
            scroll(driver.findElement(buttonOrderDown));
            driver.findElement(buttonOrderDown).click();
        }
        return new PageOrder(driver);
    }

    //скролл до элемента
    public void scroll(WebElement arrowQuestion) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrowQuestion);
    }
}
