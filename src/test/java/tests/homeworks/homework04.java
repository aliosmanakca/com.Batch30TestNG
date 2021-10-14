package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class homework04 extends TestBase {
    @Test
    public void test01(){
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //maximize the web site
        //click on second emoji
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iFrame);
        WebElement emoji2 = driver.findElement(By.xpath("//img[@class='emoji'][2]"));
        emoji2.click();
        //click all second emoji's element
        //go back parent iframe
        driver.switchTo().parentFrame();
        //fill out the form,(Fill the form with the texts you want)
        WebElement text = driver.findElement(By.xpath("//input[@id='text']"));
        text.sendKeys("ali osman");
        //click on apply button
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }

}
