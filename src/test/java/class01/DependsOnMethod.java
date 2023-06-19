package class01;

import org.testng.annotations.Test;

public class DependsOnMethod {
    @Test
    public void Login(){
        System.out.println(10/0);
    }

    @Test(dependsOnMethods={"Login"})
    public void TestTheDashBoard(){
        System.out.println("I am testing dashboard page");
    }




}
