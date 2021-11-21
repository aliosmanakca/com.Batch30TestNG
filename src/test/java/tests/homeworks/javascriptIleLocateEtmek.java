package tests.homeworks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class javascriptIleLocateEtmek extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.getElementById('email').value='deneme@abc.com';");
        js.executeScript("document.getElementById('pass').value='123456';");
        //value='123456' locate edilen yere deger gonderir. (sendKeys)

        Thread.sleep(3000);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");

        JavascriptExecutor jsExecutrer = (JavascriptExecutor) driver;

        WebElement aramaKutusu = (WebElement) jsExecutrer.executeScript("return document.querySelector(\"body > book-app\")." +
                "shadowRoot.querySelector(\"#input\")");

        aramaKutusu.sendKeys("Basitmis degil mi?");

        Thread.sleep(3000);
    }
}
