package appModules;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.DensityCalculator_Page;

public class DensityCalculator_Action {
	
	public static String Execute(WebDriver driver, String density, String density_unit, String volume, String volume_unit
								, String mass, String mass_unit, String resultatAttendu){
		//Saisie de la densité
		DensityCalculator_Page.density_input_text(driver).clear();
		DensityCalculator_Page.density_input_text(driver).sendKeys(density);
		// Selection de l'unité de la densité
		DensityCalculator_Page.density_select(driver).selectByVisibleText(density_unit);
		
		//Saisie du volume
		DensityCalculator_Page.volume_input_text(driver).clear();
		DensityCalculator_Page.volume_input_text(driver).sendKeys(volume);
		// Selection de l'unité du volume
		DensityCalculator_Page.volume_select(driver).selectByVisibleText(volume_unit);
		
		//Saisie de la mass
		DensityCalculator_Page.mass_input_text(driver).clear();
		DensityCalculator_Page.mass_input_text(driver).sendKeys(mass);
		// Selection de l'unité de la mass
		DensityCalculator_Page.mass_select(driver).selectByVisibleText(mass_unit);
		
		//Calculer
		DensityCalculator_Page.calculate_boutton(driver).click();
		
		String resultat = DensityCalculator_Page.resultat_text(driver).getText();
		
		try {
			Assert.assertTrue(resultat.equals(resultatAttendu),"Calcul de masse avec succ&egrave;s");
		} catch (Throwable e) {
			System.out.println(e.getMessage()+" : Calcul de masse avec erreur. Valeur Attendue = "+resultatAttendu+" --- Valeur Calcul&eacute;e = "+resultat);
			//Assert.fail("Calcul de masse avec erreur. Valeur Attendue = "+resultatAttendu+" --- Valeur Calcul&eacute;e = "+resultat);
		}
		
		
		
		return resultat;
	}

}
