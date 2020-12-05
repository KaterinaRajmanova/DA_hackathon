package cz.czechitas.daHackathon;

import java.lang.reflect.*;
import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

public class TestClass {

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

        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/");
        HomePage homepage = new HomePage(browser);
        homepage.findAndElementClickByXpath("//a[@href=\"http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html\"]");
      
        Assert.assertEquals("URL není shodná","http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html", homepage.getCurrentURL());
        //nestandartní chování//
    }

    @Test
    public void TestManinPageRoomReservationB() throws InterruptedException {

        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/");
        HomePage homepage = new HomePage(browser);
        homepage.findAndElementClickByXpath("//a[@href=\"http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html\"]");

        String windowHandle = browser.getWindowHandle();
        //Get the list of window handles
        ArrayList tabs = new ArrayList (browser.getWindowHandles());
        System.out.println(tabs.get(0));
        System.out.println(tabs.size());
        //Use the list of window handles to switch between windows
        //browser.switchTo().window(tabs.get(0));
        //Switch back to original window
        //browser.switchTo().window(mainWindowHandle);
        System.out.println("vzhledem k náročnosti jsme test odložily k pozdějšímu dokončení");
        Assert.assertEquals("url není shodná","http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html", homepage.getCurrentURL() );
    }


    @After
    public void CleanUp() {
        browser.quit();
    }

}
