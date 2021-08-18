import org.openqa.selenium.By;

public class NextBusPage {
    public By iframeNextBus = By.xpath(".//iframe[@title='Next Bus']");
    public By eastButton = By.xpath("//a[@href=\"/text/route/099/direction/EAST\"]");
    public By addFavButton = By.xpath("//button[@data-type =\"unstyledButton\" and contains(., 'Add Fav')]");
    public By addToFavDialog = By.xpath("//dialog[@id=\"add-to-favourites_dialog\"]");
    public By addToFavDialogTextArea = By.xpath("//textarea[@name = \"newFavourite\"]");
    public By addToFavDialogConfirm = By.xpath("//dialog[@id=\"add-to-favourites_dialog\"]//button[@value =\"confirm\"]");
    public By myFavButton = By.xpath("//a[@href=\"/next-bus/favourites\" and contains(.,\"My Favs\") ]");
    public By route99CBtoUBC = By.xpath("//div[@class= \"txtRouteTitle\" and text() = \"99 Commercial-Broadway / UBC (B-Line)\"]");
    public By routeTitle = By.xpath("//div[@class= \"txtRouteTitle\"]");
    public By exchangeBay7 = By.xpath("//a[@href=\"/text/stop/61935/route/099\"]");
    public By stopNumber = By.xpath("//div[@class=\"stopNo\"]");
    public By stop61935 = By.xpath("//div[@class=\"stopNo\" and text() = \"Stop # 61935\"] ");
}