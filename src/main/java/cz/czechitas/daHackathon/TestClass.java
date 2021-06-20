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
        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/");
    }

    @Test
    public void TestManinPageRoomReservationA() throws InterruptedException {

        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/");
        WebElement element = browser.findElement(By.xpath("//a[@href=\"http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html\"]"));
        element.click();
        Assert.assertEquals("URL není shodná", "http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html", browser.getCurrentUrl());
        //nestandartní chování//
    }

    @Test
    public void TestManinPageRoomReservationB() throws InterruptedException {

        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/");
        WebElement element = browser.findElement(By.xpath("//a[@href=\"http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html\"]"));
        element.click();
        String windowHandle = browser.getWindowHandle();
        ArrayList tabs = new ArrayList(browser.getWindowHandles());
        System.out.println(tabs.get(0));
        System.out.println(tabs.size());
        System.out.println("vzhledem k náročnosti jsme test odložily k pozdějšímu dokončení");
        Assert.assertEquals("url není shodná", "http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html", browser.getCurrentUrl());
    }

    @Test
    public void TestAddingRoomToCart() throws InterruptedException {

        WebElement element = browser.findElement(By.xpath("//a[@href=\"http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html\"]"));
        element.click();
        Thread.sleep(5000);
        WebElement btnBookNow = browser.findElement(By.xpath("//button[@class=\"exclusive book_now_submit\"]"));
        Thread.sleep(2000);
        btnBookNow.click();
        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/quick-order");
        WebElement shoppingCart = browser.findElement(By.xpath("//span[@class=\"badge badge_style ajax_cart_quantity unvisible\"]"));
        Assert.assertEquals("počet objednaných pokojů se neshoduje s počtem v shoppingCart", 1, shoppingCart.getText());


    }

    @Test
    public void TestCheckOfTermsAndCondition() throws InterruptedException {
        WebElement element = browser.findElement(By.xpath("//a[@href=\"http://www.czechitas-hackhaton.cz/en/content/3-terms-and-conditions-of-use\"]"));
        Thread.sleep(2000);
        element.click();
        Assert.assertEquals("Url adresa se neshoduje", "http://www.czechitas-hackhaton.cz/en/content/3-terms-and-conditions-of-use", browser.getCurrentUrl());

    }

    @Test
    public void TestLoginInHeaderSection() throws InterruptedException {
        WebElement element = browser.findElement(By.xpath("//a[@class=\"user_login navigation-link\"]"));
        Thread.sleep(2000);
        element.click();
        WebElement emailField = browser.findElement(By.id("email"));
        emailField.sendKeys("lehotskalivia@gmail.com");
        Thread.sleep(2000);
        WebElement passwordField = browser.findElement(By.id("passwd"));
        passwordField.sendKeys("12345");
        Thread.sleep(2000);
        WebElement btnSignIn = browser.findElement(By.id("SubmitLogin"));
        btnSignIn.click();
        Thread.sleep(2000);
        Assert.assertEquals("nejsme přesměrování na další stránu", "http://www.czechitas-hackhaton.cz/en/my-account", browser.getCurrentUrl());

    }

    @Test
    public void TestLoginInWithWrongUserName() throws InterruptedException {
        WebElement element = browser.findElement(By.xpath("//a[@class=\"user_login navigation-link\"]"));
        Thread.sleep(2000);
        element.click();
        WebElement emailField = browser.findElement(By.id("email"));
        emailField.sendKeys("livilalehostska@gmail.com");
        Thread.sleep(2000);
        WebElement passwordField = browser.findElement(By.id("passwd"));
        passwordField.sendKeys("12345");
        Thread.sleep(2000);
        WebElement btnSignIn = browser.findElement(By.id("SubmitLogin"));
        btnSignIn.click();
        Thread.sleep(2000);
        WebElement alert = browser.findElement(By.className("alert-danger"));
        Assert.assertTrue("není zobrazena chybová hláška", alert.isDisplayed());
    }

    @Test
    public void TestCreateAccount() throws InterruptedException {
        WebElement element = browser.findElement(By.xpath("//a[@class=\"user_login navigation-link\"]"));
        Thread.sleep(2000);
        element.click();
        WebElement emailAddressField = browser.findElement(By.id("email_create"));
        emailAddressField.sendKeys("BodNavicSeVzdyckyHodi@gmail.com");
        Thread.sleep(2000);
        WebElement btnCreate = browser.findElement(By.id("SubmitCreate"));

        btnCreate.click();
        Thread.sleep(2000);
        WebElement fieldFirstName = browser.findElement(By.id("customer_firstname"));
        fieldFirstName.sendKeys("Bod navic se vždy hodi");
        Thread.sleep(2000);
        WebElement fieldLastName = browser.findElement(By.id("customer_lastname"));
        fieldFirstName.sendKeys("Prosim");
        Thread.sleep(2000);
        WebElement fieldPassword = browser.findElement(By.id("passwd"));
        fieldFirstName.sendKeys("12345");
        Thread.sleep(2000);
        WebElement btnRegiester = browser.findElement(By.id("submitAccount"));
       btnRegiester.click();
        Thread.sleep(2000);

        WebElement alert = browser.findElement(By.className("alert"));

        Assert.assertTrue(alert.isDisplayed());


        Thread.sleep(2000);

        

    }

    @Test
    public void TestLogOut() throws InterruptedException {
        WebElement element = browser.findElement(By.xpath("//a[@class=\"user_login navigation-link\"]"));
        Thread.sleep(2000);
        element.click();
        WebElement emailField = browser.findElement(By.id("email"));
        emailField.sendKeys("lehotskalivia@gmail.com");
        Thread.sleep(2000);
        WebElement passwordField = browser.findElement(By.id("passwd"));
        passwordField.sendKeys("12345");
        Thread.sleep(2000);
        WebElement btnSignIn = browser.findElement(By.id("SubmitLogin"));
        btnSignIn.click();
        Thread.sleep(2000);
        
    }



    @After
    public void CleanUp() {
        browser.quit();
    }

}
