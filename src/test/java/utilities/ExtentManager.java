package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent; 
	public static ExtentReports getInstance(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String strDate = sdf.format(cal.getTime());
		String Path = "./src/extent-reports/run-"+strDate+".html";
		System.out.println(Path);
		if (extent == null)
			createInstance(Path);
    	
        return extent;
    }
    
    public static ExtentReports createInstance(String fileName) {
        
        extent = new ExtentReports(fileName);
        
        return extent;
    }
	public static String CaptureScreen(WebDriver driver){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		String strDate = sdf.format(cal.getTime());
		TakesScreenshot oScn = (TakesScreenshot) driver;
	    File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
	    File oDest = new File(Constant.Path_extentreports+Constant.Image_extentreports_folder+"\\images_"+strDate+".jpg");
	    try {
		      FileUtils.copyFile(oScnShot, oDest);
		 } catch (IOException e) {System.out.println(e.getMessage());}
		 return "./"+Constant.Image_extentreports_folder+"/images_"+strDate+".jpg";
	}
}