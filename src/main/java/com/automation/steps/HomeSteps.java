package com.automation.steps;

import cucumber.api.java.en.And;
import com.automation.pages.HomePage;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @And("^I navigate to Home Page$")
    public void navigateToHomePage(){
        homePage.navigateToHomePage();
    }

    @And("^I select search section (.*) and type (.*)$")
    public void searchForItem(String section, String item){
        homePage.searchForItem(section,item);
    }

    @And("^I verify that the first item contains title (.*)$")
    public void verifyTitleContains(String title){
        homePage.verifyTitleContains(title);
    }

    @And("^I verify item if it has any badge$")
    public void verifyAnyBadges(){
        homePage.verifyAnyBadges("0,000");
    }

    @And("^I verify the selected type is (.*)$")
    public void verifyType(String type){
        homePage.verifyType(type);
    }

    @And("^I verify the price is (.*) in (.*)$")
    public void verifyPrice(String price, String currency){
        homePage.verifyPrice(price, currency);
    }

    @And("^I navigate to the first book details$")
    public void navigateToFirstBookDetails(){
        homePage.navigateToFirstBookDetails();
    }

    @And("^I verify that Home Page title is (.*)$")
    public void verifyPageTitle(String title){
        homePage.verifyPageTitle(title);
    }
}
