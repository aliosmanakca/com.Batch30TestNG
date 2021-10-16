package tests.homeworks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class homework08 extends TestBase {
    /*
    go to url :http://demo.automationtesting.in/Alerts.html
    click  "Alert with OK" and click 'click the button to display an alert box:'
    accept Alert(I am an alert box!) and print alert on console
    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    cancel Alert  (Press a Button !)
    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    and then sendKeys 'TechProEducation' (Please enter your name)
    finally print on console this mesaaje "Hello TechproEducation How are you today"
     */
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //click  "Alert with OK" and click 'click the button to display an alert box:
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Thread.sleep(2000);

        //accept Alert(I am an alert box!) and print alert on console
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //click "Alert with OK & Cancel" and click 'click the button to display a confirm box
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);

        //cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

        //click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(2000);

        //and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("Techproeducation");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //finally print on console this mesaaje "Hello TechproEducation How are you today"
        String message = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println(message);
    }
}
