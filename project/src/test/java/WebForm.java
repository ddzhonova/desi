import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject {

    @FindBy(xpath = "//*[@class = 'dropdown-toggle' and contains(text(), 'Устройства')]")
            private WebElement devices;

    @FindBy(xpath = "//a[contains(@href, '/online/bg/shop/devices/listing?navigation=product-category-smart-mobile-phones')]")
    private WebElement mobileDevices;

    @FindBy(xpath = "//a[contains(@href, '/online/bg/shop/devices/listing?navigation=product-category-accessories')]")
    private WebElement mobileAccessories;

    @FindBy(xpath = "//em[@class='vivacom-icon icon-box_empty analytics-skip']/following-sibling::span[contains(text(), 'APPLE')]")
    private WebElement checkboxApple;

    @FindBy(xpath = "//em[@class='vivacom-icon icon-box_empty analytics-skip']/following-sibling::span[contains(text(), 'между 5 и 40 лв.')]")
    private WebElement checkPriceRange;

    @FindBy(xpath = "//em[@class='vivacom-icon icon-box_empty analytics-skip']/following-sibling::span[contains(text(), 'GOLD')]")
    private WebElement checkboxGold;

    @FindBy(xpath = "//h3[@class='e-shop-devices-product-details-phone-grid-box-model' and contains(text(), 'APPLE IPHONE 12 PRO MAX 128GB')]")
    private WebElement applePhone;

    @FindBy(xpath = "//h3[@class='e-shop-devices-product-details-phone-grid-box-model' and contains(text(), 'APPLE СЛУШАЛКИ с LIGHTNING CONNECTOR')]")
    private WebElement appleEarings;

    @FindBy(xpath = "//span[@class ='e-care-home-big-bill-price-digits js-related-offer-cash-price-span' and contains(text(), '1979.98')]")
    private WebElement pricePlan;

    @FindBy(xpath = "//button[@class = 'btn btn-success js-add-to-cart-btn js-prevent-dblclick']")
    private WebElement basket;

    @FindBy(xpath = "//em[@class='vivacom-icon icon-shopping_cart']/following-sibling::h2")
    private WebElement basketText;

    @FindBy(name = "vivacom-cart-link-button-continue-shopping")
    private WebElement continueShopping;

    @FindBy(xpath = "//button[contains(@type,'submit')][1]")
    private WebElement removeProduct;

    @FindBy(xpath = "//em[@class = 'vivacom-icon icon-box_empty']/preceding-sibling::input[@id = 'leasing-terms-and-conditions']")
    private WebElement checkConditionsLeasing;

    @FindBy(xpath = "//em[@class = 'vivacom-icon icon-box_empty']")
    private WebElement checkConditionsMobile;


    public WebForm(WebDriver driver) {
        super(driver);

    }

    public void clickDevices(){
        this.devices.click();
        this.mobileDevices.click();
    }


    public void clickAccessories(){
        this.devices.click();
        this.mobileAccessories.click();
    }

    public void sortByDeviceApple(){
        this.checkboxApple.click();
    }

    public void sortByGold(){
        this.checkboxGold.click();
    }

    public void selectApplePhone(){
        this.applePhone.click();
    }

    public void selectPricePlan(){
        this.pricePlan.click();
    }
    public void addToBasket(){
        this.basket.click();
    }

    public void clickContinueShopping(){
        this.continueShopping.click();
    }

    public void sortByPrice(){
        this.checkPriceRange.click();
    }

    public void clickAppleEarings(){
        this.appleEarings.click();
    }

    public void clickRemoveButton(){
        this.removeProduct.click();
    }

    public void clickConditionsLeasing(){
        this.checkConditionsLeasing.click();
    }

    public void clickConditionsMobile(){
        this.checkConditionsMobile.click();
    }
}
