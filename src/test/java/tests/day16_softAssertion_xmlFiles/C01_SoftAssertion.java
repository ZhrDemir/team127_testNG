package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SoftAssertion {


    @Test
    public void softAssertionTesti(){

        //testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //title ın Test içerdiğini test edin
        String expectedTitleIcerik = "Test";
        String actualTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitleIcerik),"title test içermiyor");

        //url in https://www.testotomasyonu.com olduğunu test edin
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Url beklenenden farklı");

        //arama kutusunun kullanılabilir durumda old test edin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        softAssert.assertTrue(testOtomasyonuPage.aramaKutusu.isEnabled(),"arama kutusu kullanılamıyor");

        //belirlenmiş aranacak kelimeyi aratıp urun bulunduğunu test edin
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        int bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        softAssert.assertTrue(bulunanSonucSayisi>0,"Kayıtlı kelime arandığında urun bulunamadı");

        // Nutella aratip, urun bulunamadığını test edin
        ReusableMethods.bekle(2);
        testOtomasyonuPage.aramaKutusu.clear();
        testOtomasyonuPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        ReusableMethods.bekle(2);
        bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        softAssert.assertTrue(bulunanSonucSayisi==0,"Nutella bulundu");

        softAssert.assertAll();

        // sayfayi kapatin
        //ReusableMethods.bekle(2);
        Driver.quitDriver();
    }





    }

