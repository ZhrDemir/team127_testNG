package tests.day15_configuration_driver_Kullanimi;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_WebuniversityTesti {

    @Test
    public void negatifLoginTesti(){

      // 1.“http://webdriveruniversity.com/” adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");

      // 2.“Login Portal” a kadar asagi inin


        WebuniversityPage webuniversityPage=new WebuniversityPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",webuniversityPage.loginPortalElement);
        ReusableMethods.bekle(3);

      // 3.“Login Portal” a tiklayin
        webuniversityPage.loginPortalElement.click();

      // 4.Diger window’a gecin
        ReusableMethods.titleIleSayfaDegistir("WebDriver | Login Portal");

      // 5.“username” ve “password” kutularina deger yazdirin

        Faker faker = new Faker();

       webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
       webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());

      // 6.“login” butonuna basin
        webuniversityPage.loginButonu.click();

        ReusableMethods.bekle(3);
      // 7.Popup’ta cikan yazinin “validation failed” oldugunu test edin

        String actualYazi = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualYazi,"validation failed");

      // 8.Ok diyerek Popup’i kapatin
        Driver.getDriver().switchTo().alert().accept();

      // 9.Ilk sayfaya geri donun
        String ilkSfTitle = "WebDriverUniversity.com";
        ReusableMethods.titleIleSayfaDegistir(ilkSfTitle);

      // 10.Ilk sayfaya donuldugunu test edin
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,ilkSfTitle);

        ReusableMethods.bekle(3);
        Driver.quitDriver();

    }
}
