package tests.day14_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassKullanimi {

    @Test
    public void test01() throws InterruptedException {
        /* POM hazırlayanlar
        WebDriver ı static method a koymuşlar

         */

        //testotomasyona gidin
        Driver.getDriver().get("https://testotomasyonu.com");

        //arama kutusuna phone yazıp aratalım

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);


        Thread.sleep(3000);

        Driver.closeDriver();

    }

}
