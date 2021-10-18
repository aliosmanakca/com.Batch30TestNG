package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class homework11 extends TestBase {
    @Test
    public void test01(){
        //1.Bir class olusturun : EnableTest
        //2.Bir metod olusturun : isEnabled()
        //3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(textBox.isEnabled(),"textBox is enabled");

        //5.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enabled = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enabled.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        textBox.click();

        //6.“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        String actual = driver.findElement(By.xpath("//p[@id='message']")).getText();
        String expected = "It's enabled!";
        softAssert.assertEquals(actual,expected);

        //7.Textbox’in etkin ol dugunu (enabled)
        softAssert.assertTrue(textBox.isEnabled());
        softAssert.assertAll();
    }

}
