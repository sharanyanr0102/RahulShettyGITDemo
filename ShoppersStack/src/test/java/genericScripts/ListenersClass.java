package genericScripts;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersClass implements ITestListener
{
	ExtentReports extentReports = ExtentReporterClass.getExtentReportObject();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
		threadLocal.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Completed Successfully");
	}

	public void onTestFailure(ITestResult result)
	{
		
		extentTest.fail(result.getThrowable());
		try {
			WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			String imgPath = TakePhoto.takePhoto(driver, result.getMethod().getMethodName());
			extentTest.addScreenCaptureFromBase64String(imgPath, result.getMethod().getMethodName());
			
			
//			result.getTestClass().getRealClass().getField(null)
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}

