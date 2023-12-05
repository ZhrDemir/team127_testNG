package tests.day14_testNG;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test
    public  void youtubeTesti(){
        System.out.println("Youtube Testi PASSED");
    }



    @Test(priority = -10)
    public void testotomasyonuTesti(){
        System.out.println("Test Otomasyonu testi PASSED");
    }


    @Test(priority = 5)
    public void wisequarterTest(){
        System.out.println("Wise Quarter testi PASSED");
    }

}
