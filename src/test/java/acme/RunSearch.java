package acme;

import acme.pages.GoogleHomePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class RunSearch {
    @Test
    public void searchingForCheese() {
        WebDriver driver = new HtmlUnitDriver();

        final GoogleHomePage page = GoogleHomePage.navigateToPageUsing(driver);

        page.searchFor("cheese");

        Assert.assertTrue("+++ Out of cheese error +++", driver.findElement(By.tagName("body")).getText().contains("cheese"));
    }
}
