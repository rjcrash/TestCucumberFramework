package com.automation.pages;

import com.automation.utils.AssertionUtils;
import com.automation.utils.CommonUtils;
import com.automation.utils.ConfigUtils;
import com.automation.utils.WebElementUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.utils.DriverUtils.getDriver;

public class HomePage {

    @FindBy(id = "searchDropdownBox")
    private  WebElement searchDropdownBox;

    @FindBy(id = "twotabsearchtextbox")
    private  WebElement searchTextBox;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    private  WebElement firstSearchedItemTitle;

    @FindBy(xpath = "(//a/span[@class='a-size-base'])[1]")
    private  WebElement firstSearchedItemBadges;

    @FindBy(xpath = "(//a[@class='a-size-base a-link-normal s-link-style a-text-bold'])[1]")
    private  WebElement firstSearchedItemType;

    @FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
    private  WebElement firstSearchedItemWholePrice;

    @FindBy(xpath = "(//span[@class='a-price-fraction'])[1]")
    private  WebElement firstSearchedItemFractionPrice;

    @FindBy(xpath = "(//span[@class='a-price-symbol'])[1]")
    private  WebElement firstSearchedItemSymbolPrice;
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void navigateToHomePage() {
        getDriver().get(ConfigUtils.getURL());
    }

    public void searchForItem(String section, String item){
       WebElementUtils.selectValueFromDropDownByVisibleTxt(searchDropdownBox, section);
       AssertionUtils.assertEquals(WebElementUtils.getSelectedOptionFromDropDown(searchDropdownBox),section);

       CommonUtils.sendKeysTo(searchTextBox,item + Keys.ENTER);
    }

    public void verifyTitleContains(String item){
        AssertionUtils.assertContains(firstSearchedItemTitle,item);
    }

    public void verifyAnyBadges(String badge) {
        AssertionUtils.assertNotEquals(firstSearchedItemBadges,badge);
    }
    public void verifyType(String type) {
        AssertionUtils.assertEquals(firstSearchedItemType,type);
    }

    public void verifyPrice(String price, String currency) {

        if(currency.equals("pounds")){
            AssertionUtils.assertEquals(firstSearchedItemSymbolPrice,"£");
        }

        String[] parts = price.split("\\.");

        String wholePrice = parts[0];
        String fractionPrice = parts[1];
        System.out.println(wholePrice);
        System.out.println(fractionPrice);
        AssertionUtils.assertEquals(firstSearchedItemWholePrice,wholePrice);
        AssertionUtils.assertEquals(firstSearchedItemFractionPrice,fractionPrice);
    }

    public void navigateToFirstBookDetails() {
        CommonUtils.clickOnElement(firstSearchedItemTitle);
    }

    public void verifyPageTitle(String title) {
        AssertionUtils.assertPageTitle(title);
    }
}
