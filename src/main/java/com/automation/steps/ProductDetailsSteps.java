package com.automation.steps;

import com.automation.pages.ProductDetailsPage;
import cucumber.api.java.en.And;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage = new ProductDetailsPage();


    @And("^I verify product title (.*)$")
    public void verifyProductTitle(String title){
        productDetailsPage.verifyProductTitle(title);
    }

    @And("^I verify the selected product type is (.*)$")
    public void verifyProductType(String type){
        productDetailsPage.verifyProductType(type);
    }

    @And("^I verify the product price is (.*) in (.*)$")
    public void verifyProductPrice(String price,String currency){
        productDetailsPage.verifyProductPrice(price,currency);
    }

    @And("I verify product item if it has any badge$")
    public void verifyProductBadge(){
        productDetailsPage.verifyProductBadge("0.000 ratings");
    }

    @And("I add the product into basket$")
    public void addIntoBasket(){
        productDetailsPage.addIntoBasket();
    }

    @And("I verify that the notification (.*) shown$")
    public void verifyNotification(String shown){
        productDetailsPage.verifyNotification(shown);
    }

    @And("I verify the title (.*)$")
    public void verifyNotificationTitle(String title){
        productDetailsPage.verifyNotificationTitle(title);
    }

    @And("verify there is (\\d) item in the basket$")
    public void verifyProductsItemsInBasket(int items){
        productDetailsPage.verifyProductsItemsInBasket(items);
    }

    @And("I click on the basket$")
    public void goToBasket(){
        productDetailsPage.goToBasket();
    }
}
