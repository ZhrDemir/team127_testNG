package tests.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class P02_Before_After {


    @BeforeClass
    public void setup(){
        System.out.println("Tüm testler çalıştırılmaya başlanıyor.");

    }
        @Test
        public void wise(){
            Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));

        }

   @AfterClass
    public void tearDown(){
       System.out.println("Çalıştırılabilecek tüm testler çalıştırıldı.");
       Driver.quitDriver();
   }


}
