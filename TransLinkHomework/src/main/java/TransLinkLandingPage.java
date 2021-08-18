import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransLinkLandingPage {
    public By nextBusButton = By.xpath("//button[@id=\"next-bus\"] ");
    public By busRouteSearchInput = By.xpath("//input[@id=\"NextBusSearchTerm\"]");
    public By findBusButton = By.xpath("//button[@type=\"submit\" and @form=\"NextBusSearch\"]");
}

