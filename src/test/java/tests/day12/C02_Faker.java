package tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {
    @Test
    public void test01(){
        //1."https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //2.“create new account” butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3.“firstName” giris kutusuna bir isim yazin
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String email = faker.internet().emailAddress();

        //4.“surname” giris kutusuna bir soyisim yazin
        //5.“email” giris kutusuna bir email yazin
        //6.“email” onay kutusuna emaili tekrar yazin
        //7.Bir sifre girin
        //8.Tarih icin gun secin
        //9.Tarih icin ay secin
        //10.Tarih icin yil secin
        //11.Cinsiyeti secin
        WebElement firtname = driver.findElement(By.xpath("//input[@name='firstname']"));
        actions.click(firtname)
                .sendKeys(faker.harryPotter().character())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.gameOfThrones().house())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,31)))
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1990,2000)))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();
        //12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement male = driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
        Assert.assertTrue(male.isSelected());
        //13.Sayfayi kapatin
    }

}
