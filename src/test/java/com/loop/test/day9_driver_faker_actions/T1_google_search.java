package com.loop.test.day9_driver_faker_actions;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_google_search {

      /*
    1. go to "https://www.google.com"
    2. write "Loop Academy" and search
    3. validate title: Loop Academy - Google Search
     */

    @Test
    public void google_search(){
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        System.out.println("((RemoteWebDriver) Driver.getDriver()).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("Loop Academy" + Keys.ENTER);
        assertEquals(Driver.getDriver().getTitle(), "Loop Academy - Google Search");
    }

    @Test
    public void docuport_search(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        System.out.println("((RemoteWebDriver) Driver.getDriver()).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
        DocuportUtils.login(Driver.getDriver(), "advisor");
        WebElement myUploads = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'My ')]"));
        myUploads.click();

        WebElement upload =Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Upload d')]"));

        upload.click();

        WebElement file = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[8]"));

        file.click();

        String path = "/Users/nsh/Desktop/some-file.txt";
        file.sendKeys(path);


    }

   // @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
