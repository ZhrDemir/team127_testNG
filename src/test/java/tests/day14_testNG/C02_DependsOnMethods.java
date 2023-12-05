package tests.day14_testNG;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    @Test(dependsOnMethods = "testotomasyonuTesti")
    public  void amazonTesti(){
        System.out.println("amazon Testi PASSED");
    }



    @Test
    public void testotomasyonuTesti(){
        System.out.println("Test Otomasyonu testi PASSED");
    }


    @Test(dependsOnMethods = "amazonTesti")
    public void wisequarterTest(){
        System.out.println("Wise Quarter testi PASSED");
    }





}
