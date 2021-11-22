package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class homework16 extends TestBase {

    // Siteyi açınız. http://opencart.abstracta.us/index.php?route=account/login ,
    // login yapiniz Email: asd@gmail.com   password : 123qweasd
    // Search fonksiyonunu kullanarak
    // Mac,ipod ve samsung icin Dataprovider ile arama yapınız.

    @DataProvider
    public static Object[] aranacaklar() {
        Object[] kelimeler = {"Mac","ipod","samsung"};
        return kelimeler;
    }

    @Test (dataProvider = "aranacaklar")
    public void test(String aranacakKelime){
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        /*driver.findElement(By.xpath("//input[@name='email']")).sendKeys("asd@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123qweasd");
        driver.findElement(By.xpath("//input[@value='Login']")).click();*/
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(aranacakKelime+ Keys.ENTER);
    }
}
