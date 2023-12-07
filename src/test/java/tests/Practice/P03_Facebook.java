package tests.Practice;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P03_Facebook {

    @Test
    public void FacebookTest(){


    //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));


    //2- POM'a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
    // 3- Faker class'ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

       FacebookPage facebook = new FacebookPage();

        Faker faker = new Faker();

       facebook.emailKutusu.sendKeys(faker.internet().emailAddress());
       facebook.passwordKutusu.sendKeys(faker.internet().password());
       facebook.loginButton.click();

    //4- Basarili giris yapilamadigini test edin

        Assert.assertTrue(facebook.message.isDisplayed());
        System.out.println(facebook.message.getText());
        Driver.quitDriver();
}

}
