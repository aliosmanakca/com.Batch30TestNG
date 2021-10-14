package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01_Allerts {
    //Her alert js alert degildir. sag click yapilamiyorsa js alerttir.
    //html alert ise locate edip kullanabiliriz

    //● Bir class olusturun: C01_Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //      “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void test01(){
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = result.getText();
        String expected = "You successfully clicked an alert";
        Assert.assertEquals(actual,expected,"ayni degil");
    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = result.getText();
        String notexpected = "successfuly";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!actual.contains(notexpected),"notexpected is included");
        softAssert.assertAll();
    }
    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("ali osman");
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = result.getText();
        String expected = "You entered: ali osman";
        Assert.assertEquals(actual,expected,"not same");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
