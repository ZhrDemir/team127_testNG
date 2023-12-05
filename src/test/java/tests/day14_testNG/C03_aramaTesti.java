package tests.day14_testNG;




import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;
import java.util.TreeMap;

    public class C03_aramaTesti {

        // gerekli ayarları yapıp
        // 3 test methodu oluşturun

        WebDriver driver;

        @Test
        public void anasayfaTesti() {

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // 1-testotomasyonu sf git doğru adrese gittiğini test et

            driver.get("https://www.testotomasyonu.com");

            String expectedURL ="https://www.testotomasyonu.com/";
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL,expectedURL);

        }

        @Test(dependsOnMethods = "anasayfaTesti")
        public void aramaTesti(){
            // 2-phone için arama yapıp urun bulunabildiğini test et

            WebElement aramaKutusu = driver.findElement(By.id("global-search"));
            aramaKutusu.sendKeys("phone"+ Keys.ENTER);

            WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
            String unexpectedSonucYazisi = "0 Products Found";
            String actualSonucYazisi = aramaSonucElementi.getText();
            Assert.assertNotEquals(unexpectedSonucYazisi,actualSonucYazisi);


        }

        @Test(dependsOnMethods = "anasayfaTesti")
        public void urunIsimTesti(){
            // 3-ilk urune tıklayıp açılan urun sf da ,
            // isminin case sensitive olmadan phone içerdiğini test et

            driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();
            WebElement urunIsımElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

            String expectedIsimIcerik = "phone";
            String actualIsimIcerik = urunIsımElementi.getText().toLowerCase();
            Assert.assertTrue(actualIsimIcerik.contains(expectedIsimIcerik));


            driver.quit();

        }
}
