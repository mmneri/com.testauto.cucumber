package automotation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.LogStatus;

import appModules.MassCalculator_Action;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.Log;

public class MassCalculator extends Hooks {
	
	 @BeforeClass
	 public void M1(){		  
		  
	 }
	 
	 @BeforeMethod
	 public void beforeMethod() {
		  test = extent.startTest("Mass Calculator ("+Hooks.browser+")", "Mass Calculator ("+Hooks.browser+")");
		  driver.get(Constant.URL_Mass);
		  Log.info("Open URL : "+Constant.URL_Mass);
		  test.log(LogStatus.PASS, "Open URL : "+Constant.URL_Mass);
	 }
	 
	 @Test
	 public void massCalculate() throws Exception {
		  ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.Mass_Sheet);
		  
		  String density = ExcelUtils.getCellData(1, 0);
		  String density_unit = ExcelUtils.getCellData(1, 1);
		  String volume = ExcelUtils.getCellData(1, 2);
		  String volume_unit = ExcelUtils.getCellData(1, 3);
		  MassCalculator_Action.Execute(driver,density, density_unit, volume, volume_unit);
		  
		  test.log(LogStatus.PASS, "Calcul de masse","Calcul de masse avec succ&egrave;s");
		  ExcelUtils.setCellData("Passed", 1, 4);
	  }
	 
	 @AfterMethod
	  public void AfterMethod()
	  {
		   extent.endTest(test);
	  }
}
