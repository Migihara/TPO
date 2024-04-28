package epam.lab9;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "D:\\6\\TPO\\Drivers\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://funpay.com/");

        By searchInputSelector = By.xpath("//*[@id='header']/div/nav/div[2]/div[1]/form/div/div/div[1]/div/div/div[2]/div/div/div/div/a");
        By searchButtonSelector = By.xpath("//*[@id='content']/div/div[3]/div/div[2]/div[2]/div/div[3]");

        WebElement searchInput = driver.findElement(searchInputSelector);
        WebElement searchButton = driver.findElement(searchButtonSelector);

        searchInput.sendKeys("Baldur's Gate 3");
        searchButton.click();

        Thread.sleep(5000);

        By linkToProductPageSelector = By.xpath("//*[@id='content']/div/div[3]/div/div[2]/div[2]/a[1]/div[2]/div/div[1]/div");
        WebElement linkToProductPage = driver.findElement(linkToProductPageSelector);

        Thread.sleep(5000);

        String href = linkToProductPage.getAttribute("href");
        driver.get(href);

        Thread.sleep(2000);

        driver.quit();
    }
}
