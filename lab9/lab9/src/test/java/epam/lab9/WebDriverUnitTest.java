package epam.lab9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WebDriverUnitTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "D:\\6\\TPO\\Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void testSearchAndNavigateToProductPage() throws InterruptedException {
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
        assertNotNull(linkToProductPage);

        String href = linkToProductPage.getAttribute("href");
        driver.get(href);
        Thread.sleep(2000);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
