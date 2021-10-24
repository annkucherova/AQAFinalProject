package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'news-wide-navigation')]//span[text()='Coronavirus']")
    private WebElement coronavirusButton;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//h3")
    private List<WebElement> headlineArticleList;

    @FindBy(xpath = "//div[contains(@data-entityid,'stories#')]//div[contains(@class,'1/1@m ')]//h3")
    private List<WebElement> secondaryArticlesList;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//a[contains(@class,'gs-c-section-link')]//span")
    private List<WebElement> headlineArticleCategoryLinkList;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='orb-search-button']")
    private WebElement searchButton;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCoronavirusButton() {
        coronavirusButton.click();
    }

    public WebElement getHeadlineArticle() {
        return headlineArticleList.get(0);
    }

    public WebElement getHeadlineArticleCategoryLink() {
        return headlineArticleCategoryLinkList.get(0);
    }


    public List<String> getSecondaryArticlesList() {
        List<String> textOfSecondaryArticlesList = new ArrayList<>();
        for (WebElement article : secondaryArticlesList) {
            String textOfArticle = article.getText();
            textOfSecondaryArticlesList.add(textOfArticle);
        }
        return textOfSecondaryArticlesList;
    }

    public void enterTextToSearchField(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

}
