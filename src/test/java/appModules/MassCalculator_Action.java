package appModules;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.MassCalculator_Page;

public class MassCalculator_Action {
	public static void Execute(WebDriver driver, String density, String density_unit, String volume, String volume_unit){
		MassCalculator_Page.density_input_text(driver).clear();
	    MassCalculator_Page.density_input_text(driver).sendKeys(density);
	    
	    MassCalculator_Page.density_select_unit(driver).selectByVisibleText(density_unit);
	    
	    MassCalculator_Page.volume_input_text(driver).clear();
	    MassCalculator_Page.volume_input_text(driver).sendKeys(volume);
	    
	    MassCalculator_Page.volume_select_unit(driver).selectByVisibleText(volume_unit);
	    
	    MassCalculator_Page.calculate_boutton(driver).click();
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    List<WebElement> tr_collection = MassCalculator_Page.table_result(driver).findElements(By.tagName("tr"));
	    
	    System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
	    
	    int num_tr, num_col;
	    num_tr = 1;
	    
	    for(WebElement trElement : tr_collection)
	    {
	    	num_col = 1;
	    	List<WebElement> td_collection = trElement.findElements(By.tagName("td"));
	    	for(WebElement tdElement : td_collection)
	    	{
	    		System.out.println("row # "+num_tr+", col # "+num_col+ "text="+tdElement.getText());
	    		num_col++;
	    	}
	    	
	    	num_tr++;
	    }
	}
}
