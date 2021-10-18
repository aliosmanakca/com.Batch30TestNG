package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class homework10 extends TestBase {
     /*
      go to url :http://demo.guru99.com/popup.php
      get the first window
      clicking on click here button
      get all the window in the set
      switch to window
      input email id (somepne@gmail.com) and type something in that input
      Clicking on the submit button
      verify title as expected
      switch to first window
     */
    @Test
    public void test01(){
        //go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //get the first window
        String firstWindow = driver.getWindowHandle();

        //clicking on click here button
        driver.findElement(By.partialLinkText("Click Here")).click();

        //get all the window in the set
        String secondWindow = "";
        Set<String> windows = driver.getWindowHandles();
        for (String each: windows
             ) {
            if (!each.equals(firstWindow)){
                secondWindow=each;
            }
        }

        //switch to window
        driver.switchTo().window(secondWindow);

        //input email id (somepne@gmail.com) and type something in that input
        WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
        email.sendKeys("somepne@gmail.com");

        //Clicking on the submit button
        WebElement submit = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        submit.click();

        //verify title as expected
        String actual = driver.findElement(By.tagName("h3")).getText();
        String expected = "This access is valid only for 20 days.";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected,"not same");
        softAssert.assertAll();

        //switch to first window
        driver.switchTo().window(firstWindow);
    }
}
