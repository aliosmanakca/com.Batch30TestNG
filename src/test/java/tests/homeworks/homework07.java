package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class homework07 extends TestBase {
/*    1-https://www.facebook.com adresine gidelim
      2-Yeni hesap olustur butonuna basalim
      3-Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
      */
    @Test
    public void test01(){
        //1-https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2-Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3-Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First name']"));
        firstName.sendKeys("ali osman");

        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("akca");

        // digerlerini yapmadim ne de olsa ayni sey
    }
}
