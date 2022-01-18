package com.automation.pages;

import com.automation.utils.AssertionUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.utils.DriverUtils.getDriver;

public class BasketPage {


    @FindBy(xpath = "//img[@src='https://m.media-amazon.com/images/I/91bcAaV1+qL._AC_AA180_.jpg']")
    private WebElement bookImage;

    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    private WebElement basketProductTitle;

    @FindBy(xpath = "//span[@class='a-size-small sc-product-binding a-text-bold']")
    private WebElement basketProductType;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private WebElement basketProductQuantity;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    private WebElement basketItemPrice;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-buybox']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    private WebElement basketTotalPrice;

    public BasketPage(){
        PageFactory.initElements(getDriver(), this);
    }


    public void verifyBookOnList(String shown) {
        if (shown.equals("is")){
            AssertionUtils.assertPresent(bookImage);
        }

    }

    public void verifyItemTitleInBasket(String title) {
        AssertionUtils.assertEquals(basketProductTitle,title);
    }

    public void verifyItemTypeInBasket(String type) {
        AssertionUtils.assertEquals(basketProductType,type);
    }

    public void verifyItemsInBasket(int quantity) {
        AssertionUtils.assertEquals(basketProductQuantity,quantity);
    }

    public void verifyBasketItemPrice(String price, String currency) {
        if(currency.equals("pounds")){
            price = "£"+price;
        }
        AssertionUtils.assertEquals(basketItemPrice,price);
    }

    public void verifyBasketTotalPrice(String price, String currency) {

        if(currency.equals("pounds")){
            price = "£"+price;
        }
        AssertionUtils.assertEquals(basketTotalPrice,price);
    }
}
