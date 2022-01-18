package com.automation.steps;

import com.automation.pages.BasketPage;
import cucumber.api.java.en.And;

public class BasketSteps {

    BasketPage basketPage = new BasketPage();

    @And("^I verify that the book in basket (.*) shown on the list$")
    public void verifyBookOnList(String shown){
        basketPage.verifyBookOnList(shown);
    }

    @And("^I verify that the book in basket has title (.*)$")
    public void verifyItemTitleInBasket(String title){
        basketPage.verifyItemTitleInBasket(title);
    }

    @And("^I verify that the book type is (.*)$")
    public void verifyItemTypeInBasket(String type){
        basketPage.verifyItemTypeInBasket(type);
    }

    @And("I verify that the quantity is (\\d)$")
    public void verifyQuantityInBasket(int quantity){
        basketPage.verifyItemsInBasket(quantity);
    }

    @And("^I verify that the book price is (.*) in (.*)$")
    public void verifyBasketItemPrice(String price,String currency){
        basketPage.verifyBasketItemPrice(price,currency);
    }

    @And("^I verify that the total price is (.*) in (.*)$")
    public void verifyBasketTotalPrice(String price,String currency){
        basketPage.verifyBasketTotalPrice(price,currency);
    }
}
