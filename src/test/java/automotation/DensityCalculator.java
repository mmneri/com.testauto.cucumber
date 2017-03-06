package automotation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import appModules.DensityCalculator_Action;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.ExtentManager;
import utilities.Log;

public class DensityCalculator extends Hooks {
	
	@BeforeClass
	 public void M1() throws Exception{
		  extent = ExtentManager.getInstance();
	}

	@BeforeMethod
	public void beforeMethod() {
		test = extent.startTest("Density Calculator ("+Hooks.browser+")", "Density Calculator ("+Hooks.browser+")");
		driver.get(Constant.URL_Density);
		driver.manage().window().maximize();
		Log.info("Open URL : "+Constant.URL_Density);
	}
	
	@Test(dataProvider="densityData")
	public void densityCalculate(String id, String density, String density_unit,
						  String volume, String volume_unit,
						  String mass, String mass_unit, String resultatAttendu) throws Exception {	  
	  	  
		String resultat = DensityCalculator_Action.Execute(driver,density, density_unit, volume, volume_unit, mass, mass_unit, resultatAttendu);
		int i;
		i = Integer.parseInt(id);
		if(resultat.equals(resultatAttendu)){
			ExcelUtils.setCellData("Passed", i, 8);
			test.log(LogStatus.PASS, "Calcul de la densit&eacute;", "Calcul de la densit&eacute; avec succ&egrave;s");
			Log.info("le resultat calculé est juste");
		}else{
			ExcelUtils.setCellData("Failed", i, 8);
			String imagePath= ExtentManager.CaptureScreen(driver);
	        String image = test.addScreenCapture(imagePath);
			test.log(LogStatus.FAIL, "Calcul de la densit&eacute;", "Calcul de masse avec erreur. Valeur Attendue = "+resultatAttendu+" --- Valeur Calcul&eacute;e = "+resultat+image);
			Log.error("le resultat calculé est faux" );
		}
	}
	
	@DataProvider(name="densityData") 
    public static Object[][] densityDatas() throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.Density_Sheet);
		Object[][] testObjArray = ExcelUtils.getTableArray(1,0,7);
		return testObjArray;
	}
	
	@AfterMethod
	public void AfterMethod()
	{
	   extent.endTest(test);
	}
}
