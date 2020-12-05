package cz.czechitas.daHackathon;

import org.openqa.selenium.*;

public class HomePage {

    private WebDriver browser;

    public HomePage(WebDriver webDriver) {
        browser = webDriver;
    }

    public void findAndElementClickByXpath(String xpath) throws InterruptedException {

        WebElement element = browser.findElement(By.xpath(xpath) );


        element.click();
    }

    public String getCurrentURL(){
         return browser.getCurrentUrl();
    }
}