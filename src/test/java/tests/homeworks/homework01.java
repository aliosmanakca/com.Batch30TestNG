package tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homework01 {
    //Bir class oluşturun: C3_DropDownAmazon
    // https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori
    //sayisinin 45 oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void test01(){
        WebElement kategori = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(kategori);
        List<WebElement> tumOpsiyonlar = select.getOptions();
        int expected = 45;
        Assert.assertEquals(tumOpsiyonlar.size(),expected,"esit degil");
    }
    @Test
    public void test02(){
        WebElement kategori = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(kategori);
        select.selectByVisibleText("Books");
        //select.getFirstSelectedOption().click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java"+ Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());
        String expected = "Java";
        Assert.assertTrue(result.getText().contains(expected),"Java kelimesini icermiyor");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
