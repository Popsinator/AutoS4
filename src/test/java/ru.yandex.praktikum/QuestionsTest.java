package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuestionsTest {

    private WebDriver driver;
    MasterPage page;

    @Before
    public void startUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        page = new MasterPage(driver);
    }

    @Test
    public void QuestionTest1() {

        page.open()
                .clickCookieButton()
                .clickQuestion1();
    }

    @Test
    public void QuestionTest2() {

        page.open()
                .clickCookieButton()
                .clickQuestion2();
    }

    @Test
    public void QuestionTest3() {

        page.open()
                .clickCookieButton()
                .clickQuestion3();
    }

    @Test
    public void QuestionTest4() {

        page.open()
                .clickCookieButton()
                .clickQuestion4();
    }

    @Test
    public void QuestionTest5() {

        page.open()
                .clickCookieButton()
                .clickQuestion5();
    }

    @Test
    public void QuestionTest6() {

        page.open()
                .clickCookieButton()
                .clickQuestion6();
    }

    @Test
    public void QuestionTest7() {

        page.open()
                .clickCookieButton()
                .clickQuestion7();
    }

    @Test
    public void QuestionTest8() {

        page.open()
                .clickCookieButton()
                .clickQuestion8();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
