package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions extends TestBase {
/*  2-https://the internet.herokuapp.com/context_menu sitesine gidelim
    3-Cizili alan uzerinde sag click yapalim
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    5-Tamam diyerek alert’I kapatalim
    6-Elemental Selenium linkine tiklayalim
    7-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim*/
    @Test
    public void test01() throws InterruptedException {
        //2-https://the internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3-Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement alan = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(alan).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlert = "You selected a context menu";
        String actualAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert,expectedAlert, "alert is not as expected");
        //5-Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        //6-Elemental Selenium linkine tiklayalim
        driver.findElement(By.partialLinkText("Elemental Selenium")).click();
        //7-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String firstPage = driver.getWindowHandle();
        String secondPage = "";

        Set<String> pages = driver.getWindowHandles();
        for (String each: pages
             ) {
            if (!each.equals(firstPage)){
                secondPage=each;
            }
        }

        driver.switchTo().window(secondPage);
        WebElement title = driver.findElement(By.tagName("h1"));
        String expectedTitle = "Elemental Selenium";
        String actualTitle = title.getText();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
