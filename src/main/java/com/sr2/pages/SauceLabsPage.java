package com.sr2.pages;

import com.sr2.test.configutils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SauceLabsPage {

	private WebDriver driver;

	@FindBy(css = "#user-name")
	private WebElement userName;

	@FindBy(css = "#password")
	private WebElement password;

	@FindBy(css = "#login-button")
	private WebElement loginButton;

	@FindBy(css = "div.product_label")
	private WebElement productLabel;

	@FindBy(css = "#inventory_container>div.inventory_list>div.inventory_item")
	private List<WebElement> inventoryItemList;

	@FindBy(css = "#shopping_cart_container>a>span.fa-layers-counter.shopping_cart_badge")
	private WebElement itemAddedToShoppingCart;

	@FindBy(css = "div.cart_footer>a.btn_action.checkout_button")
	private WebElement checkOutBtn;

	@FindBy(css = "#contents_wrapper>div.subheader")
	private WebElement subHeader;

	@FindBy(css = "#first-name")
	private WebElement firstName;

	@FindBy(css = "#last-name")
	private WebElement lastName;

	@FindBy(css = "#postal-code")
	private WebElement postalCode;


	@FindBy(css = "div.checkout_buttons>input[value='CONTINUE']")
	private WebElement continueBtn;


	@FindBy(css = "div.cart_footer>a.btn_action.cart_button")
	private WebElement finishBtn;

	@FindBy(css = "#checkout_complete_container>h2")
	private WebElement thankYouForYourOrder;


	public SauceLabsPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}


	public void waitForElementVisible(String elementLocator, int timesecs) {
		WebElement element = (new WebDriverWait(driver, timesecs))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementLocator)));
	}


	public void gotoSauceLabsHomePage() {
		driver.get(ConfigUtils.getWebEndPoint());
	}


    public void isUserNameDisplayed(){
        userName.isDisplayed();

    }

    public void enterUserName(String userNameText){
        userName.sendKeys(userNameText);

	}

    public void enterPassword(String passwordText){
        password.sendKeys(passwordText);
    }

    public void clickLoginBtn(){
        loginButton.click();
    }

    public void selectNameFromDropdown(String toSelectValue){
        Select s = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        s.selectByValue(toSelectValue);
    }

    public boolean isProductLabelDisplayed(){
		return productLabel.isDisplayed();
	}

	public void getListofProductItemsAndAddToBasket() throws InterruptedException {
		String priceVal;
		String actPriceVal;
		boolean secCostliestPrice = false;
		boolean lowestPrice = false;

		ArrayList<Float> priceList = new ArrayList<Float>();
		for(int i=1; i<=inventoryItemList.size(); i++){
			priceVal = driver.findElement(By.cssSelector("#inventory_container>div.inventory_list>div.inventory_item:nth-child("+i+")>div.pricebar>div.inventory_item_price")).getText();
			//Thread.sleep(500);
			priceVal = priceVal.replace("$","");
			float price = Float.parseFloat(priceVal);
			priceList.add(price);
		}


		Collections.sort(priceList);


		for(int j=1;j<=priceList.size(); j++){
			WebElement addToCartElement = driver.findElement(By.cssSelector("#inventory_container>div.inventory_list>div.inventory_item:nth-child("+j+")>div.pricebar>button.btn_primary.btn_inventory"));

			actPriceVal = driver.findElement(By.cssSelector("#inventory_container>div.inventory_list>div.inventory_item:nth-child("+j+")>div.pricebar>div.inventory_item_price")).getText();
			actPriceVal = actPriceVal.replace("$","");
			float actPrice = Float.parseFloat(actPriceVal);

			//1st cheapest item
			if(actPrice==priceList.get(0)){
				addToCartElement.click();

				if (itemAddedToCart()>0){
					lowestPrice=true;
				}
			}

			//2nd costliest item
			float expPrice = priceList.get(priceList.size()-2);

			if(actPrice==expPrice){
				addToCartElement.click();

				if (itemAddedToCart()>0){
					secCostliestPrice =true;
				}
			}

			//click on the cart when both products added
			if(lowestPrice && secCostliestPrice){
				itemAddedToShoppingCart.click();
			}


		}

	};


	public int itemAddedToCart(){
		String itemAdded = itemAddedToShoppingCart.getText();
		int noOfitemsAdded = Integer.parseInt(itemAdded);
		return noOfitemsAdded;
	};

	public void clickCheckoutButton(){
		checkOutBtn.click();
	};

	public boolean isCheckoutButtonDisplayed(){
		return checkOutBtn.isDisplayed();
	};


	public String headerInformaiton(){
		return subHeader.getText();
	};


	public void enterfirstName(String firstNameText){
		firstName.sendKeys(firstNameText);

	}

	public void enterlastName(String lastNameText){
		lastName.sendKeys(lastNameText);

	}

	public void enterpostalCode(String postalCodeText){
		postalCode.sendKeys(postalCodeText);

	}

	public void clickContinueButton(){
		continueBtn.click();
	}

	public void clickFinishButton(){
		finishBtn.click();
	}

	public String ThankYouInformaiton(){
		return thankYouForYourOrder.getText();
	};



	public void enterUserNameObj(String userNameText){
		userName.sendKeys(userNameText);
	}
}