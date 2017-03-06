package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MassCalculator_Page {
	private static WebElement element = null;
	private static Select select = null;
	
	public static WebElement density_input_text(WebDriver driver){
		element = driver.findElement(By.id("cdensity"));
		return element;
	}
	
	public static Select density_select_unit(WebDriver driver){
		select = new Select(driver.findElement(By.id("cdensityunit")));
		return select;
	}
	
	public static WebElement volume_input_text(WebDriver driver){
		element = driver.findElement(By.id("cvolume"));
		return element;
	}
	
	public static Select volume_select_unit(WebDriver driver){
		select = new Select(driver.findElement(By.id("cvolumeunit")));
		return select;
	}
	
	public static WebElement calculate_boutton(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type=\"image\"]"));
		return element;
	}
	
	public static WebElement table_result(WebDriver driver){
		element = driver.findElement(By.className("cinfoT"));
		return element;
	}

}
