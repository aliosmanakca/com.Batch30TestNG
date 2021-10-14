package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class homework05 extends TestBase {
    /*1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
   2) sayfadaki iframe sayısını bulunuz.
   3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
   4)ilk iframe'den çıkıp ana sayfaya dönünüz
   5)ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium project.html) tıklayınız*/
    @Test
    public void test01() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrames = driver.findElements(By.tagName("iframe"));
        System.out.println("the number of iframes is : "+iFrames.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@aria-label=\'Play\']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@aria-label='Pause (k)']")).click();
        //4)ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().parentFrame();
        //5)ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium project.html) tıklayınız
        WebElement iFrame2 = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(iFrame2);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
    }

}
