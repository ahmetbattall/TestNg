package class01;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority =4,groups = "smoke")
    public void Atest(){
        System.out.println("I am a test");
    }
    @Test(priority = 3)
    public void Btest(){

    System.out.println("I am b test");
    }
    @Test(priority = 2)
    public void Ctest(){
    System.out.println("I am c test");

    }
    @Test(priority = 1)
    public void Dtest(){

        System.out.println("I am d test");
    }
    @Test
    public void ABtest(){
        System.out.println("I am ab test");
    }

}
