package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class homework14 extends TestBase {
    @Test
    public void test01(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String firsturl = driver.getCurrentUrl();

        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']")).click();

        //4.Diger window'a gecin
        String firstWindow = driver.getWindowHandle();
        String secondWindow = "";
        Set<String> windows = driver.getWindowHandles();
        for (String each: windows
             ) {
            if (!each.equals(firstWindow)){
                secondWindow=each;
            }
        }
        driver.switchTo().window(secondWindow);

        //5."username" ve "password" kutularina deger yazdirin
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("ali osman");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("12345");

        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actual = driver.switchTo().alert().getText();
        String expected = "validation failed";
        Assert.assertEquals(actual,expected,"not same");

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(firstWindow);

        //10.Ilk sayfaya donuldugunu test edin
        String actualurl = driver.getCurrentUrl();
        Assert.assertEquals(actual,expected,"you are not in the first page");
    }

}
