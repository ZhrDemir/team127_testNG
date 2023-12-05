package tests.day14_testNG;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class C07_CheckBoxTesti {

    @Test
    public void test01(){


   // a. Verilen web sayfasına gidin.
   // https://testotomasyonu.com/form

        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        Driver.getDriver().get("https://testotomasyonu.com/form");

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

   // b. Sirt Agrisi ve Carpinti checkbox’larini secin
        testOtomasyonuFormPage.carpıntıCheckBoxKutusu.click();
        testOtomasyonuFormPage.sirtAgrisiCheckBoxKutusu.click();

   // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assert.assertTrue(testOtomasyonuFormPage.carpıntıCheckBoxKutusu.isSelected());
        Assert.assertTrue(testOtomasyonuFormPage.sirtAgrisiCheckBoxKutusu.isSelected());

   // d. Seker ve Epilepsi checkbox’larininin seçili   olmadigini test edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

        Assert.assertFalse(testOtomasyonuFormPage.sekerCheckBoxKutusu.isSelected());
        Assert.assertFalse(testOtomasyonuFormPage.epilepsiCheckBoxKutusu.isSelected());
        ReusableMethods.bekle(2);

        Driver.quitDriver();

}
 }