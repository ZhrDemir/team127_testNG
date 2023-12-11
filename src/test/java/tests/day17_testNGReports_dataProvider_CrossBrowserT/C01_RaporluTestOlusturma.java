package tests.day17_testNGReports_dataProvider_CrossBrowserT;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static org.testng.Assert.assertTrue;

public class C01_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void aramaTesti(){

        extentTest = extentReports.createTest("Arama Testi","Kullanıcı belirlenen kelimeyi aratıp doğru olduğunu test eder");

        // testotomasyonu anasf a gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanıcı testotomasyonu anasf a gider");

        // belirlenen arama kelimesi  için arama yapın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        extentTest.info("belirlenen arama kelimesi için arama yapar");

        // arama sonucunda ürün bulunabildiğini test edin
        int aramaSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        assertTrue(aramaSonucSayisi>0);
        extentTest.pass("arama sonucunda ürün bulunabildiğini test eder");


        // ilk ürünü tıklayın
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        //açılan ürün sf da case sensitive olmadan belirlenen arama kelimesi
        // içerdiğini test edin
        String actualUrunIsmiKucukHarf=testOtomasyonuPage
                                                .urunSayfasindakiUrunIsimElementi
                                                .getText().toLowerCase();
        assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));
        extentTest.pass("açılan ürün sf da case sensitive olmadan\nbelirlenen arama kelimesi\n" +
                "içerdiğini test eder");






    }
}
