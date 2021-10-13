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
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class homework03 {
    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.saucedemo.com/");
    }
    @Test
    public void test01(){
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user"+ Keys.ENTER);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce"+Keys.ENTER);
        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();
        WebElement options = driver.findElement(By.xpath("//select[@class='product_sort_container']"));

        Select select = new Select(options);
        select.selectByValue("lohi");

        String actual = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        String expected = "Price (low to high)";

        //1. yontem
        /*SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actual.equalsIgnoreCase(expected),"low to high isn't selected");
        softAssert.assertAll();*/

        //2. yontem
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> strlist = new ArrayList<>();
        list.stream().map(t->t.getText()).forEach(t->strlist.add(t));
        List<Double> fiyatlar = new ArrayList<>();
        strlist.stream().map(t->t.replace("$","")).forEach(t->fiyatlar.add(Double.parseDouble(t)));

        List<Double> sirali = new ArrayList<>();
        sirali.addAll(fiyatlar);
        Collections.sort(sirali);

        Assert.assertEquals(fiyatlar,sirali,"sirali degil");
    }
}
