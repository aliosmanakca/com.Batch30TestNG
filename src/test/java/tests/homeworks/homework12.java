package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class homework12 extends TestBase {
    @Test
    public void test01() {
        //1. Bir class olusturun : ExplicitlyWaitTest
        //2. Bir metod olusturun : enableTest
        //3. https://demoqa.com/dynamic-properties adresine gidin.
        driver.get("https://demoqa.com/dynamic-properties");

        //4.Will enable 5 seconds’in etkin olmadigini(enabled) test edin
        WebElement element1 = driver.findElement(By.xpath("(//button[@class='mt-4 btn btn-primary'])[1]"));
        Assert.assertFalse(element1.isEnabled(), "element1 is enabled");

        //5.Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element1));
        Assert.assertTrue(element1.isEnabled());
    }
    @Test
    public void test02(){
        //6. Bir metod olusturun :visibleTest
        //7.Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin,
        //ve gorunur oldugunu test edin
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement element2 = driver.findElement(By.xpath("(//button[@class='mt-4 btn btn-primary'])[2]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='mt-4 btn btn-primary'])[2]")));
        Assert.assertTrue(element2.isDisplayed());
    }



}
