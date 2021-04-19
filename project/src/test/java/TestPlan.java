import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();


    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);

    }

    @Test
    public static void testProject() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.clickDevices();
        webForm.sortByDeviceApple();
        webForm.sortByGold();
        webForm.selectApplePhone();
        webForm.selectPricePlan();
        webForm.addToBasket();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@class='vivacom-icon icon-shopping_cart']/following-sibling::h2")));

        String actualString = driver.findElement(By.xpath("//em[@class='vivacom-icon icon-shopping_cart']/following-sibling::h2")).getText();
        String expectedString = "Моята кошница";
        assertTrue(actualString.contains(expectedString));

        webForm.clickContinueShopping();

        webForm.clickAccessories();
        webForm.sortByDeviceApple();
        webForm.sortByPrice();
        webForm.clickAppleEarings();
        webForm.addToBasket();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@class='vivacom-icon icon-shopping_cart']/following-sibling::h2")));
        assertTrue(actualString.contains(expectedString));
        String exactSum = "2000";

        String sum = driver.findElement(By.xpath("//span[text()='Обща сума']/following-sibling::span")).getText().split("\n")[0].split(" ")[0];

        double val1 = convert(sum);
        double val2 = convert(exactSum);

        if(val1 > val2) {

            webForm.clickRemoveButton();

        }

        assertTrue(driver.findElement(By.xpath("//a[@href = '/online/bg/tac/view/category/mobile-termes-and-conditions']")).isDisplayed());
//        assertTrue(driver.findElement(By.xpath("//button[@class = 'btn btn-success js-checkout-btn disable-elm']")).isEnabled());
//        assertTrue(driver.findElement(By.xpath("//button[@class = 'btn btn-success js-support-checkout-btn disable-elm']")).isEnabled());

        webForm.clickConditionsMobile();

//        assertTrue(driver.findElement(By.xpath("//button[@class = 'btn btn-success js-checkout-btn disable-elm']")).isDisplayed());
//        assertTrue(driver.findElement(By.xpath("//button[@class = 'btn btn-success js-support-checkout-btn disable-elm']")).isDisplayed());

        webForm.clickRemoveButton();

        String emptyBasket = driver.findElement(By.xpath("//div[@class ='empty-shopping-cart']")).getText();
        String exacrEmptyBaskettext = "В момента кошницата ви е празна\n" +
                "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".";
        assertTrue(emptyBasket.contains(exacrEmptyBaskettext));


    }



    public static double convert(String str){
        double val = 0;

        try {
            val = Double.parseDouble(str);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid String");
        }
        return val;
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();

    }

}
