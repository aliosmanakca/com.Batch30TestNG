package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01_Alerts {
    //Her alert js alert degildir. sag click yapilamiyorsa js alerttir.
    //html alert ise locate edip kullanabiliriz

    //● Bir class olusturun: C01_Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //      “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void test01(){
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = result.getText();
        String expected = "You successfully clicked an alert";
        Assert.assertEquals(actual,expected,"ayni degil");
    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = result.getText();
        String notexpected = "successfuly";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!actual.contains(notexpected),"notexpected is included");
        softAssert.assertAll();
    }
    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("ali osman");
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = result.getText();
        String expected = "You entered: ali osman";
        Assert.assertEquals(actual,expected,"not same");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
    /*Alert Nedir?
        Alert kullanıcıya bir tür bilgi vermek veya belirli bir işlemi gerçekleştirme izni
        istemek için ekran bildirimi görüntüleyen küçük bir mesaj kutusudur. Uyarı
        amacıyla da kullanılabilir.
        ​
        1.Simple Alert : Bu basit alert ekranda bazı bilgiler veya uyarılar
        görüntüler. Ok denilerek kapatilir
        2. Confirmation Alert : Bu onay uyarısı bir tür işlem yapma izni
        ister. Alert onaylaniyorsa OK, onaylanmiyorsa Cancel butonuna
        basilir.
        3.Prompt Alert: Bu Prompt Uyarısı kullanıcıdan bazı girdilerin
        girilmesini ister ve selenium webdriver1.Allerts : basit alert: sadece tamam diyebiliyoruz, confirm (onaylama) alerti: Kabul
        edebilir veya reddedebiliriz, prompt: kullanicidan bilgi almak icin kullanilir, dolayisiyla
        biz de prompta metin yollayabilir ve tamam tusuna basabiliriz veya cancel tusuna
        basabiliriz.
        ​
        accept() => Bir uyarıda(alert) OK'ı tıklamakla aynı.
        driver.switchTo().alert().
        ​
        dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı.
        driver.switchTo().alert().
        ​
        getText() => Uyarıdaki(alert) mesajı almak için.
        driver.switchTo().alert().
        ​
        sendKeys("Text") => Uyarı(alert) text kutusuna text göndermek için
        driver.switchTo().alert().sendKeys("Text");
        ​
        Iframe nedir?
        IFrame, bir web sayfasına icine yerlestirilmis baska bir web sayfasıdır veya bir
        HTML dokumaninin içine yerleştirilmiş baska bir HTML dokumanidir
        IFrame genellikle bir Web sayfasına dokuman, video veya interaktif media gibi
        başka bir kaynaktan içerik eklemek için kullanılır. <iframe> tag'ı bir inline frame
        belirtir
        ​
        Handle iframe
        ●Bir sayfada iframe varsa, Selenium bir iframe içindeki elementleri doğrudan
        göremez
        ●Switching to iframe: iframe gecmenin 3 yolu vardir;
        ○index ile
        driver.switchTo().frame(index of the iframe); //index start from 0
        ​
        ○id veya name value ile
        driver.switchTo().frame("id of the frame");
        ○WebElement ile
        driver.switchTo().frame(WebElement of the frame);
        ​
        Iframe'den cikmak icin
        driver.switchTo().parentFrame();  1 ust seviyedeki frame'e cikartir
        driver.switchTo().defaultContent();   En ustteki frame'e cikmak icin kullanilir
        ​
        Birden fazla iframe varsa gecislerde dikkatli olmak lazim.
        Gecisler her zaman basit olamayabilir
        ​
        ●   TestBase, testlerden önce ve sonra tekrar tekrar kullandığımız kodları içermektedir.
        ●  İçerisindeki metodları kullanabilmemiz için extend yapıyoruz. Bu sayede test class' ımızda sadece test case'ler bulunmaktadır.
        ●  Utilities package'da TestBase'i oluşturuyoruz.
        ○  setUp method
        ○  reports (Raporlar)
        ○  tearDown method
        ●  TestBase class'i abstract yapabiliriz (Olmasa da olabilir) , extends yaparak kullanabiliriz. Ve bu class'da object create edemeyiz.
        ●   olusturdugumuz driver in farklı package lerden kullanabilmek için PROTECTED yapariz
        ​
        Tabs- Sekmeler
        Birden çok pencere arasında geçiş yapma( Switch).
        Bazen bir butona tıkladığımızda, başka bir sekmede(tab) yeni bir pencere açılır.
        ​
        Birden fazla pencereyle uğraşırken driver'ı pencereler arasında değiştirmemiz gerekir.
        ​
        Selenium WebDriver, WebDriver objesi başlatıldığında her pencereye bir alfanumerik kimlik
        atar.Bu benzersiz(unique) alfanumerik kimliğe pencere tanıtıcısı(window handle ) denir. Selenium, birkaç
        pencere arasında kontrolü değiştirmek için bu benzersiz kimliği kullanır
        ​
        Tabs(Sekmeler)
        ●switchTo() => pencereler arasında geçiş yapma(switch) metodu
        ●getWindowHandle() => WebDriver'ın o anda kontrol ettiği sayfanın window handle'ini almak için kullanılır. String return eder.
        ●getWindowHandles() =>Açık olan tüm pencerelerin window handle' lari ni almak için kullanılır. Set return eder.
        ●Syntax: driver.switchTo().window(driver.getWindowHandle);
        https://the internet.herokuapp.com/iframe
        ​
        Actions Class
        Fare ve klavye eylemlerini gerçekleştirmek için Actions class'ı kullanmamız gerekir.
        Actions Class birçok kullanışlı fare ve klavye işlevine sahiptir
        Çift tıklama (double click), sürükleme ve bırakma(drag and drop), fareyi hareket
        ettirme (mouse actions) gibi karmaşık fare eylemleri icin v eya Keyword ile
        yapabilecegimiz pageUp,pageDown,shift,arrowDown gibi islemleri Actions
        classindan object ureterek yapariz
        ​
        1.Adım: Actions class'ta bir object oluşturulur.
        Actions actions = new Actions(driver);
        2. Adım: Üzerinde çalışmak istediğiniz WebElement öğesini bulunur.
        WebElement element = driver.findElement(By.id("ID");
        3.Adim : Ardından bu webelement üzerinde action gerçekleştirilir. Örneğin sağ tıklamak için
        actions.contextClick(element)
        perform() :En sonda action'ı gerçekleştirmek için kullanılır
        ​
        Mouse  Aksiyonlari
        ■ doubleClick (): Öğeye çift tıklama yapar
        ■ clickAndHold (): Fareyi serbest bırakmadan uzun tıklama yapar
        ■ dragAndDrop (): Öğeyi bir noktadan diğerine sürükler ve bırakır
        ■ moveToElement (): Fare işaretçisini öğenin ortasına kaydırır
        ■ contextClick (): Fare üzerinde sağ tıklama yapar
        ​
        Keyboard Base Actions
        Klavye Aksiyonlari
        Klavye aksiyonlari ile klavyedeki tuslari control edebiliriz. Bunun icin 3 tane aksiyon
        kullaniriz.
        ■ sendKeys (): Öğeye bir dizi anahtar gönderir
        ■ keyDown (): Klavyede tuşa basma işlemi gerçekleştirir
        ■ keyUp (): Klavyede tuşu serbest bırakma işlemi gerçekleştirir*/
