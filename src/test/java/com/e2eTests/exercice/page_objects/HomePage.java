package com.e2eTests.exercice.page_objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.exercice.utils.BasePage;
import com.e2eTests.exercice.utils.SeleniumUtils;
import com.e2eTests.exercice.utils.Setup;

public class HomePage extends BasePage {
	SeleniumUtils seleniumUtils;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Shop']")
	private static WebElement shopBtn;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Home']")
	private static WebElement homeBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='n2-ss-6-arrow-next']")
	private static WebElement arrowIcon;
	@FindBy(how = How.XPATH, using = "//img[@class='n2-ss-slide-background-image n2-ss-slide-fill n2-ow']")
	private static WebElement backgroundImg;
	
	@FindBy(how = How.CSS, using = ".n2-ss-slide-background-image")
	private static List<WebElement> listSliders;
	public HomePage() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
	}

	public void clicShopMenu() {
		seleniumUtils.click(shopBtn);
	}
	
	public void clickHomeBtn() {
		seleniumUtils.click(homeBtn);	
	}
	
	public int validate3Sliders() {
		int sizeList=0;
		for(WebElement size:listSliders) {
			seleniumUtils.click(arrowIcon);
			//sizeList ++;
			//System.out.println(sizeList);
			return listSliders.size();
		}
		return sizeList;
		
	}

}