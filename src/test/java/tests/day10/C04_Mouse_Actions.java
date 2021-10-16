package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_Mouse_Actions extends TestBase {
 /*   1-https://demoqa.com/droppable adresine gidelim
      2-“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
      3-“Drop here” yazisi yerine “Dropped!” oldugunu test edin */
    @Test
    public void test01(){
        //1-https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2-“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropField = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragElement,dropField).perform();
        //3-“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expected = "Dropped!";
        String actual = driver.findElement(By.xpath("//p[.='Dropped!']")).getText(); // text() yerine . konabilir
        Assert.assertEquals(actual,expected,"not same");

    }
}
