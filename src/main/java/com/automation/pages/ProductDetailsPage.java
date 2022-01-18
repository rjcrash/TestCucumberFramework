package com.automation.pages;

import com.automation.utils.AssertionUtils;
import com.automation.utils.CommonUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.utils.DriverUtils.getDriver;

public class ProductDetailsPage {

    @FindBy(id = "productTitle")
    private  WebElement productTitle;

    @FindBy(id = "acrCustomerReviewText")
    private  WebElement productBadge;

    @FindBy(xpath = "//li[@class='swatchElement selected resizedSwatchElement']//a[@role='button']/span")
    private  WebElement productType;

    @FindBy(id = "price")
    private  WebElement productPrice;

    @FindBy(id = "add-to-cart-button")
    private  WebElement addToBasket;

    @FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    private  WebElement addedProductNotification;

    @FindBy(xpath = "//div[@id='sw-atc-details-single-container']//i[@class='a-icon a-icon-alert']")
    private  WebElement addedProductNotificationTitle;

    @FindBy(id="nav-cart-count")
    private  WebElement itemInBasket;

    @FindBy(xpath="//div/span[@class='nav-line-2']")
    private  WebElement basket;

    public ProductDetailsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void verifyProductTitle(String title) {
        AssertionUtils.assertEquals(productTitle,title);
    }

    public void verifyProductType(String type) {
        AssertionUtils.assertEquals(productType,type);
    }

    public void verifyProductPrice(String price, String currency) {
        if(currency.equals("pounds")){
            price = "£"+price;
        }
        AssertionUtils.assertEquals(productPrice,price);
    }

    public void verifyProductBadge(String badge) {
        AssertionUtils.assertNotEquals(productBadge,badge);
    }

    public void addIntoBasket() {
        CommonUtils.scrollToView(addToBasket);
        CommonUtils.clickOnElement(addToBasket);

    }

    public void verifyNotificationTitle(String title) {
        AssertionUtils.assertEquals(addedProductNotification,title);
    }

    public void verifyNotification(String shown) {
        if (shown.equals("is")){
            AssertionUtils.assertPresent(addedProductNotificationTitle);
        }

    }

    public void verifyProductsItemsInBasket(int items) {
        AssertionUtils.assertEquals(itemInBasket,items);
    }

    public void goToBasket() {
        CommonUtils.clickOnElement(basket);
    }
}
