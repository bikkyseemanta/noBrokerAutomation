package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Utilities;

public class NoBroker {

	WebDriver driver;

	public NoBroker(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[text()='Buy'])[1]")
	public WebElement buttonTabBuy;

	@FindBy(xpath = "//div[contains(@class,'prop-search-city-selector')]/div")
	public WebElement citySelector;

	@FindBy(xpath = "//div[text()='Buy']/parent::div/following::div//div[text()='Mumbai']")
	public List<WebElement> citySelectorWithTextMumbai;

	@FindBy(xpath = "(//div[text()='Buy']/parent::div/following::div//div[text()='Mumbai'])[2]")
	public WebElement mumbaiOptionInCitySelectorDropdownAfterClick;

	@FindBy(xpath = "//input[@id='listPageSearchLocality']")
	public WebElement inputHomepageSearch;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement buttonHomepageSearch;
	
	@FindBy(xpath = "//div[text()='Apartment Type']/parent::div/parent::div")
	public WebElement selectorForBHKType;
	
	@FindBy(xpath = "//div[text()='Apartment Type']/parent::div/parent::div/following::div/div[@class='nb-checkbox checkbox']//input")
	public List<WebElement> checkBoxesForBHKTypes;

	@FindBy(xpath = "//div[text()='Apartment Type']/parent::div/parent::div/following::div/div[@class='nb-checkbox checkbox']//span")
	public List<WebElement> namesForBHKTypes;

	@FindBy(xpath = "//article/div[2]")
	public List<WebElement> cardsOnProperties;

	@FindBy(xpath = "//div[@id='description']")
	public WebElement resultPageDescriptionSection;

	public void openApp() {

		try {
			System.out.println("Launching Webpage URL");
			driver.manage().window().maximize();
			driver.get(Utilities.getConfigProperty("url"));
//			Utilities.waitForPageLoad(driver);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterLocationValuesInSearchBoxViaAction(WebElement element, String inputString)
			throws InterruptedException {

		Actions action = new Actions(driver);
		inputHomepageSearch.click();
		Thread.sleep(1000);

		Utilities.pressKeysViaAction(element, inputString);
		Thread.sleep(2000);
		action.sendKeys(element, Keys.ARROW_DOWN).build().perform();
		Thread.sleep(200);
		action.sendKeys(element, Keys.RETURN).build().perform();

	}

	public void enterLocationValuesInSearchBoxViaRobot(WebElement element, String inputString) throws Exception {

		element.click();
		Thread.sleep(1000);
		
		Utilities.pressKeysViaRobot(inputString);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(element, Keys.ARROW_DOWN).build().perform();
		Thread.sleep(200);
		action.sendKeys(element, Keys.RETURN).build().perform();

	}
}
