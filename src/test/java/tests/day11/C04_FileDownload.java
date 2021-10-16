package tests.day11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim : D14_FileDownload
    //2. Iki tane metod oluşturun : isExist() ve downloadTest()
    //3. downloadTest () metodunun icinde aşağıdaki testi yapalim
    //https://the-internet.herokuapp.com/download adresine gidelim -img.png dosyasını indirelim
    //4Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
    @Test (priority = 1)
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        //3. downloadTest () metodunun icinde aşağıdaki testi yapalim
        //https://the-internet.herokuapp.com/download adresine gidelim -img.png dosyasını indirelim
        driver.findElement(By.partialLinkText("img.png")).click();
        Thread.sleep(5000); // eger biraz bekletmezsen indirmeye vakit bulamaz
    }
    @Test (priority = 2)
    public void isExist(){
        //"C:\Users\Ali Osman\Downloads\img.png"
        String filePath = System.getProperty("user.home")+ "\\Downloads\\img.png";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
