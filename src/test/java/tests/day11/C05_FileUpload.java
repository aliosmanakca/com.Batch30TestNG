package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    //1.Tests packagenin altina bir class oluşturun : D14_ UploadFile
    //2.https://the-internet.herokuapp.com/upload adresine gidelim
    //3.chooseFile butonuna basalim
    //4.Yuklemek istediginiz dosyayi sec elim
    //5.Upload butonuna bas alim
    //6.“File Uploaded!” textinin goruntulendigini test edelim
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        //4.Yuklemek istediginiz dosyayi secelim
            //"C:\Users\Ali Osman\Downloads\img.png"
        String filePath = "C:\\Users\\Ali Osman\\Downloads\\img.png";
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys(filePath);
        Thread.sleep(2000);

        //5.Upload butonuna bas alim
        driver.findElement(By.id("file-submit")).click();

        //6.“File Uploaded!” textinin goruntulendigini test edelim
        WebElement text = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(text.isDisplayed());
    }
}
