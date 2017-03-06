package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DensityCalculator_Page {
	public static WebElement element = null;
	public static Select select = null;
	
	public static WebElement density_input_text(WebDriver driver){
		element = driver.findElement(By.id("cdensity"));
		return element;
	}
	
	public static Select density_select(WebDriver driver){
		select = new Select(driver.findElement(By.id("cdensityunit")));
		return select;
	}
	
	public static WebElement volume_input_text(WebDriver driver){
		element = driver.findElement(By.id("cvolume"));
		return element;
	}
	
	public static Select volume_select(WebDriver driver){
		select = new Select(driver.findElement(By.id("cvolumeunit")));
		return select;
	}
	
	public static WebElement mass_input_text(WebDriver driver){
		element = driver.findElement(By.id("cmass"));
		return element;
	}
	
	public static Select mass_select(WebDriver driver){
		select = new Select(driver.findElement(By.name("cmassunit")));
		return select;
	}
	
	public static WebElement resultat_text(WebDriver driver){
		element = driver.findElement(By.xpath("//p[@class='bigtext']/font/b"));
		return element;
	}
	
	public static WebElement calculate_boutton(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type=\"image\"]"));
		return element;
	}
}
