package epam.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FunpayMainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id="header"]/div/nav/div[2]/div[1]/form/div/div/div[1]/div/div/div[2]/div/div/div/div/a")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id="content"]/div/div[3]/div/div[2]/div[2]/div/div[3]")
    private WebElement searchButton;

    public FunpayMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://funpay.com/");
    }

    public void searchForItem(String itemName) {
        searchInput.sendKeys(itemName);
        searchButton.click();
    }

    public List<Integer> getPrices() {
        By priceSelector = By.xpath("//*[@id="content"]/div/div[3]/div/div[2]/div[2]/a[1]/div[2]/div/div[1]/div");
        List<WebElement> priceElements = driver.findElements(priceSelector);
        List<Integer> prices = new ArrayList<>();

        for (WebElement element : priceElements) {
            String priceText = element.getText().replaceAll("[^0-9]", "");
            prices.add(Integer.parseInt(priceText));
        }

        return prices;
    }
}
