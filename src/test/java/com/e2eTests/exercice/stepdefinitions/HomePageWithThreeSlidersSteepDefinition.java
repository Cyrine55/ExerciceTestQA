package com.e2eTests.exercice.stepdefinitions;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.e2eTests.exercice.page_objects.HomePage;
import com.e2eTests.exercice.utils.ConfigFileReader;
import com.e2eTests.exercice.utils.Setup;
import com.e2eTests.exercice.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageWithThreeSlidersSteepDefinition {
	public ConfigFileReader configFileReader;
	public HomePage homePage;
	public Validations validations;

	public HomePageWithThreeSlidersSteepDefinition() {
		configFileReader = new ConfigFileReader();
		homePage = new HomePage();
		validations=new Validations();
	}
	
	@Given("Ouvrir application")
	public void ouvrirApplication() {
	Setup.getDriver().get(configFileReader.getProperties("home.url"));
	}
	@When("Cliquer sur le bouton menu Shop")
	public void cliquerSurLeBoutonMenuShop() {
		homePage.clicShopMenu();  
	}
	@When("Cliquer sur le bouton menu Home")
	public void cliquerSurLeBoutonMenuHome() {
		homePage.clickHomeBtn(); 
	}
	
	@Then("I validate the outcomes with {string} sliders")
	public void iValidateTheOutcomesWithSliders(String nbSliders) {
		int expectedNumberOfSliders = Integer.parseInt(nbSliders);
		int actualNumberOfSliders = homePage.validate3Sliders();
		assertEquals(expectedNumberOfSliders, actualNumberOfSliders);
		
	}





}
