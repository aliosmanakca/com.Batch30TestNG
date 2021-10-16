package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {
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

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        // 1-window handle ederken ilk adim 1. sayfa acik iken o sayfanin handle degerini bir stringe atamak
        String ilkSayfaHandle = driver.getWindowHandle();

        // Click Here butonuna basın.
        //bu satirda ikinci window acildi
        driver.findElement(By.partialLinkText("Click Here")).click();

        // 2-iki sayfa acildiginda her iki sayfanin handle degerini koymak icin bir set olusturup
        // getWindowHandles methodu ile bunlari elde etmeliyiz
        Set<String> tumWindowHanlelari = driver.getWindowHandles();

        // 3-set icerisinde birinci sayfanin handle degerine esit olmayan handle degerini bulup stringe atamaliyiz
        String ikinciWindowhandle = "";
        for (String each: tumWindowHanlelari
        ) {
            if (!ilkSayfaHandle.equals(each)){
                ikinciWindowhandle=each;
            }
        }
        driver.switchTo().window(ikinciWindowhandle);
        // switcTo ile window degistireceksek gidecegimiz windowun windowhandle degerine ihtiyacimiz var
        String actualNewTitle = driver.getTitle();
        String expectedNewTitle = "New Window";
        softAssert.assertEquals(actualNewTitle,expectedNewTitle,"titleisnotasexpected"); // neden hata mesajinin hepsini yazdirmiyor

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yeniSayfaYazi = driver.findElement(By.tagName("h3"));
        String expectedText = "New Window";
        softAssert.assertEquals(yeniSayfaYazi.getText(),expectedText,"yazi beklenenden farkli");

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandle);
        actualTitle = driver.getTitle();
        expectedTitle = "The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle,"title is not as expected");

        softAssert.assertAll();

    }
}
