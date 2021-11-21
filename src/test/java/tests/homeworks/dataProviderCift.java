package tests.homeworks;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class dataProviderCift extends TestBase {
    @DataProvider
    public static Object[][] sigInTest() {
        Object[][] gmibankData = new Object[2][2];

        //{"username1@gmail.com","password1"},
        //{"username2@gmail.com","password2"},

        gmibankData [0][0] = "username1@gmail.com";
        gmibankData [0][1] = "password1";
        gmibankData [1][0] = "username2@gmail.com";
        gmibankData [1][1] = "password2";

        return gmibankData;
    }

    @Test(dataProvider = "sigInTest")
    public void test(String username, String password) throws InterruptedException {
        driver.get("https://www.gmibank.com/");

        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();

        driver.findElement(By.xpath("//span[text()='Sign in']")).click();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        driver.findElement(By.xpath("(//span[text()='Sign in'])[2]")).click();

        Thread.sleep(3000);
    }
}
