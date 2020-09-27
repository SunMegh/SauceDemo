package com.sr2.steps;

import com.sr2.pages.SauceLabsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SauceLabsSteps extends CommonSteps {

	
	public SauceLabsPage sauceLabsPage;
	
	public SauceLabsSteps(){
		sauceLabsPage = new SauceLabsPage(driver);
	}


	@Given("^I login to Sauce labs home page with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void iLoginToSauceLabsHomePageWithAnd(String userNameVal, String passwordVal) throws Throwable {
		sauceLabsPage.gotoSauceLabsHomePage();
		sauceLabsPage.enterUserName(userNameVal);
		sauceLabsPage.enterPassword(passwordVal);
		sauceLabsPage.clickLoginBtn();

	}

	@When("^I sort the products by price from \"([^\"]*)\"$")
	public void iSortTheProductsByPriceFrom(String sortPricedropDownVal) throws Throwable {
		if(sauceLabsPage.isProductLabelDisplayed()){
			sauceLabsPage.selectNameFromDropdown(sortPricedropDownVal);

		}
	}


	@Given("^I login to Sauce labs home page with \"([^\"]*)\" and \"([^\"]*)\" and finishs$")
	public void iLoginToSauceLabsHomePageWithAndAndFinishs(String strUsename, String strPasswd) throws Throwable {
		sauceLabsPage.enterUserNameObj(strUsename);
		sauceLabsPage.enterPassword(strPasswd);
		sauceLabsPage.clickLoginBtn();

	}


	@Then("^I select cheapest and second costliest products to the basket and open the basket$")
	public void iSelectCheapestAndSecondCostliestProductsToTheBasketAndOpenTheBasket() throws Throwable {
		sauceLabsPage.getListofProductItemsAndAddToBasket();
	}

	@And("^I click on checkout button in \"([^\"]*)\" page$")
	public void iClickOnCheckoutButtonInPage(String yourCart) throws Throwable {
		if(sauceLabsPage.headerInformaiton().equalsIgnoreCase(yourCart)){
			sauceLabsPage.clickCheckoutButton();
		}
	}


	@And("^I enter the details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"and finish purchase$")
	public void iEnterTheDetailsAndFinishPurchase(String strFirstName, String strLastName, String strPostCode) throws Throwable {
		if(sauceLabsPage.headerInformaiton().equalsIgnoreCase("Checkout: Your Information")) {
			sauceLabsPage.enterfirstName(strFirstName);
			sauceLabsPage.enterlastName(strLastName);
			sauceLabsPage.enterpostalCode(strPostCode);
			if (sauceLabsPage.headerInformaiton().equalsIgnoreCase("Checkout: Overview")) {
				sauceLabsPage.clickFinishButton();
			}

			if (sauceLabsPage.headerInformaiton().equalsIgnoreCase("Finish")) {
				sauceLabsPage.ThankYouInformaiton().equalsIgnoreCase("THANK YOU FOR YOUR ORDER");
			}
		}

	}
}
