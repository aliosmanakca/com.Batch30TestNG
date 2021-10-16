package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class homework09 extends TestBase {
    //1-"http://webdriveruniversity.com/Actions" sayfasina gidin
    //2Hover over Me First" kutusunun ustune gelin
    //3Link 1" e tiklayin
    //4Popup mesajini yazdirin
    //5Popup'i tamam diyerek kapatin
    //6-“Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8-“Double click me" butonunu cift tiklayin
    @Test
    public void test01(){
        //1-"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);

        WebElement element1 = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(element1).perform();

        //3Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

        //4Popup mesajini yazdirin
        String popUp = driver.switchTo().alert().getText();
        System.out.println(popUp);

        //5Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6-“Click and hold" kutusuna basili tutun
        WebElement element2 = driver.findElement(By.id("click-box"));
        actions.clickAndHold(element2).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.id("click-box")).getText());

        //8-“Double click me" butonunu cift tiklayin
        WebElement element3 = driver.findElement(By.tagName("h2"));
        actions.doubleClick(element3).perform();
    }
}
