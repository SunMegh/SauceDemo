### Sauce Demo - Product Purchase

###### How to run the tests

The test can be executed by running the TestRunner.

1) Open the test folder under the Project Test_Automation_Test
2) Open the **TestRunner** file by navigating to the Java Package com.sr2.runner
3) Execute the tests by clicking the run icon or press ctrl + shift + F10

Note:- This program has been written in windows 10. If you'd like to execute this program in any other OS please download compatible "geckodriver" and replace it under the src/test/resoures



###### Framework Design 

Test has been carried out using Behaviour Driven Development. To achieve this objective I've used following tools
    a) Cucumber 
    b) Selenium   

###### Cucumber 
The acceptance criteria has been described using Gherkin Language. This acceptance criteria can be found in the PurchaseProductItems.feature file.
The objective of this feature file is to test the Sauce Demo Lab Web pages e2e functionality. 
However, for the purpose of this work I've selected just a particular scenario, which is "Login and add cheapest and 2nd costliest product to the basket and purchase it".
In a normal scenario this file contains multiple acceptance scenarios and edge cases. 

###### Technical Details of cucumber tests
1) Gherkin steps defined under PurchaseProductItems.feature.
2) Glue code has been written in SauceLabsSteps.java, CommonSteps.java and SharedSteps.java.
3) The Cucumber Test Runner has been written in TestRunner.java


###### Selenium 
SauceLabs Web Application user interface has been tested using Selenium.
To achieve this objective 'geckodriver' driver which communicates with Firefox browser has been used. 
Some of the best practices of Selenium i.e. Page Objects, decoupling of config details, etc. 
 
 ###### Technical Details of Selenium tests
 1) Web Driver Program has been coded in WebDriverManager.java.
 2) Page Objects has been coded in SauceLabsPage.java.
 3) Config details has been coded in ConfigUtils.java.
 4) Dynamic config details has been maintained under test.properties 
 
 Note:-  Successful Test Run Evidence attached 
  
 
 ![Alt text](Capture.PNG?raw=true "Title")
 

 
  
 

 

 






 


