package epam.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div/nav/div[2]/div[1]/form/div/div/div[1]/div/div/div[2]/div/div/div/div/a")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/div/div[2]/div[2]/div/div[3]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id="content"]/div/div[3]/div/div[2]/div[2]/a[1]/div[2]/div/div[1]/div")
    private WebElement menuElement;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://funpay.com/");
    }

    public void search(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
    }

    public void clickOnMenuElement() {
        menuElement.click();
    }
}
