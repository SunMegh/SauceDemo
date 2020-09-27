@regression
Feature: Purchase chepeast and second costliest products
  
  Scenario Outline: Login and add cheapest product and 2nd costliest to the basket and purchase it
	Given I login to Sauce labs home page with "<username>" and "<password>"
	When I sort the products by price from "<highTolow>"
	Then I select cheapest and second costliest products to the basket and open the basket
	And I click on checkout button in "Your Cart" page
	And I enter the details "<firstName>","<lastName>","<postcode>"and finish purchase
	
	Examples:
	  | username      | password     | highTolow | firstName | lastName | postcode |
	  | standard_user | secret_sauce | hilo      | Sunil     | Megharaj | SW1A 0AA |
	