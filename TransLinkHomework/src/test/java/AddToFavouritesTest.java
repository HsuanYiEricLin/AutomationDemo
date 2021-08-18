import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddToFavouritesTest {
    private WebDriver driver;
    private final TransLinkLandingPage transLinkLandingPage = new TransLinkLandingPage();
    private final NextBusPage nextBusPage = new NextBusPage();
    private final String destination = "99 Commercial-Broadway / UBC (B-Line)";
    private final String stopNumber = "Stop # 61935";

    @BeforeSuite
    public void main(){
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver  = new ChromeDriver();
    }

    @Test
    public void searchForBus99() {
        // step 1 Launch any browser and goto https://new.translink.ca/
        driver.get(Utils.BASE_URL);
        // step 2.1 click on next bus tab
        driver.findElement(transLinkLandingPage.nextBusButton).click();
        // step 2.2 click to enter
        driver.findElement(transLinkLandingPage.busRouteSearchInput).click();
        // step 2.3 enter 99
        driver.findElement(transLinkLandingPage.busRouteSearchInput).sendKeys("99");
        // step 2.4 click "find my next bus"
        driver.findElement(transLinkLandingPage.findBusButton).click();
    }

    @Test(dependsOnMethods = { "searchForBus99" })
    public void addRouteToFavourites() {
        // step 3 click to add favourite
        driver.findElement(nextBusPage.addFavButton).click();
        // step 4 Enter "Translink Auto Homework" in the Edit name
        driver.findElement(nextBusPage.addToFavDialogTextArea).click();
        driver.findElement(nextBusPage.addToFavDialogTextArea).clear();
        driver.findElement(nextBusPage.addToFavDialogTextArea).sendKeys("Translink Auto Homework");
        // step 5 click on "Add to Favourites" button
        driver.findElement(nextBusPage.addToFavDialogConfirm).click();
    }

    @Test(dependsOnMethods = { "addRouteToFavourites" })
    public void validateFavouriteRoute() {
        // step 6 Click on "My Favs" icon
        //driver.findElement(nextBusPage.myFavButton).click();
        // step 7 Validate "Translink Auto Homework" link is present

        // step 8 Click on "Translink Auto Homework" link
    }

    @Test(dependsOnMethods = { "validateFavouriteRoute" })
    public void navigateToBusStop() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // going to iframe = "Next Bus"
        driver.switchTo().frame(driver.findElement(nextBusPage.iframeNextBus));
        // step 9 validate "99 Commercial-Broadway / UBC (B-Line)" is displayed
        WebElement routeTitle = driver.findElement(nextBusPage.routeTitle);
        Assert.assertTrue(routeTitle.isDisplayed(), destination + " should be displayed");
        Assert.assertEquals(routeTitle.getText(), destination, "destination should be " + destination);

        // step 10 click “Comm'l-Bdway Stn / Boundary B-Line”
        driver.findElement(nextBusPage.eastButton).click();
        // step 11 click on bay 7
        wait.until(ExpectedConditions.elementToBeClickable(nextBusPage.exchangeBay7));
        driver.findElement(nextBusPage.exchangeBay7).click();
        // added sleep for loading
        wait.until(ExpectedConditions.elementToBeClickable(nextBusPage.stopNumber));
        // validate "Stop #61935" is displaying
        WebElement stopNumberElement = driver.findElement(nextBusPage.stopNumber);
        Assert.assertTrue(stopNumberElement.isDisplayed(), stopNumber + " should be displayed");
        Assert.assertEquals(stopNumberElement.getText(), stopNumber , "stopNumber should be " + stopNumber);
    }

    @AfterSuite
    public void cleanUp(){
        driver.close();
    }
}
