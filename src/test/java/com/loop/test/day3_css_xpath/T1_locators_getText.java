package com.loop.test.day3_css_xpath;

import com.loop.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {

    /*
     * go to docuport
     * enter username
     * do NOT enter password
     * click on login button
     * verify error message
     */

    public static void main(String[] args) throws InterruptedException {

        // go to url

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys("b1g3_supervisor@gmail.com");








    }
}












