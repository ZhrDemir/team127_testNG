package tests.day15_configuration_driver_Kullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_HardAssertion {

    @Test
    public void hardAssertionTesti(){
        //testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //title ın Test içerdiğini test edin
        String expectedTitleIcerik = "Test";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //url in https://www.testotomasyonu.com olduğunu test edin
        String expectedUrl = "https://www.testotomasyonu.com";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        //arama kutusunun kullanılabilir durumda old test edin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        Assert.assertTrue(testOtomasyonuPage.aramaKutusu.isEnabled());


        //belirlenmiş aranacak kelimeyi aratıp urun bulunduğunu test edin
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        int bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(bulunanSonucSayisi>0);


        //Nutella aratıp, urun bulunduğunu test edin
        testOtomasyonuPage.aramaKutusu.clear();
        testOtomasyonuPage.aramaKutusu.sendKeys("Nutella"+Keys.ENTER);
        bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(bulunanSonucSayisi>0);

        //sayfayı kapatın
        Driver.quitDriver();




    }

}
