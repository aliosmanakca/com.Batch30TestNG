package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class homework06 extends TestBase {
    /* Go to http://demo.guru99.com/test/drag_drop.html url
       Drag and drop the BANK button to the Account section in DEBIT SIDE
       Drag and drop the SALES button to the Account section in CREDIT SIDE
       Drag and drop the 5000 button to the Amount section in DEBIT SIDE
       Drag and drop the second 5000 button to the Amount section in CREDIT SIDE*/
    @Test
    public void test01() {
        //Go to http://demo.guru99.com/test/drag_drop.html url
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        Actions actions = new Actions(driver);
        WebElement bank = driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
        WebElement accountDebit = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        actions.dragAndDrop(bank, accountDebit).perform();

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement sales = driver.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
        WebElement accountCredit = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
        actions.dragAndDrop(sales, accountCredit).perform();

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement element5000 = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
        WebElement amountDebit = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        actions.dragAndDrop(element5000,amountDebit).perform();

        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement element5000_2 = driver.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
        WebElement amountCredit = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        actions.dragAndDrop(element5000_2,amountCredit).perform();
    }
}
