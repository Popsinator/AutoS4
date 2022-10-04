package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MasterPage {

    //драйвер для браузера
    private final WebDriver driver;

    private static final String URLSCOOTERYANDEX = "https://qa-scooter.praktikum-services.ru/";

    public MasterPage(WebDriver driver) {
        this.driver = driver;
    }

    public MasterPage open() {
        driver.get(URLSCOOTERYANDEX);
        return this;
    }



    //локатор кнопки заказать (верхняя)
     private static final By BUTTONORDERUP = By.xpath(".//button[@class = 'Button_Button__ra12g']");

    //локатор кнопки заказать внизу страницы
     private static final By BUTTONORDERDOWN =
            By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //локатор стрелочки: вопрос №1
     private static final By ARROWQUESTION1 = By.id("accordion__heading-0");

    //сам вопрос №1
     private static final By TEXTQUESTION1 = By.id("accordion__panel-0");

    //локатор стрелочки: вопрос о важном №2
     private static final By ARROWQUESTION2 = By.id("accordion__heading-1");

    //сам вопрос №2
     private static final By TEXTQUESTION2 = By.id("accordion__panel-1");

    //локатор стрелочки: вопрос о важном №3
     private static final By ARROWQUESTION3 = By.id("accordion__heading-2");

    //сам вопрос №3
     private static final By TEXTQUESTION3 = By.id("accordion__panel-2");

    //локатор стрелочки: вопрос о важном №4
     private static final By ARROWQUESTION4 = By.id("accordion__heading-3");

    //сам вопрос №4
     private static final By TEXTQUESTION4 = By.id("accordion__panel-3");

    //локатор стрелочки: вопрос о важном №5
     private static final By ARROWQUESTION5 = By.id("accordion__heading-4");

    //сам вопрос №5
     private static final By TEXTQUESTION5 = By.id("accordion__panel-4");

    //локатор стрелочки: вопрос о важном №6
     private static final By ARROWQUESTION6 = By.id("accordion__heading-5");

    //сам вопрос №6
     private static final By TEXTQUESTION6 = By.id("accordion__panel-5");

    //локатор стрелочки: вопрос №7
     private static final By ARROWQUESTION7 = By.id("accordion__heading-6");

    //сам вопрос №7
     private static final By TEXTQUESTION7 = By.id("accordion__panel-6");

    //локатор стрелочки: вопрос №8
     private static final By ARROWQUESTION8 = By.id("accordion__heading-7");

    //сам вопрос №8
     private static final By TEXTQUESTION8 = By.id("accordion__panel-7");

    //локатор CookieButton
     private static final By ELEMENTCOOKIE = By.className("App_CookieButton__3cvqF");


    //метод клика по кнопке Cookie, если необходимо
    public MasterPage clickCookieButton() {
        if (driver.findElement(ELEMENTCOOKIE).isDisplayed()) {
            driver.findElement(ELEMENTCOOKIE).click();
        }
        return this;
    }

    //метод клика по стрелочке: вопрос о важном №1, и проверка текста
    public void clickQuestion1() {
        scroll(driver.findElement(ARROWQUESTION1));
        driver.findElement(ARROWQUESTION1).click();
        String text = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        new WebDriverWait(driver, 3).until(ExpectedConditions.
                textToBePresentInElementLocated(By.id("accordion__panel-0"), text));
        assertTrue(driver.findElement(TEXTQUESTION1).isDisplayed());
        assertEquals(driver.findElement(TEXTQUESTION1).getText(), text);
    }

    //метод клика по стрелочке: вопрос о важном №2, и проверка текста
    public void clickQuestion2() {
        scroll(driver.findElement(ARROWQUESTION2));
        driver.findElement(ARROWQUESTION2).click();
        String text = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                " можете просто сделать несколько заказов — один за другим.";
        new WebDriverWait(driver, 3).until(ExpectedConditions.
                textToBePresentInElementLocated(By.id("accordion__panel-1"), text));
        assertTrue(driver.findElement(TEXTQUESTION2).isDisplayed());
        assertEquals(driver.findElement(TEXTQUESTION2).getText(), text);
    }

    //метод клика по стрелочке: вопрос о важном №3, и проверка текста
    public void clickQuestion3() {
        scroll(driver.findElement(ARROWQUESTION3));
        driver.findElement(ARROWQUESTION3).click();
        String text = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт " +
                "времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая " +
                "в 20:30, суточная аренда закончится 9 мая в 20:30.";
        new WebDriverWait(driver, 3).until(ExpectedConditions.
                textToBePresentInElementLocated(By.id("accordion__panel-2"), text));
        assertTrue(driver.findElement(TEXTQUESTION3).isDisplayed());
        assertEquals(driver.findElement(TEXTQUESTION3).getText(), text);
    }

    //метод клика по стрелочке: вопрос о важном №4, и проверка текста
    public void clickQuestion4() {
        scroll(driver.findElement(ARROWQUESTION4));
        driver.findElement(ARROWQUESTION4).click();
        String text = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        new WebDriverWait(driver, 3).until(ExpectedConditions.
                textToBePresentInElementLocated(By.id("accordion__panel-3"), text));
        assertTrue(driver.findElement(TEXTQUESTION4).isDisplayed());
        assertEquals(driver.findElement(TEXTQUESTION4).getText(), text);
    }

    //метод клика по стрелочке: вопрос о важном №5, и проверка текста
    public void clickQuestion5() {
        scroll(driver.findElement(ARROWQUESTION5));
        driver.findElement(ARROWQUESTION5).click();
        String text = "Пока что нет! Но если что-то срочное — всегда можно позвонить в"
                + " поддержку по красивому номеру 1010.";
        new WebDriverWait(driver, 3).until(ExpectedConditions.
                textToBePresentInElementLocated(By.id("accordion__panel-4"), text));
        assertTrue(driver.findElement(TEXTQUESTION5).isDisplayed());
        assertEquals(driver.findElement(TEXTQUESTION5).getText(), text);
    }

    //метод клика по стрелочке: вопрос о важном №6, и проверка текста
    public void clickQuestion6() {
        scroll(driver.findElement(ARROWQUESTION6));
        driver.findElement(ARROWQUESTION6).click();
        String text = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете "
                + "кататься без передышек и во сне. Зарядка не понадобится.";
        new WebDriverWait(driver, 3).until(ExpectedConditions.
                textToBePresentInElementLocated(By.id("accordion__panel-5"), text));
        assertTrue(driver.findElement(TEXTQUESTION6).isDisplayed());
        assertEquals(driver.findElement(TEXTQUESTION6).getText(), text);
    }

    //метод клика по стрелочке: вопрос о важном №7, и проверка текста
    public void clickQuestion7() {
        scroll(driver.findElement(ARROWQUESTION7));
        driver.findElement(ARROWQUESTION7).click();
        String text = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим." +
                " Все же свои.";
        new WebDriverWait(driver, 3).until(ExpectedConditions.
                textToBePresentInElementLocated(By.id("accordion__panel-6"), text));
        assertTrue(driver.findElement(TEXTQUESTION7).isDisplayed());
        assertEquals(driver.findElement(TEXTQUESTION7).getText(), text);
    }

    //метод клика по стрелочке: вопрос о важном №8, и проверка текста
    public void clickQuestion8() {
        scroll(driver.findElement(ARROWQUESTION8));
        driver.findElement(ARROWQUESTION8).click();
        String text = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        new WebDriverWait(driver, 3).until(ExpectedConditions.
                textToBePresentInElementLocated(By.id("accordion__panel-7"), text));
        assertTrue(driver.findElement(TEXTQUESTION8).isDisplayed());
        assertEquals(driver.findElement(TEXTQUESTION8).getText(), text);
    }

    //метод клика по верхней кнопке заказать
    public ClassForPageOrder clickOrderUpButton() {
        driver.findElement(BUTTONORDERUP).click();
        return new ClassForPageOrder(driver);
    }

    //метод клика по нижней кнопке заказать
    public ClassForPageOrder clickOrderDownButton() {

        if (driver.findElement(BUTTONORDERDOWN).isDisplayed()) {
            scroll(driver.findElement(BUTTONORDERDOWN));
            driver.findElement(BUTTONORDERDOWN).click();
        }
        return new ClassForPageOrder(driver);
    }

    public void scroll(WebElement arrowQuestion) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrowQuestion);
    }
}
