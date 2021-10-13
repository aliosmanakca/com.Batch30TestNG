package tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class homework02 {
/*
      1. http ://zero.webappsecurity .com Adresine gidin
      2. Sign in butonuna basin
      3. Login kutusuna “username” yazin
      4. Password kutusuna “password.” yazin
      5. Sign in tusuna basin
      6. Pay Bills sayfasina gidin
      7. “Purchase Foreign Currency” tusuna basin
      8. “Currency” drop down menusunden Eurozone’u secin
      9. “amount” kutusuna bir sayi girin
      10. “US Dollars” in secilmedigini test edin
      11. “Selected currency” butonunu secin
      12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
      13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol
    edin.*/
WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("http://zero.webappsecurity.com");
    }
    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        Thread.sleep(500);
        driver.navigate().back();
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        Thread.sleep(500);
        driver.findElement(By.partialLinkText("Purchase Foreign Currency")).click();
        WebElement currency = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currency);
        select.selectByVisibleText("Eurozone (euro)");
        select.getFirstSelectedOption().click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("100");
        WebElement dollar = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertTrue(!dollar.isSelected(),"dolar secili");
    }
    @Test (dependsOnMethods = "test01")
    public void test02(){
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
        WebElement result = driver.findElement(By.xpath("//div[@id='alert_content']"));
        Assert.assertTrue(result.isDisplayed(),"yazi gozukmuyor");
    }
}
