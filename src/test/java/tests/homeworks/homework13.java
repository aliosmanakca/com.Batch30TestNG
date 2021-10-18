package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class homework13 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        Thread.sleep(2000);

        //2.“Our Products” butonuna basin
        WebElement iframe_firstPage = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe_firstPage);
        driver.findElement(By.partialLinkText("Our Products")).click();
        driver.switchTo().defaultContent();

        //3.“Cameras product”i tiklayin
        Thread.sleep(2000);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//p[.='Cameras']")).click();

        //4.Popup mesajini yazdirin
        Thread.sleep(1000);
        String popup = driver.findElement(By.tagName("h4")).getText();
        System.out.println(popup);

        //5.“close” butonuna basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();

        //6."WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.partialLinkText("WebdriverUniversity.com (IFrame)")).click();

        //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actual = driver.getCurrentUrl();
        String expected = "http://webdriveruniversity.com/index.html";
        Assert.assertEquals(actual,expected,"not same");
    }

}
