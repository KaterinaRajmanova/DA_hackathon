package cz.czechitas.daHackathon;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class CheckOutPageTest {
    WebDriver browser;

    @Before
    public void SetUp() {

        System.setProperty(
                "webdriver.gecko.driver",
                "/Users/Katerina/DA_Testovani/Teorie/Automatizovane_testovani/SeleniumDrivers/geckodriver"
        );
        //       System.setProperty(
        //                "webdriver.chrome.driver",
        //                "/Users/rajman/DA_Testovani/Teorie/Programovani/MaterialyProProgramovani/SeleniumDrivers/chromedriver"

        //       browser = new ChromeDriver();

        browser = new FirefoxDriver();
    }

    @Test
    public void TestManinPageRoomReservationA() throws InterruptedException {

   
    }


    @After
    public void CleanUp() {
        browser.quit();
    }

}
