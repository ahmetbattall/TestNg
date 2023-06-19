package class03;

import Utils.CommonMethods;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenerABC extends CommonMethods implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {

        try {
            takeScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            takeScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
