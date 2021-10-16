package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {
    //1Bir Class olusturalim D14_KeyboardActions2
    //2https://html.com/tags/iframe/ sayfasina gidelim
    //3video’yu gorecek kadar asagi inin
    //4videoyu izlemek icin Play tusuna basin
    //5videoyu calistirdiginizi test edin
    @Test
    public void test01() throws InterruptedException {
        //2https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(3000);
        //4videoyu izlemek icin Play tusuna basin
        WebElement iFrame = driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iFrame);
        WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(playButton).perform();
        Thread.sleep(3000);
        //5videoyu calistirdiginizi test edin
        Assert.assertFalse(playButton.isDisplayed(),"play button is still displayed");
    }
}
