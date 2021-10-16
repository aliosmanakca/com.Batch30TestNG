package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_MouseActions extends TestBase {
/*    1-https://www.amazon.com/ adresine gidelim
      2-Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
      3-“Create a list” butonuna basalim
      4-Acilan sayfada “Your Lists” yazisi oldugunu test edelim*/
    @Test
    public void test01(){
        //1-https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        //2-Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement enterance = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        actions.moveToElement(enterance).perform();
        //3-“Create a list” butonuna basalim
        driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();
        //4-Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        WebElement yazi = driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(yazi.isDisplayed());
    }
}
