package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class homework15 extends TestBase {
    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
    methodlar kullanarak yap
    clickAllElements
    getName
    compareTwoList
     */
    @Test
    public void test01(){
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=common/home");

        //~ click on Phones & PDAs
        driver.findElement(By.partialLinkText("Phones & PDAs")).click();

        //~ get the brandName of phones
        List<String> brands = new ArrayList<>();
        List<WebElement> brandsWeb = driver.findElements(By.tagName("h4"));
        brandsWeb.stream().map(t->t.getText()).forEach(t->brands.add(t));

        //~ click on add to button for all elements
        List<WebElement> addToCart = driver.findElements(By.xpath("//span[.='Add to Cart']"));
        addToCart.stream().forEach(t->t.click());

        //~ click on black total added cart button
        driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();

        //~ get the names of list from the cart
        List<WebElement> cartElements = driver.findElements(By.xpath("//td[@class='text-left']"));
        List<String> stringCartElements = new ArrayList<>();
        cartElements.stream().map(t->t.getText()).forEach(t->stringCartElements.add(t));

        //~ compare the names from displaying list and cart list
        Collections.sort(stringCartElements);
        Collections.sort(brands);

        System.out.println(brands);
        System.out.println(stringCartElements);

        Assert.assertEquals(brands,stringCartElements,"not same");
    }
}
