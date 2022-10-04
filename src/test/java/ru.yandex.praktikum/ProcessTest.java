package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProcessTest {

    private WebDriver driver;
    MainPage page;

    @Before
    public void startUp() {
        //driver = new ChromeDriver(); //Здесь баг, не нажимается кнопка, чтобы оформить заказ, в firefox всё ок
        driver = new FirefoxDriver();
        page = new MainPage(driver);
    }

    @Test
    public void ClickButtonOrderUp1() {

        page.open()
                .clickCookieButton()
                .clickOrderUpButton()
                .fillFirstForm("Алексей", "Попов", "Москва",
                        "Марьино", "89999066770")
                .clickNext()
                .fillSecondForm("03.10.2022", "сутки",
                        "серая безысходность", "Просьба привезти после 20:00")
                .makeOrder()
                .clickYesOrderButton()
                .successfulOrder();
    }

    @Test
    public void ClickButtonOrderUp2() {

                page.open()
                .clickCookieButton()
                .clickOrderUpButton()
                .fillFirstForm("Алексей", "Попов", "Москва",
                        "Марьино", "89999066770")
                .clickNext()
                .fillSecondForm("03.10.2022", "сутки",
                "чёрный жемчуг", "Просьба привезти в 06:00")
                .makeOrder()
                .clickYesOrderButton()
                .successfulOrder();
    }

    @Test
    public void ClickButtonOrderDown1() {

                page.open()
                .clickCookieButton()
                .clickOrderDownButton()
                .fillFirstForm("Алексей", "Попов", "Москва",
                        "Марьино", "89999066770")
                .clickNext()
                .fillSecondForm("03.10.2022", "сутки",
                        "чёрный жемчуг", "Просьба привезти в 06:00")
                .makeOrder()
                .clickYesOrderButton()
                .successfulOrder();
    }

    @Test
    public void ClickButtonOrderDown2() {

        page.open()
                .clickCookieButton()
                .clickOrderDownButton()
                .fillFirstForm("Алексей", "Попов", "Москва",
                        "Марьино", "89999066770")
                .clickNext()
                .fillSecondForm("03.10.2022", "сутки",
                        "серая безысходность", "Просьба привезти после 20:00")
                .makeOrder()
                .clickYesOrderButton()
                .successfulOrder();
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}
