package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//p[contains(@class,'PromoHeadline')]//span")
    private List<WebElement> articlesList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getArticlesList() {
        return articlesList;
    }

}
