package tests.day09;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {
    @Test
    public void test01(){
        // https://the internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualYaziElementi =driver.findElement(By.tagName("h3")).getText();
        String expectedYazi = "Opening a new window";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualYaziElementi,expectedYazi, "not same");
        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle,"title is not as expected");
        // Click Here butonuna basın.
        driver.findElement(By.partialLinkText("Click Here")).click();
        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualNewTitle = driver.getTitle();
        String expectedNewTitle = "New Window";
        softAssert.assertEquals(actualNewTitle,expectedNewTitle,"titleisnotasexpected"); // neden hata mesajinin hepsini yazdirmiyor
        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        softAssert.assertAll();
    }

}
