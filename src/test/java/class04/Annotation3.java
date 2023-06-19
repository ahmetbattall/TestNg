package class04;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Annotation3 {

    @BeforeTest
    public void BeforeTest(){
        System.out.println("i am before test");
    }

    @AfterTest
    public  void AfterTest(){
        System.out.println("i am after test");
    }





















}
