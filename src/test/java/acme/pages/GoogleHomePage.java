package acme.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class GoogleHomePage {
    private static final String url = "http://www.google.com";
    private final WebDriver driver; // Do we need to store this? Keep checks out of these objects!

    @FindBy(name = "q")
    private WebElement searchField;

    public static GoogleHomePage navigateToPageUsing(WebDriver driver) {
        driver.get(url);
        return new GoogleHomePage(driver);
    }

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        assertTrue("This is not the Google front page!", this.driver.getTitle().contains("Google"));

        PageFactory.initElements(driver, this);
    }

    public GoogleHomePage searchFor(String text) {
        searchField.sendKeys(text);
        searchField.submit();
        return new GoogleHomePage(driver);
    }
}
